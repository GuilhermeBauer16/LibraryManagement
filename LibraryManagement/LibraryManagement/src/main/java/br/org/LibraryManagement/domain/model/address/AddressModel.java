package br.org.LibraryManagement.domain.model.address;

import br.org.LibraryManagement.util.CreateParameter;

import javax.persistence.*;

import static br.org.LibraryManagement.service.address.AddressService.checkZipCode;

@Entity
@Table(name = "address")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String neighborhood;
    private String zip_code;
    private String number;

    private String state;
    private String city;
    private String complement;

    public AddressModel() {
    }

    public AddressModel(String street, String neighborhood, String zip_code, String number, String state, String city, String complement) {
        this.street = street;
        this.neighborhood = neighborhood;
        this.zip_code = zip_code;
        this.number = number;
        this.state = state;
        this.city = city;
        this.complement = complement;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }


    @Override
    public String toString() {
        return "Address " + "\n" +

                "Street= " + street  + "\n" +
                "Neighborhood= " + neighborhood  + "\n" +
                "Zip-code= " + zip_code + "\n" +
                "Number= " + number + "\n" +
                "City= " + city + "\n" +
                "Complement= " + complement + "\n"
                ;
    }
}
