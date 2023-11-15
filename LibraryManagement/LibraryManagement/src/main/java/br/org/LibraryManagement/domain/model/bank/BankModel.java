package br.org.LibraryManagement.domain.model.bank;

import javax.persistence.*;

@Entity
@Table(name = "bank_accounts")
public class BankModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;

    private double balance;


    public BankModel() {
    }

    public BankModel(String accountNumber) {
        this.accountNumber = accountNumber;

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Bank" + "\n" +
                "accountNumber= '" + accountNumber + '\'' + "\n" +
                ", balance=" + balance + "\n"
                ;
    }
}
