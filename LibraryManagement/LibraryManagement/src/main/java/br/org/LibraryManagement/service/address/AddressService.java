package br.org.LibraryManagement.service.address;

import br.org.LibraryManagement.domain.model.address.Address;
import br.org.LibraryManagement.util.CreateParameter;

public class AddressService {


    public static Address createAddress() {
        String street = CreateParameter.createString("Street: ");
        String neighborhood = CreateParameter.createString("Neighborhood: ");
        String zipCode = CreateParameter.createString("Zip code: ");
        checkZipCode(zipCode);
        String number = CreateParameter.createString("Number: ");
        String city = CreateParameter.createString("City: ");
        String complement = CreateParameter.createString("Complement: ");

        Address address = new Address(street, neighborhood, zipCode, number, city, complement);

        return address;
    }


    public static Address editAddress(Address address) {

        String street = CreateParameter.createString("Street: ");
        String neighborhood = CreateParameter.createString("Neighborhood: ");
        String zipCode = CreateParameter.createString("Zip code: ");
        String number = CreateParameter.createString("Number: ");
        String city = CreateParameter.createString("City: ");
        String complement = CreateParameter.createString("Complement: ");

        if (!street.isEmpty()) {
            address.setStreet(street);
        }

        if (!neighborhood.isEmpty()) {
            address.setNeighborhood(neighborhood);
        }

        if (!zipCode.isEmpty()) {

            checkZipCode(zipCode);
            address.setZip_code(zipCode);
        }

        if (!number.isEmpty()) {
            address.setNumber(number);
        }

        if (!city.isEmpty()) {
            address.setCity(city);
        }

        if (!complement.isEmpty()) {
            address.setComplement(complement);
        }

        return address;


    }

    public static void checkZipCode(String zipCode) {

        if (!zipCode.matches(".*\\d+.*"))

            throw new RuntimeException("Please type only digits!");

        if (zipCode.length() != 8) {

            new RuntimeException("Please insert a valid zip code!");
        }


    }


}
