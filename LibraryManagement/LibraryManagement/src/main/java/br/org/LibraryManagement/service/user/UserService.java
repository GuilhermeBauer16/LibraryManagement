package br.org.LibraryManagement.service.user;

import br.org.LibraryManagement.DAO.AddressDAO.AddressDAO;
import br.org.LibraryManagement.DAO.BankDAO.BankDAO;
import br.org.LibraryManagement.domain.model.address.AddressModel;
import br.org.LibraryManagement.domain.model.bank.BankModel;
import br.org.LibraryManagement.domain.model.books.BooksModel;
import br.org.LibraryManagement.domain.model.users.UserModel;
import br.org.LibraryManagement.exception.EmailIsNotValid;
import br.org.LibraryManagement.service.address.AddressService;
import br.org.LibraryManagement.service.bank.BankService;
import br.org.LibraryManagement.util.CreateParameter;
import br.org.LibraryManagement.util.EmailCheck;

import java.util.List;

public class UserService {

    public static UserModel createUser(AddressDAO addressDAO, BankDAO bankDAO) throws EmailIsNotValid {
        System.out.println("New User");
        String username = CreateParameter.createString("Name: ");
        String password = CreateParameter.createString("Password: ");
        String email = CreateParameter.createString("Email: ");
        checkUserEmail(email);
        BankModel bankModel = bankDAO.insert();
        AddressModel addressModel = addressDAO.insert();
        return new UserModel(username, password, email, addressModel, bankModel);

    }

    public static UserModel editUser(UserModel userModel, BankDAO bankDAO, AddressDAO addressDAO) {
        System.out.println("Edit User ");
        String username = CreateParameter.createString("Name: ");
        bankDAO.editBank(userModel.getBank());
        addressDAO.editAddress(userModel.getAddress());

        if (!username.isEmpty()) {

            userModel.setUsername(username);
        }

        return userModel;
    }


    public static String checkUserEmail(String email) throws EmailIsNotValid {
        if (!EmailCheck.isValidEmail(email)) {
            throw new EmailIsNotValid("Please type a valid email", " Maybe the user don't type the @");
        }
        return email;
    }

    public static void showUserBooks(UserModel userModel) {
        List<BooksModel> books = userModel.getBooks();

        for (BooksModel book : books) {

            System.out.println(book.toString());


        }
    }
}
