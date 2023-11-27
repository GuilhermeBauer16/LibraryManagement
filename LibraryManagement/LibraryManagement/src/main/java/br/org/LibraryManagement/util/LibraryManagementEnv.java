package br.org.LibraryManagement.util;

public class LibraryManagementEnv {


    private static String environmentVariableValue = "teste";


    public static void checkingIfEnvironmentVariableIsEqual(String password) {

        if (!environmentVariableValue.equals(password)) {
            throw new RuntimeException("nao funcionou");
        }
    }
}
