package br.org.LibraryManagement.util;

import org.jasypt.util.text.BasicTextEncryptor;

public class EncryptPassword {

    private  String ENCRYPTOR_PASSWORD = "123456";
    private BasicTextEncryptor  basicTextEncryptor = new BasicTextEncryptor();


    public String encryptedPassword(String password) {
        try {
            basicTextEncryptor.setPassword(ENCRYPTOR_PASSWORD);
            return basicTextEncryptor.encrypt(password);
        } catch (Exception ex) {
            throw new RuntimeException("Have a error into encrypted the password! " + ex.getMessage());
        }

    }

    public String decryptedPassword(String password) {
        try {
            basicTextEncryptor.setPassword(ENCRYPTOR_PASSWORD);
            return basicTextEncryptor.decrypt(password);

        } catch (Exception ex) {
            throw new RuntimeException("Have a error into decrypted the password! " + ex.getMessage());
        }

    }

    public void checkingIfThePasswordsAreEquals(String password) {
        String passwordTyped = CreateParameter.createString("type your password: ");

        if (!passwordTyped.equals(decryptedPassword(password))) {
            throw new RuntimeException("The two password aren't equals! ");
        }
    }


}
