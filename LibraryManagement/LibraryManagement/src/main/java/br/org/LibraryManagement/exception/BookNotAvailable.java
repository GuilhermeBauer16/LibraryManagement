package br.org.LibraryManagement.exception;

public class BookNotAvailable extends Exception{

    private String message;
    private String description;

    public BookNotAvailable(String message, String description) {
        super(message + ": " + message);
        this.message = message;
        this.description = description;
    }
}
