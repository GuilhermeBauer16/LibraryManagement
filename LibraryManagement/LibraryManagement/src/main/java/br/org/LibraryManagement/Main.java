package br.org.LibraryManagement;

import br.org.LibraryManagement.domain.model.address.Address;
import br.org.LibraryManagement.domain.model.bank.Bank;
import br.org.LibraryManagement.domain.model.users.User;
import br.org.LibraryManagement.service.address.AddressService;
import br.org.LibraryManagement.service.bank.BankService;
import br.org.LibraryManagement.service.user.UserService;

public class Main {
    public static void main(String[] args) {

//        Bank bank = new Bank("123456");
//        Address address = new Address("12th avenue", "Japan", "12345678", "340" ,"poa", "hfgfhfhhfh");
//        System.out.println(address.toString());
//        BankService.deposit(bank,100);
//        System.out.println(bank.toString());
//        BankService.deposit(bank,12);
//        BankService.withdraw(bank,0.5);
//        System.out.println(bank.toString());
//        Books books = new Books("rhhrh", "the book about anything",-1000.00, BooksCategory.CHILDREN, PaymentMethod.DEBIT);
//        System.out.println(books.toString());
//        System.out.println(books.toString());

//        System.out.println("New user");
//        Bank bank = BankService.createBank();
        Address address = AddressService.createAddress();
        System.out.println(address.toString());
        AddressService.editAddress(address);
        System.out.println(address.toString());
//        User user = new User(address,bank);
//        System.out.println(user.toString());
//        BankService.deposit(bank,1000);


    }
}