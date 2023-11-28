package br.org.LibraryManagement.DAO.BankDAO;

import br.org.LibraryManagement.domain.model.bank.BankModel;
import br.org.LibraryManagement.domain.model.users.UserModel;
import br.org.LibraryManagement.exception.InsufficientBalance;
import br.org.LibraryManagement.service.bank.BankService;
import br.org.LibraryManagement.util.CreateParameter;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class BankDAO {

    private static EntityManager entityManager;

    public BankDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public BankModel insert() {


        try {
            BankModel bank = BankService.createBank();
            entityManager.getTransaction().begin();
            entityManager.persist(bank);
            entityManager.getTransaction().commit();
            return bank;
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Error to create a bank account " + ex.getMessage() + ex);
        }

    }


    public BankModel editBank(BankModel bankModel) {

        try {

            System.out.println("Edit account!");
            entityManager.getTransaction().begin();
            entityManager.merge(BankService.editBankAccount(bankModel));
            entityManager.getTransaction().commit();
            return bankModel;
        } catch (Exception ex) {

            entityManager.getTransaction().rollback();
            throw new RuntimeException("Error to edit the bank account " + ex.getMessage() + ex);
        }

    }



    public BankModel withdraw(BankModel bankModel) throws Exception {
        try {

            BankModel withdrawOfTheAccount = BankService.withdraw(bankModel);
            entityManager.getTransaction().begin();
            entityManager.merge(withdrawOfTheAccount);
            entityManager.getTransaction().commit();
            return bankModel;
        } catch (Exception ex) {
            throw new InsufficientBalance("The account does not have sufficient balance","");

        }
    }

    public BankModel deposit(BankModel bankModel) throws Exception {
        try {

            BankModel depositInTheAccount = BankService.deposit(bankModel);
            entityManager.getTransaction().begin();
            entityManager.merge(depositInTheAccount);
            entityManager.getTransaction().commit();
            return  depositInTheAccount;

        } catch (Exception ex) {
            throw new Exception("Have a error in deposit into account");
        }
    }

}


