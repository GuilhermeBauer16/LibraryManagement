package br.org.LibraryManagement.domain.model.DAO.BankDAO;

import br.org.LibraryManagement.domain.model.bank.BankModel;
import br.org.LibraryManagement.service.bank.BankService;
import br.org.LibraryManagement.util.CreateParameter;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class BankDAO {

    private static EntityManager entityManager;

    public BankDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert() {

        BankModel bank = BankService.createBank();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(bank);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Error to create a bank account " + ex.getMessage() + ex);
        }
    }


    public static BankModel findBankModelByAccountNumber() {
        BankModel bank = null;

        try {
            String jpql = "SELECT BA FROM BankModel BA WHERE BA.accountNumber: :accountNumber";
            long bankAccountNumber = CreateParameter.createLong("type the account number: ");
            TypedQuery<BankModel> query = entityManager.createQuery(jpql, BankModel.class);
            bank = (BankModel) query.setParameter("accountNumber", bankAccountNumber);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return bank;
    }

    public void editBank() {
        BankModel bankModel = findBankModelByAccountNumber();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(BankService.editBankAccount(findBankModelByAccountNumber()));
            entityManager.getTransaction().commit();
        } catch (Exception ex) {

            entityManager.getTransaction().rollback();
            throw new RuntimeException("Error to edit the bank account " + ex.getMessage() + ex);
        }

    }
    public void deleteBank(){

        try{
            entityManager.getTransaction().begin();
            entityManager.remove(findBankModelByAccountNumber());
            entityManager.getTransaction().commit();
        }catch (Exception ex){

            entityManager.getTransaction().rollback();
            throw new RuntimeException("Error to delete the bank account " + ex.getMessage() + ex);
        }
    }
}


