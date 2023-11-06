package br.org.LibraryManagement.domain.model.bank;

public class Bank {

    private String accountNumber;

    private double balance;

    public Bank(String accountNumber) {
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
