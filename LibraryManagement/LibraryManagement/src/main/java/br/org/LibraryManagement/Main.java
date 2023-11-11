package br.org.LibraryManagement;


import br.org.LibraryManagement.domain.model.DAO.BooksDAO;
import br.org.LibraryManagement.domain.model.books.BooksModel;
import br.org.LibraryManagement.service.book.BookService;
import br.org.LibraryManagement.util.JPAUtil;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();

        BooksDAO booksDAO = new BooksDAO(entityManager);
        entityManager.getTransaction().begin();
        booksDAO.insert();
        entityManager.getTransaction().commit();

//        Bank bank = BankService.createBank();
//        System.out.println(bank.toString());
//        Bank bankEdit = BankService.editBankAccount(bank);
//        System.out.println(bank.toString());

    }
}