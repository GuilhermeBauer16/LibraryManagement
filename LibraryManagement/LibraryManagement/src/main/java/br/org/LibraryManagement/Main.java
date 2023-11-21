package br.org.LibraryManagement;


import br.org.LibraryManagement.DAO.AddressDAO.AddressDAO;
import br.org.LibraryManagement.DAO.BankDAO.BankDAO;
import br.org.LibraryManagement.DAO.userDAO.UserDAO;
import br.org.LibraryManagement.domain.model.users.UserModel;
import br.org.LibraryManagement.service.address.AddressService;
import br.org.LibraryManagement.service.user.UserService;
import br.org.LibraryManagement.util.CreateParameter;
import br.org.LibraryManagement.util.JPAUtil;
import javax.persistence.*;

public class Main {
    public static void main(String[] args) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManager();
        AddressDAO addressDAO = new AddressDAO(entityManager);
        BankDAO bankDAO = new BankDAO(entityManager);
        UserDAO userDAO = new UserDAO(entityManager);
        System.out.println("Login Page ");
        System.out.println("[1] New user");
        System.out.println("[2] Login");
        int loginOption = CreateParameter.createInt("Type your option: ");
        UserModel user;

        while (true) {

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

            System.out.println("Please type a valid option!");
        }

        while (true){

            System.out.println("Menu");
            System.out.println("[1]Enter in the Bauer Library");
            System.out.println("[2]Manager the user");
            System.out.println("[3]Manager the user Bank account");
            System.out.println("[4]Manager the user Address");
            System.out.println("[5]Exit");
            int optionsMainMenu = CreateParameter.createInt("Choose the one option: ");

            switch (optionsMainMenu){
                case 1:
                    LibraryMain libraryMain = new LibraryMain(entityManager,user);
                    libraryMain.startLibrary();
                    break;

                case 2:
                    UserMain userMain = new UserMain(entityManager,user);
                    userMain.startManagerUserMain();
                    break;

                case 5:
                    System.out.println("Exiting the system...");
                    return;
            }

        }



    }
}