package br.org.LibraryManagement.DAO.BooksDAO;

import br.org.LibraryManagement.domain.model.books.BooksCategory;
import br.org.LibraryManagement.domain.model.books.BooksModel;
import br.org.LibraryManagement.domain.model.users.UserModel;
import br.org.LibraryManagement.exception.BookNotAvailable;
import br.org.LibraryManagement.exception.BookNotFound;
import br.org.LibraryManagement.service.book.BookService;
import br.org.LibraryManagement.util.CreateParameter;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class BooksDAO {

    private static EntityManager entityManager;

    public BooksDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert() throws BookNotAvailable {

        BooksModel book = BookService.createBook();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(book);
            entityManager.getTransaction().commit();

        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Error to creating the book" + exception.getMessage(), exception);
        }

    }

    public void editBook() throws Exception {
        BooksModel editBook = BookService.editBook(findBookByName());
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(editBook);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            System.out.println(ex.getMessage());
        }

    }

    public void deleteBook() throws Exception {


        BooksModel bookName = findBookByName();
        bookName.setAvailable(false);
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(bookName);
            entityManager.getTransaction().commit();
            System.out.println("the book with the name " + bookName + " was deleted");
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new BookNotFound("The book was not found", "Please check if the user type the correct book name");

        }

    }

    public void findByCategory() {

        String jpql = "SELECT BC FROM BooksModel BC WHERE BC.booksCategory = :booksCategory";
        BookService.listBookCategory();
        long category = CreateParameter.createLong("Type the number of the category that you have to filter: ");
        BooksCategory booksCategory = BooksCategory.getBooksCategoryByValueId(category);
        TypedQuery<BooksModel> query = entityManager.createQuery(jpql, BooksModel.class);
        query.setParameter("booksCategory", booksCategory);
        List<BooksModel> books = query.getResultList();
        for (BooksModel book : books) {
            System.out.println(book.toString());
        }
    }

    public static BooksModel findBookByName() throws Exception {

        BooksModel booksModel;

        try {
            String jpql = "SELECT BM FROM BooksModel BM WHERE BM.name = :name";
            TypedQuery<BooksModel> query = entityManager.createQuery(jpql, BooksModel.class);
            String bookName = CreateParameter.createString("Type the book name: ");
            query.setParameter("name", bookName);
            booksModel = query.getSingleResult();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new BookNotFound("The book was not found", "Please check if the user type the correct book name");
        }

        return booksModel;

    }

    public void buyTheBook(UserModel userModel) throws Exception {

        UserModel user = BookService.buyTheBook(userModel);

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Have a error into buy a book" + ex.getMessage());
        }


    }

    public static List<BooksModel> findBooksByAvailability(boolean isAvailable) throws BookNotFound {
        try {
            String jpql = "SELECT BM FROM BooksModel BM WHERE BM.available = :isAvailable";
            TypedQuery<BooksModel> query = entityManager.createQuery(jpql, BooksModel.class);
            query.setParameter("isAvailable", isAvailable);

            List<BooksModel> books = query.getResultList();

            if (books.isEmpty()) {
                throw new BookNotFound(isAvailable ? "No available books found" : "No unavailable books found", "");
            }

            return books;
        } catch (Exception ex) {
            throw new BookNotFound("Error finding books", ex.getMessage());
        }
    }



    public void closeConnection() {
        entityManager.close();
    }
}
