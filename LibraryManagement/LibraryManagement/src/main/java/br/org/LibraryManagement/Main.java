package br.org.LibraryManagement;


import br.org.LibraryManagement.domain.model.DAO.BooksDAO;

import br.org.LibraryManagement.util.JPAUtil;

import javax.persistence.*;


public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();

        BooksDAO booksDAO = new BooksDAO(entityManager);
//        booksDAO.insert();
//        booksDAO.showAllBooks();
//        booksDAO.editBook();
//        booksDAO.showAllBooks();
//        booksDAO.findByCategory();
        booksDAO.deleteBook();
//        entityManager.getTransaction().begin();
//        booksDAO.insert();
//        entityManager.getTransaction().commit();
//        BooksModel book = BookService.createBook();
//        System.out.println(book.toString());
//        B ank bank = BankService.createBank();
//        System.out.println(bank.toString());
//        Bank bankEdit = BankService.editBankAccount(bank);
//        System.out.println(bank.toString());

    }
}