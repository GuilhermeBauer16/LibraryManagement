package br.org.LibraryManagement.domain.model.DAO;

import br.org.LibraryManagement.domain.model.bank.BankModel;
import br.org.LibraryManagement.domain.model.books.BooksModel;
import br.org.LibraryManagement.service.bank.BankService;
import br.org.LibraryManagement.service.book.BookService;

import javax.persistence.EntityManager;

public class BooksDAO {

    private EntityManager entityManager;

    public BooksDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(){
        BooksModel book = BookService.createBook();
        entityManager.persist(book);

    }
}
