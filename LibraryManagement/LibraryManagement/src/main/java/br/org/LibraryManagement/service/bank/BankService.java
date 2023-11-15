package br.org.LibraryManagement.service.bank;

import br.org.LibraryManagement.domain.model.bank.BankModel;
import br.org.LibraryManagement.util.CreateParameter;
import br.org.LibraryManagement.util.RandomNumbers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankService {

    public static BankModel createBank() {

        String checkAccountNumber = checkDigitAccountNumber(RandomNumbers.createRandomNumbers(6));
        System.out.println(checkAccountNumber);
        System.out.println("Please write these numbers because they will be used in the future.");
        return new BankModel(checkAccountNumber);

    }

    public static BankModel editBankAccount(BankModel bankModel) {

        String checkAccountNumber = checkDigitAccountNumber(RandomNumbers.createRandomNumbers(6));
        System.out.println(checkAccountNumber);
        System.out.println("Please write these numbers because they will be used in the future.");
        checkDigitAccountNumber(checkAccountNumber);
        bankModel.setAccountNumber(checkAccountNumber);


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

    public static String checkDigitAccountNumber(String accountNumber) {

        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(accountNumber);
        if (accountNumber.length() != 6 || matcher.find()) {
            throw new RuntimeException("The account number have character or have less or more to pattern");
        }
        return accountNumber;
    }

    public static void checkAccountNumberIsEqual(BankModel bankModel) {

        String accountNumber = CreateParameter.createString("Please type your account number: ");
        checkDigitAccountNumber(accountNumber);
        if (!bankModel.getAccountNumber().equals(accountNumber)) {
            throw new RuntimeException("The account number is wrong!");
        }
    }
}
