package br.org.LibraryManagement.exception;

public class InsufficientBalance extends Exception {

    private String message;
    private String description;

    public InsufficientBalance(String message, String description) {

        super(message + ": " + description);
        this.message = message;
        this.description = description;
    }
}
