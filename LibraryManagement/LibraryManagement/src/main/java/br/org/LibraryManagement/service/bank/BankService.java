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

    public static BankModel deposit(BankModel bankModel) {

        checkDigitAccountNumber(bankModel.getAccountNumber());
//        checkAccountNumberIsEqual(bankModel);
        showAccountBalance(bankModel);
        double valueToDeposit = CreateParameter.createDouble("Type the value that you want to deposit:$ ");

        if (valueToDeposit > 0) {
            double balance = bankModel.getBalance();
            double deposit = balance + valueToDeposit;
            bankModel.setBalance(deposit);
            return bankModel;
        }
        throw new RuntimeException("Please insert a value plus to 0");

    }

    public static BankModel withdraw(BankModel bankModel) {

        checkDigitAccountNumber(bankModel.getAccountNumber());
//        checkAccountNumberIsEqual(bankModel);
        showAccountBalance(bankModel);
        double valueToWithdraw = CreateParameter.createDouble("Type the value that you want to deposit:$ ");

        if (valueToWithdraw <= 0) {
            throw new RuntimeException("Please insert a value plus to 0");
        }

        double balance = bankModel.getBalance();
        if (balance >= valueToWithdraw) {
            double withdraw = balance - valueToWithdraw;
            bankModel.setBalance(withdraw);
            return bankModel;
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

//    public static void checkAccountNumberIsEqual(BankModel bankModel) {
//
//
//        checkDigitAccountNumber(accountNumber);
//        if (!bankModel.getAccountNumber().equals(accountNumber)) {
//            throw new RuntimeException("The account number is wrong!");
//        }
//    }

    public static void showAccountBalance(BankModel bankModel) {

        System.out.println("=".repeat(30));
        System.out.println("Balance: " + bankModel.getBalance());
        System.out.println("=".repeat(30));
    }
}
