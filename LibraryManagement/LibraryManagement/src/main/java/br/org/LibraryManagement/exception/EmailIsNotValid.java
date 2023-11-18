package br.org.LibraryManagement.exception;

public class EmailIsNotValid extends Exception{

    private String message;
    private String description;

    public EmailIsNotValid(String message, String description) {
        super(message);
        this.message = message;
        this.description = description;
    }
}
