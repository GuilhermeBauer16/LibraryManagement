package br.org.LibraryManagement.exception;

public class LoginNotFound extends Exception {
    private String message;
    private String description;

    public LoginNotFound(String message, String description) {
        super(message + ": " + description);
        this.message = message;
        this.description = description;
    }








}
