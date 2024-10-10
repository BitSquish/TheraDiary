package com.example.theradiaryispw.logic.model;

import com.example.theradiaryispw.logic.otherClasses.other.Role;

public class Credentials {
    //Le seguenti variabili sono dichiarate come final per garantire l'integrità dei dati dell'ogetto Credentials
    private final String mail;
    private final String password;
    private Role role;

    //costruttore
    public Credentials(String mail, String password, Role role){
        this.mail = mail;
        this.password = password;
        this.role = role;
    }

    //getters
    public String getMail(){
        return mail;
    }

    public String getPassword(){ return password; }

    public Role getRole(){
        return role;
    }
}
