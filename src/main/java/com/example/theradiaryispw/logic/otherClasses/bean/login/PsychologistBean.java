package com.example.theradiaryispw.logic.otherClasses.bean.login;

import com.example.theradiaryispw.logic.otherClasses.bean.generic.Category;

import java.util.ArrayList;
import java.util.List;

public class PsychologistBean {
    private CredentialsBean credentialsBean;
    private String name;
    private String surname;
    private String city;
    private String description;
    private boolean isInPerson;
    private boolean isOnline;
    private boolean isPAG;
    private List <PatientBean> patients;
    private List <Category> categories;

        public PsychologistBean(CredentialsBean credentialsBean, String name, String surname, String city, String description, boolean isInPerson, boolean isOnline, boolean isPAG) {
        this.credentialsBean = credentialsBean;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.description = description;
        this.isInPerson = isInPerson;
        this.isOnline = isOnline;
        this.isPAG = isPAG;
        this.categories = new ArrayList<Category>();
        this.patients = new ArrayList<PatientBean>();
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
        return isInPerson;
    }

    public void setInPerson(boolean inPerson) {
        isInPerson = inPerson;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public boolean isPAG() {
        return isPAG;
    }

    public List<PatientBean> getPatients() {
        return patients;
    }

    public void addPatients(PatientBean patient){
            this.patients.add(patient);
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category){
            this.categories.add(category);
    }
}
