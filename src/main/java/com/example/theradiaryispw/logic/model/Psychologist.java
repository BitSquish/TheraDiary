package com.example.theradiaryispw.logic.model;

import com.example.theradiaryispw.logic.model.LoggedUser;
import com.example.theradiaryispw.logic.model.Patient;
import com.example.theradiaryispw.logic.otherClasses.other.Category;

import java.util.ArrayList;
import java.util.List;

public class Psychologist extends LoggedUser {
    private List <Patient> patients;


    public Psychologist(LoggedUser lb) {
        super(lb.getCredentials(), lb.getName(), lb.getSurname(), lb.getCity(), lb.getDescription(), lb.isInPerson(), lb.isOnline(), lb.isPag());
        this.patients = new ArrayList<Patient>();
    }




    public List<Patient> getPatient() {
        return patients;
    }

    public void addPatient(Patient patient){
            this.patients.add(patient);
    }

    public void removePatient(Patient patient){
        this.patients.remove(patient);
    }
}
