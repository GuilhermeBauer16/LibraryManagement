package br.org.LibraryManagement.exception;

public class LoginNotFoundException extends Exception {
    private String message;
    private String description;

    public LoginNotFoundException(String message, String description) {
        super(message);
        this.message = message;
        this.description = description;
    }








}
