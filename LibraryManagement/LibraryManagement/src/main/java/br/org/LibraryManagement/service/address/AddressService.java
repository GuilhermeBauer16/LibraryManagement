package br.org.LibraryManagement.service.address;

import br.org.LibraryManagement.domain.model.address.AddressModel;
import br.org.LibraryManagement.util.CreateParameter;

public class AddressService {


    public static AddressModel createAddress() {
        String street = CreateParameter.createString("Street: ");
        String neighborhood = CreateParameter.createString("Neighborhood: ");
        String zipCode = CreateParameter.createString("Zip code: ");
        checkZipCode(zipCode);
        String number = CreateParameter.createString("Number: ");
        String state = CreateParameter.createString("State: ");
        String city = CreateParameter.createString("City: ");
        String complement = CreateParameter.createString("Complement: ");

        AddressModel addressModel = new AddressModel(street, neighborhood, zipCode, number,state, city, complement);

        return addressModel;
    }


    public static AddressModel editAddress(AddressModel addressModel) {

        String street = CreateParameter.createString("Street: ");
        String neighborhood = CreateParameter.createString("Neighborhood: ");
        String zipCode = CreateParameter.createString("Zip code: ");
        String number = CreateParameter.createString("Number: ");
        String state = CreateParameter.createString("State: ");
        String city = CreateParameter.createString("City: ");
        String complement = CreateParameter.createString("Complement: ");

        if (!street.isEmpty()) {
            addressModel.setStreet(street);
        }

        if (!neighborhood.isEmpty()) {
            addressModel.setNeighborhood(neighborhood);
        }

        if (!zipCode.isEmpty()) {

            checkZipCode(zipCode);
            addressModel.setZip_code(zipCode);
        }

        if (!number.isEmpty()) {
            addressModel.setNumber(number);
        }

        if (!state.isEmpty()) {
            addressModel.setState(state);
        }

        if (!city.isEmpty()) {
            addressModel.setCity(city);
        }

        if (!complement.isEmpty()) {
            addressModel.setComplement(complement);
        }

        return addressModel;


    }

    public static void checkZipCode(String zipCode) {

        if (!zipCode.matches(".*\\d+.*"))

            throw new RuntimeException("Please type only digits!");

        if (zipCode.trim().length() != 8) {

            throw new RuntimeException("Please insert a valid zip code!");
        }


    }


}
