package br.org.LibraryManagement.util;

import br.org.LibraryManagement.exception.PasswordIncorrect;
import org.jasypt.util.text.BasicTextEncryptor;

public class EncryptPassword {

    private  String ENCRYPTOR_PASSWORD = "123456";
    private BasicTextEncryptor  basicTextEncryptor = new BasicTextEncryptor();


    public String encryptedPassword(String password) throws PasswordIncorrect {
        try {
            basicTextEncryptor.setPassword(ENCRYPTOR_PASSWORD);
            return basicTextEncryptor.encrypt(password);
        } catch (Exception ex) {
            throw new PasswordIncorrect("the password is incorrect", "");
        }

    }

    public String decryptedPassword(String password) throws PasswordIncorrect {
        try {
            basicTextEncryptor.setPassword(ENCRYPTOR_PASSWORD);
            return basicTextEncryptor.decrypt(password);

        } catch (Exception ex) {
            throw new PasswordIncorrect("the password is incorrect", "");
        }

    }

    public void checkingIfThePasswordsAreEquals(String password) throws PasswordIncorrect {
        String passwordTyped = CreateParameter.createString("type your password: ");

        if (!passwordTyped.equals(decryptedPassword(password))) {
            throw new PasswordIncorrect("the password is incorrect", "");
        }
    }


}
