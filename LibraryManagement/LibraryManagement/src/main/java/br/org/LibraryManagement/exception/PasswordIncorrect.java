package br.org.LibraryManagement.exception;

public class PasswordIncorrect extends Exception{

    private String message;
    private String description;

    public PasswordIncorrect(String message, String description) {
        super(message + ": " + description);
        this.message = message;
        this.description = description;
    }
}
