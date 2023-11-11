package br.org.LibraryManagement.domain.model.DAO;

import br.org.LibraryManagement.domain.model.books.BooksModel;
import br.org.LibraryManagement.service.book.BookService;
import javax.persistence.EntityManager;

public class BooksDAO {

    private EntityManager entityManager;

    public BooksDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(){

        BooksModel book = BookService.createBook();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(book);
            entityManager.getTransaction().commit();

        }catch (Exception exception){
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Error to creating the book" + exception.getMessage() , exception);
        }

    }

    public void closeConnection(){
        entityManager.close();
    }
}
