package br.org.LibraryManagement.Main;

import br.org.LibraryManagement.DAO.BankDAO.BankDAO;
import br.org.LibraryManagement.domain.model.users.UserModel;
import br.org.LibraryManagement.service.bank.BankService;
import br.org.LibraryManagement.util.CreateParameter;
import br.org.LibraryManagement.util.EncryptPassword;

import javax.persistence.EntityManager;


public class BankMain {


    private EntityManager entityManager;
    private UserModel userModel;

    public BankMain(EntityManager entityManager, UserModel userModel) {
        this.entityManager = entityManager;
        this.userModel = userModel;
    }

    public void startBankMain() throws Exception {


        BankDAO bankDAO = new BankDAO(entityManager);
        while (true) {
            EncryptPassword encryptPassword = new EncryptPassword();
            encryptPassword.checkingIfThePasswordsAreEquals(userModel.getPassword());
            System.out.println("Manager Bank Account");
            System.out.println("[1] Deposit");
            System.out.println("[2] Withdraw");
            System.out.println("[3] See your balance");
            System.out.println("[4] See your information");
            System.out.println("[5] Edit your information");
            System.out.println("[6] Return to menu");

            int bankMenuOption = CreateParameter.createInt("Choose a one of menu option: ");

            switch (bankMenuOption) {
                case 1:
                    bankDAO.deposit(userModel.getBank());
                    break;

                case 2:
                    bankDAO.withdraw(userModel.getBank());
                    break;

                case 3:
                    System.out.println("Balance: " + BankService.showAccountBalance(userModel.getBank()));
                    break;

                case 4:
                    System.out.println(userModel.getBank());
                    break;

                case 5:
                    bankDAO.editBank(userModel.getBank());
                    break;

                case 6:
                    System.out.println("Returning to menu....");
                    return;

                default:
                    System.out.println("Please type a valid option! ");
            }
        }
    }
}
