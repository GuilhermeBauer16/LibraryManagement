package br.org.LibraryManagement.service.user;

import br.org.LibraryManagement.domain.model.address.AddressModel;
import br.org.LibraryManagement.domain.model.bank.BankModel;
import br.org.LibraryManagement.domain.model.users.UserModel;
import br.org.LibraryManagement.service.address.AddressService;
import br.org.LibraryManagement.service.bank.BankService;
import br.org.LibraryManagement.util.CreateParameter;

public class UserService {

    public static void editUser(UserModel userModel){

        if (userModel.getUsername() != null ) {
            String username = CreateParameter.createString("Name: ");
            userModel.setUsername(username);
        }

        if (userModel.getEmail() != null ) {
            String email = CreateParameter.createString("Email: ");
            userModel.setEmail(email);
        }
        if (userModel.getPassword() != null ) {
            String password = CreateParameter.createString("Password: ");
            userModel.setPassword(password);
        }

        if (userModel.getAddress() != null ) {
            AddressModel addressModel = AddressService.editAddress(userModel.getAddress());
            userModel.setAddress(addressModel);
        }

        if (userModel.getBank() != null ) {
            BankModel bankModel = BankService.editBankAccount(userModel.getBank());
            userModel.setBank(bankModel);
        }

    }




}
