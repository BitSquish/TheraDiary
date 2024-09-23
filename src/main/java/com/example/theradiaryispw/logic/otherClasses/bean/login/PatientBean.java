package com.example.theradiaryispw.logic.otherClasses.bean.login;

public class PatientBean extends LoggedUserBean{
    public PatientBean(LoggedUserBean lb) {
        super(lb.getCredentialsBean(), lb.getName(), lb.getSurname(), lb.getCity(), lb.getDescription(), lb.isInPerson(), lb.isOnline(), lb.isPag());
    }
}
