package com.example.theradiaryispw.logic.otherClasses.exceptions;
/* nel caso in cui i dati per il login siano errati*/
public class LoginDBException extends Exception{
    public LoginDBException(String message) {
        super(message);
    }
}
