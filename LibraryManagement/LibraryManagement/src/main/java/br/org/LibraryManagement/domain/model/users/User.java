package br.org.LibraryManagement.domain.model.users;

import br.org.LibraryManagement.domain.model.address.Address;
import br.org.LibraryManagement.domain.model.bank.Bank;
import br.org.LibraryManagement.util.CreateParameter;

public class User {
    private String username;
    private String password;

    private String email;

    private Address address;

    private Bank bank;


    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(Address address, Bank bank) {
        this.username = CreateParameter.createString("Name: ");
        this.password = CreateParameter.createString("Email: ");
        this.email = CreateParameter.createString("Password: ");
        this.address = address;
        this.bank = bank;




    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", bank=" + bank +
                '}';
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
