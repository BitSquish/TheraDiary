package com.example.theradiaryispw.logic.model.bean.login;

import com.example.theradiaryispw.logic.otherClasses.other.Role;

public class CredentialsBean {
    //Le seguenti variabili sono dichiarate come final per garantire l'integrità dei dati dell'ogetto Credentials
    private String mail;
    private String password;
    private Role role;
    private boolean pag;

    //costruttore
    public CredentialsBean(String mail, String password, Role role){
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

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPag(boolean pag) {
        this.pag=pag;
    }
    public boolean isPag() {
        return pag;
    }
}
