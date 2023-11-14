package br.org.LibraryManagement.domain.model.DAO.AddressDAO;

import br.org.LibraryManagement.domain.model.address.AddressModel;
import br.org.LibraryManagement.service.address.AddressService;
import br.org.LibraryManagement.util.CreateParameter;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class AddressDAO {

    private static EntityManager entityManager;


    public AddressDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert() {

        AddressModel address = AddressService.createAddress();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(address);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Have a error for create this address " + ex.getMessage(), ex);


        }


    }

    public static AddressModel findByAddressId() {
        long addressId = CreateParameter.createLong("Type a address id: ");
        AddressModel addressModel = null;
        try {
            addressModel = entityManager.find(AddressModel.class, addressId);
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            System.out.println("error to find the id address! " + ex.getMessage());
        }

        return addressModel;

    }

    public void editAddress() {
        showAllAddress();
        try {

            AddressModel editedAddress = AddressService.editAddress(findByAddressId());
            entityManager.getTransaction().begin();
            entityManager.merge(editedAddress);
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            System.out.println("error to edit the address! " + ex.getMessage());
        }
    }

    public void deleteAddress() {
        showAllAddress();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(findByAddressId());
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            System.out.println("error to edit the address! " + ex.getMessage());
        }
    }

    public static void showAllAddress(){
        String jpql = "SELECT A FROM AddressModel A";
        Query query = entityManager.createQuery(jpql,AddressModel.class);
        List<AddressModel> addresses = query.getResultList();

        for (AddressModel address : addresses) {
            System.out.println(address.toString());
            System.out.println("----------------------");

        }
    }
}
