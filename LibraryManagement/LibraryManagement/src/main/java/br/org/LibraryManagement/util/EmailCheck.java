package br.org.LibraryManagement.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailCheck {

    public static final String  EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$";

    public static boolean isValidEmail(String email){

        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
