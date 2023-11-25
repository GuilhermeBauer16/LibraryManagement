package br.org.LibraryManagement.Main;

import br.org.LibraryManagement.DAO.BooksDAO.BooksDAO;
import br.org.LibraryManagement.domain.model.books.BooksModel;
import br.org.LibraryManagement.service.book.BookService;
import br.org.LibraryManagement.util.CreateParameter;

import javax.persistence.EntityManager;

public class LibraryManagementMain {

    private EntityManager entityManager;

    public LibraryManagementMain(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void startLibraryManagement() throws Exception {
        BooksDAO booksDAO = new BooksDAO(entityManager);
        while (true) {
            System.out.println("Library Management ");
            System.out.println("[1] Insert a new book ");
            System.out.println("[2] Delete a book ");
            System.out.println("[3] Edit book information ");
            System.out.println("[4] See all books ");
            System.out.println("[5] filter book by category ");
            System.out.println("[6] filter book by name ");
            System.out.println("[7] See books no available ");
            System.out.println("[8] Returning to menu ");

            int libraryManagementOptions = CreateParameter.createInt("Choose a option: ");

            switch (libraryManagementOptions) {
                case 1:
                    booksDAO.insert();
                    break;

                case 2:
                    booksDAO.deleteBook();
                    break;

                case 3:
                    booksDAO.editBook();
                    break;
                case 4:
                    BookService.listBooksAvailable();
                    break;
                case 5:
                    booksDAO.findByCategory();
                    break;

                case 6:
                    BooksModel book = booksDAO.findBookByName();
                    System.out.println(BookService.showBookByName(book));
                    break;

                case 7:
                    System.out.println("If you wanted to turn one of this books available add at least 1 to your quantity");
                    BookService.listBookNoAvailable();
                    break;
                case 8:
                    System.out.println("returning to Menu ");
                    return;

                default:
                    System.out.println("Please type a valid option");

            }
        }
    }
}
