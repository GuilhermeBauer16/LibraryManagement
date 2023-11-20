package br.org.LibraryManagement.DAO.userDAO;

import br.org.LibraryManagement.domain.model.users.UserModel;
import br.org.LibraryManagement.exception.LoginNotFoundException;
import br.org.LibraryManagement.service.user.UserService;
import br.org.LibraryManagement.util.CreateParameter;

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
        if (!user.getPassword().equals(password)){
            throw new LoginNotFoundException("Error in do the login ", " Probable the user typed the email or password incorrect!  ");
        }
        return user;
    }

    public String showUserDetails(UserModel userModel){
        return userModel.toString();
    }
}
