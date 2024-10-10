package com.example.theradiaryispw.logic.model;

import com.example.theradiaryispw.logic.model.LoggedUser;

public class Patient extends LoggedUser {
    public Patient(LoggedUser lb) {
        super(lb.getCredentialsBean(), lb.getName(), lb.getSurname(), lb.getCity(), lb.getDescription(), lb.isInPerson(), lb.isOnline(), lb.isPag());
    }
}
