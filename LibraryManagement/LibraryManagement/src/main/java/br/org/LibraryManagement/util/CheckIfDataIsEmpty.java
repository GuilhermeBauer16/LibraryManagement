package br.org.LibraryManagement.util;

public class CheckIfDataIsEmpty {

    public static void checkIfIsEmpty(String attribute){

        if (attribute.isEmpty()){
            throw  new NullPointerException( "this field must not be blank!");
        }
    }
}
