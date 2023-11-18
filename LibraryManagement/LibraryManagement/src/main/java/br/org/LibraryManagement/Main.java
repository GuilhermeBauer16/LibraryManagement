package br.org.LibraryManagement;


import br.org.LibraryManagement.domain.model.DAO.AddressDAO.AddressDAO;
import br.org.LibraryManagement.domain.model.DAO.BankDAO.BankDAO;
import br.org.LibraryManagement.domain.model.DAO.BooksDAO.BooksDAO;

import br.org.LibraryManagement.domain.model.address.AddressModel;
import br.org.LibraryManagement.domain.model.bank.BankModel;
import br.org.LibraryManagement.service.address.AddressService;
import br.org.LibraryManagement.service.bank.BankService;
import br.org.LibraryManagement.util.JPAUtil;

import javax.persistence.*;

import static br.org.LibraryManagement.domain.model.DAO.AddressDAO.AddressDAO.showAllAddress;


public class Main {
    public static void main(String[] args) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManager();
        AddressDAO addressDAO = new AddressDAO(entityManager);
        BankDAO bankDAO = new BankDAO(entityManager);


        bankDAO.insert();
//        BankService.showAccountBalance(BankDAO.findBankModelByAccountNumber());
        bankDAO.deposit();
        bankDAO.withdraw();


//        System.out.println(bankModel.toString());
//        BooksDAO booksDAO = new BooksDAO(entityManager);
////        booksDAO.insert();
////        booksDAO.showAllBooks();
////        booksDAO.editBook();
////        booksDAO.showAllBooks();
////        booksDAO.findByCategory();
//        booksDAO.deleteBook();
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