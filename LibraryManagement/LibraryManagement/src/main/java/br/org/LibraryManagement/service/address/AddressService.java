package br.org.LibraryManagement.service.address;

import br.org.LibraryManagement.domain.model.address.AddressModel;
import br.org.LibraryManagement.domain.model.users.UserModel;
import br.org.LibraryManagement.util.CheckIfDataIsEmpty;
import br.org.LibraryManagement.util.CreateParameter;

public class AddressService {


    public static AddressModel createAddress() {

        System.out.println("=/".repeat(30));
        System.out.println("Address");
        System.out.println("=/".repeat(30));
        String street = CreateParameter.createString("Street: ");
        CheckIfDataIsEmpty.checkIfIsEmpty(street);
        String neighborhood = CreateParameter.createString("Neighborhood: ");
        CheckIfDataIsEmpty.checkIfIsEmpty(neighborhood);
        String zipCode = CreateParameter.createString("Zip code: ");
        CheckIfDataIsEmpty.checkIfIsEmpty(zipCode);
        checkZipCode(zipCode);
        String number = CreateParameter.createString("Number: ");
        CheckIfDataIsEmpty.checkIfIsEmpty(number);
        String state = CreateParameter.createString("State: ");
        CheckIfDataIsEmpty.checkIfIsEmpty(state);
        String city = CreateParameter.createString("City: ");
        CheckIfDataIsEmpty.checkIfIsEmpty(city);
        String complement = CreateParameter.createString("Complement: ");
        CheckIfDataIsEmpty.checkIfIsEmpty(complement);
        System.out.println("=/".repeat(30));


        AddressModel addressModel = new AddressModel(street, neighborhood, zipCode, number, state, city, complement);

        return addressModel;
    }


    public static AddressModel editAddress(AddressModel addressModel) {
        System.out.println("=/".repeat(30));
        System.out.println("Edit Address");
        System.out.println("=/".repeat(30));

        String street = CreateParameter.createString("Street: ");
        String neighborhood = CreateParameter.createString("Neighborhood: ");
        String zipCode = CreateParameter.createString("Zip code: ");
        String number = CreateParameter.createString("Number: ");
        String state = CreateParameter.createString("State: ");
        String city = CreateParameter.createString("City: ");
        String complement = CreateParameter.createString("Complement: ");
        System.out.println("=/".repeat(30));

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

    public static String showUserAddress(AddressModel addressModel) {
        return addressModel.toString();
    }

    public static void checkZipCode(String zipCode) {

        if (!zipCode.matches(".*\\d+.*"))

            throw new RuntimeException("Please type only digits!");

        if (zipCode.trim().length() != 8) {

            throw new RuntimeException("Please insert a valid zip code!");
        }


    }


}
