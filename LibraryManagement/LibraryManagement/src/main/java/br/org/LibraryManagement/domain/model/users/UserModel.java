package br.org.LibraryManagement.domain.model.users;

import br.org.LibraryManagement.domain.model.address.AddressModel;
import br.org.LibraryManagement.domain.model.bank.BankModel;
import br.org.LibraryManagement.util.CreateParameter;

import javax.persistence.*;

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
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address=" + addressModel.toString() +
                ", bank=" + bankModel.toString() +
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
}
