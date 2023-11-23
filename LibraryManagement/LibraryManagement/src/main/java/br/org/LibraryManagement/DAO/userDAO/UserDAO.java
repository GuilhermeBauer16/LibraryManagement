package br.org.LibraryManagement.DAO.userDAO;

import br.org.LibraryManagement.DAO.AddressDAO.AddressDAO;
import br.org.LibraryManagement.DAO.BankDAO.BankDAO;
import br.org.LibraryManagement.domain.model.address.AddressModel;
import br.org.LibraryManagement.domain.model.bank.BankModel;
import br.org.LibraryManagement.domain.model.users.UserModel;
import br.org.LibraryManagement.exception.LoginNotFoundException;
import br.org.LibraryManagement.service.user.UserService;
import br.org.LibraryManagement.util.CreateParameter;
import br.org.LibraryManagement.util.EncryptPassword;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UserDAO {

    private static EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public UserModel insert(UserModel userModel) throws Exception {
        try {

            entityManager.getTransaction().begin();
            entityManager.persist(userModel);
            entityManager.getTransaction().commit();
            return userModel;
        }catch (Exception ex){
            entityManager.getTransaction().rollback();
            throw new Exception("Error to create a user! " + ex.getMessage());
        }
    }

    public static UserModel findUserByEmail(){
        UserModel user = null;
        try {

            String email = CreateParameter.createString("Type your email: ");
            String jpql = "SELECT UM FROM UserModel UM WHERE UM.email = :email";
            TypedQuery<UserModel> query = entityManager.createQuery(jpql,UserModel.class);
            query.setParameter("email",email );
            user = query.getSingleResult();
        }catch (Exception ex){
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Have a error in to find de user! " + ex.getMessage());
        }

        return user;

    }

    public UserModel checkUserLogin() throws LoginNotFoundException {
        UserModel user = findUserByEmail();
        String password = CreateParameter.createString("Type your password: ");
        EncryptPassword encryptPassword = new EncryptPassword();
        String decryptedPassword = encryptPassword.decryptedPassword(user.getPassword());
        if (!decryptedPassword.equals(password)){
            throw new LoginNotFoundException("Error in do the login ", " Probable the user typed the email or password incorrect!  ");
        }
        return user;
    }

    public UserModel editUser(UserModel userModel) throws Exception {

        try{
            entityManager.getTransaction().begin();
            entityManager.merge(UserService.editUser(userModel));
            entityManager.getTransaction().commit();
            return userModel;
        }catch (Exception ex){
            entityManager.getTransaction().rollback();
            throw new Exception("Have a error in edit the user! " + ex.getMessage());
        }
    }

    public void deleteUser(UserModel userModel){
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(userModel);
            entityManager.getTransaction().commit();
        }catch (Exception ex){
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Have a error in delete the user!");
        }
    }

    public String showUserDetails(UserModel userModel){
        return userModel.toString();
    }
}
