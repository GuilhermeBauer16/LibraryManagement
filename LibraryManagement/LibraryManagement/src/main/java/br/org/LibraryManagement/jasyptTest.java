package br.org.LibraryManagement;

import org.jasypt.util.text.BasicTextEncryptor;

public class jasyptTest {
    public static void main(String[] args) {
        String password = "My password";
        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        basicTextEncryptor.setPassword("password");
        String encryptorPassword = basicTextEncryptor.encrypt(password);
        System.out.println("encrypted password: " + encryptorPassword);
        String decryptedPassword = basicTextEncryptor.decrypt(encryptorPassword);
        System.out.println("decrypted password: " + decryptedPassword);
    }
}
