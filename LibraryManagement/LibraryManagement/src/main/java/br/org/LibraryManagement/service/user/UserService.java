package br.org.LibraryManagement.service.user;

import br.org.LibraryManagement.DAO.AddressDAO.AddressDAO;
import br.org.LibraryManagement.DAO.BankDAO.BankDAO;
import br.org.LibraryManagement.domain.model.address.AddressModel;
import br.org.LibraryManagement.domain.model.bank.BankModel;
import br.org.LibraryManagement.domain.model.books.BooksModel;
import br.org.LibraryManagement.domain.model.users.UserModel;
import br.org.LibraryManagement.exception.EmailNotValid;
import br.org.LibraryManagement.exception.PasswordIncorrect;
import br.org.LibraryManagement.util.CreateParameter;
import br.org.LibraryManagement.util.EmailCheck;
import br.org.LibraryManagement.util.EncryptPassword;

import java.util.List;

public class UserService {

    public static UserModel createUser(AddressDAO addressDAO, BankDAO bankDAO) throws EmailNotValid, PasswordIncorrect {
        EncryptPassword encryptPassword = new EncryptPassword();
        System.out.println("=/".repeat(30));
        System.out.println("New User");
        System.out.println("=/".repeat(30));

        String username = CreateParameter.createString("Name: ");
        String password = CreateParameter.createString("Password: ");
        String encryptedPassword = encryptPassword.encryptedPassword(password);
        String email = CreateParameter.createString("Email: ");
        checkUserEmail(email);
        BankModel bankModel = bankDAO.insert();
        AddressModel addressModel = addressDAO.insert();
        System.out.println("=/".repeat(30));
        return new UserModel(username, encryptedPassword, email, addressModel, bankModel);

    }

    public static UserModel editUser(UserModel userModel) throws PasswordIncorrect {

        EncryptPassword encryptPassword = new EncryptPassword();
        encryptPassword.checkingIfThePasswordsAreEquals(userModel.getPassword());
        System.out.println("Edit User ");
        String username = CreateParameter.createString("Name: ");

        if (!username.isEmpty()) {
            userModel.setUsername(username);
        }

        return userModel;
    }


    public static String checkUserEmail(String email) throws EmailNotValid {
        if (!EmailCheck.isValidEmail(email)) {
            throw new EmailNotValid("Please type a valid email", " Maybe the user don't type the @");
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
