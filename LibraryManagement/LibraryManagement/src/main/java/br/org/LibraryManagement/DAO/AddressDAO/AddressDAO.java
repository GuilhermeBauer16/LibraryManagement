package br.org.LibraryManagement.DAO.AddressDAO;

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

    public AddressModel insert() {

        try {
            AddressModel address = AddressService.createAddress();
            entityManager.getTransaction().begin();
            entityManager.persist(address);
            entityManager.getTransaction().commit();
            return address;
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Have a error for create this address " + ex.getMessage(), ex);

        }


    }


    public AddressModel editAddress(AddressModel addressModel) {

        try {

            AddressModel editedAddress = AddressService.editAddress(addressModel);
            entityManager.getTransaction().begin();
            entityManager.merge(editedAddress);
            entityManager.getTransaction().commit();
            return addressModel;

        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            System.out.println("error to edit the address! " + ex.getMessage());
        }
        return addressModel;
    }

}
