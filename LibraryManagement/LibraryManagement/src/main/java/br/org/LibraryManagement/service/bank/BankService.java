package br.org.LibraryManagement.service.bank;

import br.org.LibraryManagement.domain.model.bank.Bank;
import br.org.LibraryManagement.util.CreateParameter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankService {

    public static Bank createBank() {
        String accountNumber = CreateParameter.createString("Account number: ");
        checkDigitAccountNumber(accountNumber);

        return new Bank(accountNumber);

    }

    public static Bank editBankAccount(Bank bank) {

        if (bank.getAccountNumber() != null) {
            String accountNumber = CreateParameter.createString("Account number: ");
            checkDigitAccountNumber(accountNumber);
            bank.setAccountNumber(accountNumber);

        }

        return bank;

    }

    public static void deposit(Bank bank, double value) {

        checkDigitAccountNumber(bank.getAccountNumber());
        checkAccountNumberIsEqual(bank);

        if (value > 0) {
            double balance = bank.getBalance();
            double deposit = balance + value;
            bank.setBalance(deposit);
            return;
        }
        throw new RuntimeException("Please insert a value plus to 0");

    }

    public static void withdraw(Bank bank, double value) {

        checkDigitAccountNumber(bank.getAccountNumber());
        checkAccountNumberIsEqual(bank);
        if (value <= 0) {
            throw new RuntimeException("Please insert a value plus to 0");
        }

        double balance = bank.getBalance();
        if (balance >= value) {
            double withdraw = balance - value;
            bank.setBalance(withdraw);
            return;
        }

        throw new RuntimeException("The account does not have sufficient balance ");

    }

    public static void checkDigitAccountNumber(String accountNumber) {

        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(accountNumber);
        if (accountNumber.length() != 6 || matcher.find()) {
            throw new RuntimeException("The account number have character or have less or more to pattern");
        }
    }

    public static void checkAccountNumberIsEqual(Bank bank){

        String accountNumber = CreateParameter.createString("Please type your account number: ");
        checkDigitAccountNumber(accountNumber);
        if (!bank.getAccountNumber().equals(accountNumber)) {
            throw new RuntimeException("The account number is wrong!");
        }
    }
}
