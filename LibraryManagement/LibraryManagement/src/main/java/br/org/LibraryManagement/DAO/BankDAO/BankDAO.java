package br.org.LibraryManagement.DAO.BankDAO;

import br.org.LibraryManagement.domain.model.bank.BankModel;
import br.org.LibraryManagement.domain.model.users.UserModel;
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


    public static BankModel findBankModelByAccountNumber() {
        BankModel bank = null;

        try {
            String jpql = "SELECT BA FROM BankModel BA WHERE BA.accountNumber = :accountNumber";
            String bankAccountNumber = CreateParameter.createString("type the account number: ");
            TypedQuery<BankModel> query = entityManager.createQuery(jpql, BankModel.class);
            query.setParameter("accountNumber", bankAccountNumber);
            bank = query.getSingleResult();

        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            System.out.println("error to find this account number "+ ex.getMessage());
        }

        return bank;
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

    public void deleteBank() {

        try {
            System.out.println("Delete account!");
            entityManager.getTransaction().begin();
            entityManager.remove(findBankModelByAccountNumber());
            entityManager.getTransaction().commit();
        } catch (Exception ex) {

            entityManager.getTransaction().rollback();
            throw new RuntimeException("Error to delete the bank account " + ex.getMessage() + ex);
        }
    }

    public void withdraw() throws Exception {
        try {

            BankModel withdrawOfTheAccount = BankService.withdraw(findBankModelByAccountNumber());
            entityManager.getTransaction().begin();
            entityManager.merge(withdrawOfTheAccount);
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new Exception("have a error in the trying to withdraw! " + ex.getMessage());

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
            entityManager.getTransaction().rollback();
            throw new Exception("Have a error in to deposit a value! " + ex.getMessage());
        }
    }

}

