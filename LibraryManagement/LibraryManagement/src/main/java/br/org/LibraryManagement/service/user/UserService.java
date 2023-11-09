package br.org.LibraryManagement.service.user;

import br.org.LibraryManagement.domain.model.address.Address;
import br.org.LibraryManagement.domain.model.bank.Bank;
import br.org.LibraryManagement.domain.model.users.User;
import br.org.LibraryManagement.service.address.AddressService;
import br.org.LibraryManagement.service.bank.BankService;
import br.org.LibraryManagement.util.CreateParameter;

public class UserService {

    public static void editUser(User user){

        if (user.getUsername() != null ) {
            String username = CreateParameter.createString("Name: ");
            user.setUsername(username);
        }

        if (user.getEmail() != null ) {
            String email = CreateParameter.createString("Email: ");
            user.setEmail(email);
        }
        if (user.getPassword() != null ) {
            String password = CreateParameter.createString("Password: ");
            user.setPassword(password);
        }

        if (user.getAddress() != null ) {
            Address address = AddressService.editAddress(user.getAddress());
            user.setAddress(address);
        }

        if (user.getBank() != null ) {
            Bank bank = BankService.editBankAccount(user.getBank());
            user.setBank(bank);
        }

    }




}
