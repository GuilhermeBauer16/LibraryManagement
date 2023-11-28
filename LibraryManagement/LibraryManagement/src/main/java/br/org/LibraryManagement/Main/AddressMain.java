package br.org.LibraryManagement.Main;

import br.org.LibraryManagement.DAO.AddressDAO.AddressDAO;
import br.org.LibraryManagement.domain.model.users.UserModel;
import br.org.LibraryManagement.exception.PasswordIncorrect;
import br.org.LibraryManagement.service.address.AddressService;
import br.org.LibraryManagement.util.CreateParameter;
import br.org.LibraryManagement.util.EncryptPassword;
import org.jasypt.exceptions.EncryptionInitializationException;

import javax.persistence.CacheRetrieveMode;
import javax.persistence.EntityManager;

public class AddressMain {

    private EntityManager entityManager;
    private UserModel userModel;

    public AddressMain(EntityManager entityManager, UserModel userModel) {
        this.entityManager = entityManager;
        this.userModel = userModel;
    }


    public void startAddressMain() throws PasswordIncorrect {
        AddressDAO addressDAO = new AddressDAO(entityManager);
        EncryptPassword encryptPassword = new EncryptPassword();
        encryptPassword.checkingIfThePasswordsAreEquals(userModel.getPassword());
        while (true){
            System.out.println("=/".repeat(30));
            System.out.println("Address Manager");
            System.out.println("=/".repeat(30));
            System.out.println("[1] Edit Address");
            System.out.println("[2] See your information");
            System.out.println("[3] Return to menu");
            System.out.println("=/".repeat(30));

            int addressMenuOptions = CreateParameter.createInt("Choose one of menu options: ");
            switch (addressMenuOptions){
                case 1:
                    addressDAO.editAddress(userModel.getAddress());
                    break;

                case 2:
                    System.out.println(AddressService.showUserAddress(userModel.getAddress()));
                    break;

                case 3:
                    System.out.println("Returning to menu...");
                    return;
            }

        }
    }
}
