package br.org.LibraryManagement.service.bank;

import br.org.LibraryManagement.domain.model.bank.BankModel;
import br.org.LibraryManagement.util.CreateParameter;
import br.org.LibraryManagement.util.EncryptPassword;
import br.org.LibraryManagement.util.RandomNumbers;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankService {

    public static BankModel createBank() {
        EncryptPassword encryptPassword = new EncryptPassword();
        System.out.println("=/".repeat(30));
        System.out.println("Bank Account");
        System.out.println("=/".repeat(30));
        String name = CreateParameter.createString("Name: ");
        String checkAccountNumber = RandomNumbers.createRandomNumbers(6);
        System.out.println(checkAccountNumber);
        String encryptedAccountNumber = encryptPassword.encryptedPassword(checkAccountNumber);
        System.out.println("Please write these numbers because they will be used in the future.");
        System.out.println("=/".repeat(30));
        return new BankModel(encryptedAccountNumber, name);

    }

    public static BankModel editBankAccount(BankModel bankModel) {
        System.out.println("=/".repeat(30));
        System.out.println("Edit Bank account");
        System.out.println("=/".repeat(30));
        String name = CreateParameter.createString("Name: ");
        System.out.println("=/".repeat(30));
        if(!name.isEmpty()){
            bankModel.setName(name);
        }

        return bankModel;

    }

    public static BankModel deposit(BankModel bankModel) {
        System.out.println("/=".repeat(30));
        System.out.println("Deposit");
        System.out.println("/=".repeat(30));
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
        System.out.println("/=".repeat(30));
        System.out.println("Withdraw");
        System.out.println("/=".repeat(30));
        showAccountBalance(bankModel);
        double valueToWithdraw = CreateParameter.createDouble("Type the value that you want to withdraw:$ ");

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

    public static String showAccountBalance(BankModel bankModel) {

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        return numberFormat.format(bankModel.getBalance());

    }

    public static String showUserInformation(BankModel bankModel){
        return  bankModel.toString();
    }
}
