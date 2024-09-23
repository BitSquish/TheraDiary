package com.example.theradiaryispw.logic.otherClasses.bean.login;

import com.example.theradiaryispw.logic.otherClasses.bean.generic.Category;

import java.util.ArrayList;
import java.util.List;

public class PsychologistBean extends LoggedUserBean {
    private List <PatientBean> patients;
    private List <Category> categories;

    public PsychologistBean(LoggedUserBean lb) {
        super(lb.getCredentialsBean(), lb.getName(), lb.getSurname(), lb.getCity(), lb.getDescription(), lb.isInPerson(), lb.isOnline(), lb.isPag());
        this.categories = new ArrayList<Category>();
        this.patients = new ArrayList<PatientBean>();
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
