package br.org.LibraryManagement.exception;

public class LoginNotFoundException extends Exception {
    private String message;
    private String description;

    public LoginNotFoundException(String message, String description) {
        super(message + ": " + description);
        this.message = message;
        this.description = description;
    }








}
