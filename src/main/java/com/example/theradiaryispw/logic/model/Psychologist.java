package com.example.theradiaryispw.logic.model;

import com.example.theradiaryispw.logic.model.LoggedUser;
import com.example.theradiaryispw.logic.model.Patient;
import com.example.theradiaryispw.logic.otherClasses.other.Category;

import java.util.ArrayList;
import java.util.List;

public class Psychologist extends LoggedUser {
    private List <Patient> patients;
    private List <Category> categories;

    public Psychologist(LoggedUser lb) {
        super(lb.getCredentials(), lb.getName(), lb.getSurname(), lb.getCity(), lb.getDescription(), lb.isInPerson(), lb.isOnline(), lb.isPag());
        this.categories = new ArrayList<Category>();
        this.patients = new ArrayList<Patient>();
    }

    /*public CredentialsBean getCredentialsBean() {
        return super.getCredentialsBean();
    }

    public void setCredentialsBean(CredentialsBean credentialsBean) {
        super.setCredentialsBean(credentialsBean);
    }

    public String getName() {
        return super.getName();
    }

    public String getSurname() {
        return super.getSurname();
    }


    public String getCity() {
        return super.getCity();
    }


    public String getDescription() {
        return super.getDescription();
    }

    public boolean isInPerson() {
        return super.isInPerson();
    }


    public boolean isOnline() {
        return super.isOnline();
    }

    public boolean isPag() {
        return super.isPag();
    }*/


    public List<Patient> getPatients() {
        return patients;
    }

    public void addPatients(Patient patient){
            this.patients.add(patient);
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category){
            this.categories.add(category);
    }
}
