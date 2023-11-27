package br.org.LibraryManagement.domain.model.users;

import br.org.LibraryManagement.domain.model.address.AddressModel;
import br.org.LibraryManagement.domain.model.bank.BankModel;
import br.org.LibraryManagement.domain.model.books.BooksModel;
import br.org.LibraryManagement.util.CreateParameter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")

public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    private String email;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressModel addressModel;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private BankModel bankModel;

    @ManyToMany
    @JoinTable(name= "user_books",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<BooksModel> books = new ArrayList<>();

    public UserModel() {
    }

    public UserModel(String username, String password, String email, AddressModel addressModel, BankModel bankModel) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.addressModel = addressModel;
        this.bankModel = bankModel;
    }

    public UserModel(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }


    @Override
    public String toString() {
        return "User" +
                "Username= " + username  + "\n" +
                "Email= " + email  + "\n" +
                "Address= " + addressModel.toString() + "\n" +
                "Bank= " + bankModel.toString() + "\n" +
                "Books= " + books.toString() + "\n" +
        '}';
    }

    public void addBook(BooksModel book){
        books.add(book);
        book.getUsers().add(this);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressModel getAddress() {
        return addressModel;
    }

    public void setAddress(AddressModel addressModel) {
        this.addressModel = addressModel;
    }

    public BankModel getBank() {
        return bankModel;
    }

    public void setBank(BankModel bankModel) {
        this.bankModel = bankModel;
    }

    public AddressModel getAddressModel() {
        return addressModel;
    }

    public void setAddressModel(AddressModel addressModel) {
        this.addressModel = addressModel;
    }

    public BankModel getBankModel() {
        return bankModel;
    }

    public void setBankModel(BankModel bankModel) {
        this.bankModel = bankModel;
    }

    public List<BooksModel> getBooks() {
        return books;
    }

    public void setBooks(List<BooksModel> books) {
        this.books = books;
    }
}
