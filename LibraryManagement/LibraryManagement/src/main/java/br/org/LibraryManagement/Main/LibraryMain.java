package br.org.LibraryManagement.Main;

import br.org.LibraryManagement.DAO.BooksDAO.BooksDAO;
import br.org.LibraryManagement.domain.model.users.UserModel;
import br.org.LibraryManagement.service.book.BookService;
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
            System.out.println("=/".repeat(30));
            System.out.println("Welcome to Bauer Library");
            System.out.println("=/".repeat(30));
            System.out.println("What you would like to do:");
            System.out.println("=/".repeat(30));
            System.out.println("[1]See all the books ");
            System.out.println("[2]Filter book by category ");
            System.out.println("[3]Filter book by name ");
            System.out.println("[4]Buy a book ");
            System.out.println("[5]See the book what you already bought ");
            System.out.println("[6]Return to menu... ");
            System.out.println("=/".repeat(30));
            int libraryMenuOptions = CreateParameter.createInt("Choose a option: ");

            switch (libraryMenuOptions) {
                case 1:
                    BookService.listBooksAvailable();
                    break;

                case 2:
                    booksDAO.findByCategory();
                    break;

                case 3:
                    booksDAO.findBookByName();
                    break;

                case 4:
                    booksDAO.buyTheBook(userModel);
                    break;

                case 5:
                    UserService.showUserBooks(userModel);
                    break;

                case 6:
                    System.out.println("Returning to menu! ");
                    return;

                default:
                    System.out.println("Please type a valid option! ");
                    break;
            }

        }
    }

}

