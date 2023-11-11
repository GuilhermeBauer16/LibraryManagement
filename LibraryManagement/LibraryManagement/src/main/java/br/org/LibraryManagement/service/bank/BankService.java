package br.org.LibraryManagement.service.bank;

import br.org.LibraryManagement.domain.model.bank.BankModel;
import br.org.LibraryManagement.util.CreateParameter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankService {

    public static BankModel createBank() {
        String accountNumber = CreateParameter.createString("Account number: ");
        checkDigitAccountNumber(accountNumber);

        return new BankModel(accountNumber);

    }

    public static BankModel editBankAccount(BankModel bankModel) {
        String accountNumber = CreateParameter.createString("Account number: ");
        if (!accountNumber.isEmpty()) {
            checkDigitAccountNumber(accountNumber);
            bankModel.setAccountNumber(accountNumber);

        }

        return bankModel;

    }

    public static void deposit(BankModel bankModel, double value) {

        checkDigitAccountNumber(bankModel.getAccountNumber());
        checkAccountNumberIsEqual(bankModel);

        if (value > 0) {
            double balance = bankModel.getBalance();
            double deposit = balance + value;
            bankModel.setBalance(deposit);
            return;
        }
        throw new RuntimeException("Please insert a value plus to 0");

    }

    public static void withdraw(BankModel bankModel, double value) {

        checkDigitAccountNumber(bankModel.getAccountNumber());
        checkAccountNumberIsEqual(bankModel);
        if (value <= 0) {
            throw new RuntimeException("Please insert a value plus to 0");
        }

        double balance = bankModel.getBalance();
        if (balance >= value) {
            double withdraw = balance - value;
            bankModel.setBalance(withdraw);
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

    public static void checkAccountNumberIsEqual(BankModel bankModel){

        String accountNumber = CreateParameter.createString("Please type your account number: ");
        checkDigitAccountNumber(accountNumber);
        if (!bankModel.getAccountNumber().equals(accountNumber)) {
            throw new RuntimeException("The account number is wrong!");
        }
    }
}
