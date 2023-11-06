package br.org.LibraryManagement.service.address;

import br.org.LibraryManagement.domain.model.address.Address;
import br.org.LibraryManagement.util.CreateParameter;

public class AddressService {


    public static Address createAddress() {
        String street = CreateParameter.createString("Street: ");
        String neighborhood = CreateParameter.createString("Neighborhood: ");
        String zipCode = CreateParameter.createString("Zip code: ");
        String number = CreateParameter.createString("Number: ");
        String city = CreateParameter.createString("City: ");
        String complement = CreateParameter.createString("Complement");

        Address address = new Address(street, neighborhood, zipCode, number, city, complement);
        checkZipCode(address);
        return address;
    }

    public static void checkZipCode(Address address) {

        String zipCode = address.getZip_code();
        if (zipCode.length() != 8) {
            throw new RuntimeException("Please insert a valid zip code!");
        }
    }


}
