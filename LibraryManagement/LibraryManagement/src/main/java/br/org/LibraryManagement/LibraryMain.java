package br.org.LibraryManagement;

import br.org.LibraryManagement.DAO.BooksDAO.BooksDAO;
import br.org.LibraryManagement.domain.model.users.UserModel;
import br.org.LibraryManagement.service.user.UserService;
import br.org.LibraryManagement.util.CreateParameter;

import javax.persistence.EntityManager;

public class LibraryMain {
    private static EntityManager entityManager;
    private UserModel userModel;


    public LibraryMain(EntityManager entityManager, UserModel userModel) {
        this.entityManager = entityManager;
        this.userModel = userModel;
    }

    public void startLibrary() throws Exception {


        BooksDAO booksDAO = new BooksDAO(entityManager);



        while (true) {

            System.out.println("Welcome to Bauer Library");
            System.out.println("Why you would like to do:");

            System.out.println("[1]See all the books ");
            System.out.println("[2]Filter book by category ");
            System.out.println("[3]Buy a book ");
            System.out.println("[4]See the book what you already bought ");

            int libraryMenuOptions = CreateParameter.createInt("Choose a option: ");
            if (libraryMenuOptions == 1) {

                booksDAO.showAllBooks();
            }

            if (libraryMenuOptions == 2) {

                booksDAO.findByCategory();
            }

            if (libraryMenuOptions == 3){

                booksDAO.buyTheBook(userModel);
            }

            if (libraryMenuOptions == 4){

                UserService.showUserBooks(userModel);
            }
        }
    }

}

