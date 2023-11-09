package br.org.LibraryManagement;

import br.org.LibraryManagement.domain.model.bank.Bank;
import br.org.LibraryManagement.domain.model.books.Books;
import br.org.LibraryManagement.service.bank.BankService;
import br.org.LibraryManagement.service.book.BookService;

import java.awt.print.Book;


public class Main {
    public static void main(String[] args) {

        Books book = BookService.createBook();
        System.out.println(book.toString());

//        Bank bank = BankService.createBank();
//        System.out.println(bank.toString());
//        Bank bankEdit = BankService.editBankAccount(bank);
//        System.out.println(bank.toString());

    }
}