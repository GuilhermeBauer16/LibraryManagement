package br.org.LibraryManagement.Main;


import br.org.LibraryManagement.DAO.AddressDAO.AddressDAO;
import br.org.LibraryManagement.DAO.BankDAO.BankDAO;
import br.org.LibraryManagement.DAO.userDAO.UserDAO;
import br.org.LibraryManagement.domain.model.users.UserModel;
import br.org.LibraryManagement.service.user.UserService;
import br.org.LibraryManagement.util.CreateParameter;
import br.org.LibraryManagement.util.JPAUtil;
import br.org.LibraryManagement.util.LibraryManagementEnv;

import javax.persistence.*;

public class Main {


    public static void main(String[] args) throws Exception {

        EntityManager entityManager = JPAUtil.getEntityManager();
        AddressDAO addressDAO = new AddressDAO(entityManager);
        BankDAO bankDAO = new BankDAO(entityManager);
        UserDAO userDAO = new UserDAO(entityManager);

        UserModel user;

        while (true) {
            System.out.println("=/".repeat(30));
            System.out.println("Login Page ");
            System.out.println("=/".repeat(30));
            System.out.println("[1] New user");
            System.out.println("[2] Login");
            System.out.println("[3] Manager library (only for admins) ");
            System.out.println("=/".repeat(30));
            int loginOption = CreateParameter.createInt("Type your option: ");

            if (loginOption == 1) {
                userDAO.insert(UserService.createUser(addressDAO, bankDAO));
                System.out.println("Your user has registered with successful!");
                System.out.println("Please make a login ");
                user = userDAO.checkUserLogin();
                break;
            }
            if (loginOption == 2) {
                user = userDAO.checkUserLogin();
                break;
            }

            if (loginOption == 3) {
                String password = CreateParameter.createString("type the root password: ");
                LibraryManagementEnv.checkingIfEnvironmentVariableIsEqual(password);
                LibraryManagementMain libraryManagementMain = new LibraryManagementMain(entityManager);
                libraryManagementMain.startLibraryManagement();

            }


            System.out.println("Please type a valid option!");
        }

        while (true) {

            System.out.println("=/".repeat(30));
            System.out.println("Menu");
            System.out.println("=/".repeat(30));
            System.out.println("[1]Enter in the Bauer Library");
            System.out.println("[2]Manager the user");
            System.out.println("[3]Manager the user Bank account");
            System.out.println("[4]Manager the user Address");
            System.out.println("[5]Exit to system");
            System.out.println("=/".repeat(30));

            int optionsMainMenu = CreateParameter.createInt("Choose the one option: ");

            switch (optionsMainMenu) {
                case 1:
                    LibraryMain libraryMain = new LibraryMain(entityManager, user);
                    libraryMain.startLibrary();
                    break;

                case 2:
                    UserMain userMain = new UserMain(entityManager, user);
                    userMain.startManagerUserMain();
                    break;

                case 3:
                    BankMain bankMain = new BankMain(entityManager, user);
                    bankMain.startBankMain();
                    break;

                case 4:
                    AddressMain addressMain = new AddressMain(entityManager, user);
                    addressMain.startAddressMain();
                    break;

                case 5:
                    System.out.println("Exiting the system...");
                    return;
            }

        }


    }
}