package br.org.LibraryManagement;

import br.org.LibraryManagement.DAO.AddressDAO.AddressDAO;
import br.org.LibraryManagement.DAO.BankDAO.BankDAO;
import br.org.LibraryManagement.DAO.userDAO.UserDAO;
import br.org.LibraryManagement.domain.model.address.AddressModel;
import br.org.LibraryManagement.domain.model.users.UserModel;
import br.org.LibraryManagement.exception.UserDeleted;
import br.org.LibraryManagement.util.CreateParameter;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

public class UserMain {

    private EntityManager entityManager;

    private UserModel userModel;

    public UserMain(EntityManager entityManager, UserModel userModel) {
        this.entityManager = entityManager;
        this.userModel = userModel;
    }

    public void startManagerUserMain() throws Exception {
        while (true) {
            UserDAO userDAO = new UserDAO(entityManager);
            System.out.println("Manager the user");
            System.out.println("[1]Edit user");
            System.out.println("[2]Delete user ");
            System.out.println("[3]See user information");
            System.out.println("[4] return to menu");

            int userMenuOptions = CreateParameter.createInt("Please choose the option: ");

            switch (userMenuOptions) {

                case 1:
                    userDAO.editUser(userModel);
                    break;

                case 2:
                    userDAO.deleteUser(userModel);
                    throw new UserDeleted("User deleted!",
                            "This user has deleted, please make login with other user");

                case 3:
                    System.out.println(userDAO.showUserDetails(userModel));
                    break;

                case 4:
                    System.out.println("returning to menu...");
                    return;

                default:
                    System.out.println("Please type a valid option!");
            }


        }
    }
}
