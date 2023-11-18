package br.org.LibraryManagement.service.user;

import br.org.LibraryManagement.domain.model.DAO.AddressDAO.AddressDAO;
import br.org.LibraryManagement.domain.model.DAO.BankDAO.BankDAO;
import br.org.LibraryManagement.domain.model.address.AddressModel;
import br.org.LibraryManagement.domain.model.bank.BankModel;
import br.org.LibraryManagement.domain.model.users.UserModel;
import br.org.LibraryManagement.exception.EmailIsNotValid;
import br.org.LibraryManagement.service.address.AddressService;
import br.org.LibraryManagement.service.bank.BankService;
import br.org.LibraryManagement.util.CreateParameter;
import br.org.LibraryManagement.util.EmailCheck;

import javax.persistence.EntityManager;

public class UserService {

    public static UserModel createUser(AddressDAO addressDAO, BankDAO bankDAO) throws EmailIsNotValid {

        String username = CreateParameter.createString("Name: ");
        String password = CreateParameter.createString("Password: ");
        String email = CreateParameter.createString("Email: ");
        checkUserEmail(email);
        BankModel bankModel = bankDAO.insert();
        AddressModel addressModel = addressDAO.insert();
        return new UserModel(username, password, email, addressModel, bankModel);

    }

    public static void editUser(UserModel userModel) {

        if (userModel.getUsername() != null) {
            String username = CreateParameter.createString("Name: ");
            userModel.setUsername(username);
        }

        if (userModel.getEmail() != null) {
            String email = CreateParameter.createString("Email: ");
            userModel.setEmail(email);
        }
        if (userModel.getPassword() != null) {
            String password = CreateParameter.createString("Password: ");
            userModel.setPassword(password);
        }

        if (userModel.getAddress() != null) {
            AddressModel addressModel = AddressService.editAddress(userModel.getAddress());
            userModel.setAddress(addressModel);
        }

        if (userModel.getBank() != null) {
            BankModel bankModel = BankService.editBankAccount(userModel.getBank());
            userModel.setBank(bankModel);
        }

    }

    public static String checkUserEmail(String email) throws EmailIsNotValid {
        if(!EmailCheck.isValidEmail(email)){
            throw new EmailIsNotValid("Please type a valid email", " Maybe the user don't type the @");
        }
        return email;
    }


}
