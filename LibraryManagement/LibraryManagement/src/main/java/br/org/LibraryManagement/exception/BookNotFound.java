package br.org.LibraryManagement.exception;

public class BookNotFound extends Exception{

    private String message;
    private String description;

    public BookNotFound(String message, String description) {
        super(message + ": " + description);
        this.message = message;
        this.description = description;
    }
}
