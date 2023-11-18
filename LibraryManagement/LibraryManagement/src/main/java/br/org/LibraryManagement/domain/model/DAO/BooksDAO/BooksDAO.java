package br.org.LibraryManagement.domain.model.DAO.BooksDAO;

import br.org.LibraryManagement.domain.model.books.BooksCategory;
import br.org.LibraryManagement.domain.model.books.BooksModel;
import br.org.LibraryManagement.domain.model.users.UserModel;
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

    public void insert() {

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

    public static void showAllBooks() {
        String jpql = "SELECT B FROM BooksModel B";
        Query query = entityManager.createQuery(jpql, BooksModel.class);
        List<BooksModel> books = query.getResultList();
        for (BooksModel book : books) {
            System.out.println(book.toString());
        }
    }

    public static BooksModel findByBookId() {
        long id = CreateParameter.createLong("Type the ID: ");
        BooksModel findIdBook = null;
        try {
            findIdBook = entityManager.find(BooksModel.class, id);

        } catch (RuntimeException ex) {
            entityManager.getTransaction().rollback();
            System.out.println("Please type a valid id" + ex.getMessage());
        }

        return findIdBook;
    }

    public static void editBook() {
        BooksModel editBook = BookService.editBook(findByBookId());
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(editBook);
            entityManager.getTransaction().commit();
        } catch (Exception ex){
            entityManager.getTransaction().rollback();
            System.out.println(ex.getMessage());
        }

    }

    public void deleteBook(){
        showAllBooks();
        BooksModel bookId =  findByBookId();
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(bookId);
            entityManager.getTransaction().commit();
            System.out.println("the book with the name " + bookId.getName() + " was deleted");
        }catch (Exception ex){
            entityManager.getTransaction().rollback();
            System.out.println("Have a error to deleted the book " + ex.getMessage());

        }

    }

    public void findByCategory(){
        String jpql = "SELECT BC FROM BooksModel BC WHERE BC.booksCategory = :booksCategory";
        BookService.listBookCategory();
        long category = CreateParameter.createLong("Type the number of the category that you have to filter: ");
        BooksCategory booksCategory = BooksCategory.getBooksCategoryByValueId(category);
        TypedQuery<BooksModel> query = entityManager.createQuery(jpql , BooksModel.class) ;
        query.setParameter("booksCategory" , booksCategory);
        List<BooksModel> books = query.getResultList();
        for(BooksModel book : books){
            System.out.println(book.toString());
        }
    }

    public static BooksModel findBookByName() throws Exception {

        BooksModel booksModel;

        try {
            String jpql = "SELECT BM FROM BooksModel BM WHERE BM.name = :name";
            TypedQuery<BooksModel> query = entityManager.createQuery(jpql,BooksModel.class);
            String bookName = CreateParameter.createString("Type the book name: ");
            query.setParameter("name",bookName);
            booksModel = query.getSingleResult();
        }catch (Exception ex){

            entityManager.getTransaction().rollback();
            throw  new Exception("The book name has not found" + ex.getMessage());
        }

        return booksModel;

    }

    public void buyTheBook(UserModel userModel) throws Exception {

        UserModel user = BookService.buyTheBook(userModel);

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        }catch (Exception ex){
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Have a error into buy a book" + ex.getMessage());
        }



    }

    public void closeConnection() {
        entityManager.close();
    }
}
