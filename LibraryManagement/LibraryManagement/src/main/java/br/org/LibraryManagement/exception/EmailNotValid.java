package br.org.LibraryManagement.exception;

public class EmailNotValid extends Exception{

    private String message;
    private String description;

    public EmailNotValid(String message, String description) {
        super(message + ": " + description);
        this.message = message;
        this.description = description;
    }
}
