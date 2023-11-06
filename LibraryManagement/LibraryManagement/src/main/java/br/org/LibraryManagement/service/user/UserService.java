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
            user.setUsername(email);
        }
        if (user.getPassword() != null ) {
            String password = CreateParameter.createString("Password: ");
            user.setUsername(password);
        }

        if (user.getAddress() != null ) {
            String password = CreateParameter.createString("Password: ");
            user.setUsername(password);
        }

        if (user.getBank() != null ) {
            String password = CreateParameter.createString("Password: ");
            user.setUsername(password);
        }






    }




}
