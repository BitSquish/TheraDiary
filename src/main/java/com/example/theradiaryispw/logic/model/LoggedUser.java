package com.example.theradiaryispw.logic.model;

import com.example.theradiaryispw.logic.otherClasses.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.other.Role;

public class LoggedUser {
    private CredentialsBean credentialsBean;
    private String name;
    private String surname;
    private String city;
    private String description;
    private boolean inPerson;
    private boolean online;
    private boolean pag;
    private String mail;
    private String password;
    private Role role;

    public LoggedUser(CredentialsBean credentialsBean, String name, String surname, String city, String description, Boolean isInPerson, Boolean isOnline, Boolean isPAG) {
        this.credentialsBean = credentialsBean;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.description = description;
        this.inPerson = isInPerson;
        this.online = isOnline;
        this.pag = isPAG;
    }
    public LoggedUser(String mail, String password, Role role){
        this.mail = mail;
        this.password = password;
        this.role = role;
    }
    public LoggedUser() {
    }
    //getter e setter per i nuovi campi
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public CredentialsBean getCredentialsBean() {
        return credentialsBean;
    }

    public void setCredentialsBean(CredentialsBean credentialsBean) {
        this.credentialsBean = credentialsBean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isInPerson() {
        return inPerson;
    }

    public void setInPerson(boolean inPerson) {
        this.inPerson = inPerson;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isPag() {
        return pag;
    }

    public void setPag(boolean pag) {
        this.pag = pag;
    }


}