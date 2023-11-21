package br.org.LibraryManagement.exception;

import javax.xml.transform.stream.StreamResult;

public class UserDeleted  extends Exception{

    private String message;
    private String description;

    public UserDeleted(String message, String description) {
        super(message + ": " + description);
        this.message = message;
        this.description = description;
    }
}
