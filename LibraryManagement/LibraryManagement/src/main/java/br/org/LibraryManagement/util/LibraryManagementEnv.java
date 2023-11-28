package br.org.LibraryManagement.util;

import br.org.LibraryManagement.exception.PasswordIncorrect;

public class LibraryManagementEnv {


    private static String environmentVariableValue = "library";


    public static void checkingIfEnvironmentVariableIsEqual(String password) throws PasswordIncorrect {

        if (!environmentVariableValue.equals(password)) {
            throw new PasswordIncorrect("the password is incorrect", "");
        }
    }
}
