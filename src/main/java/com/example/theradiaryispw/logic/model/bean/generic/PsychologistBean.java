package com.example.theradiaryispw.logic.model.bean.generic;

import com.example.theradiaryispw.logic.model.Patient;
import com.example.theradiaryispw.logic.model.bean.login.CredentialsBean;

import java.util.ArrayList;

public class PsychologistBean extends LoggedUserBean{
    private ArrayList<PatientBean> patientsBean;
    public PsychologistBean(CredentialsBean credentialsBean, String name, String surname, String city, String description, Boolean isInPerson, Boolean isOnline, Boolean isPAG, ArrayList<PatientBean> patientsBean) {
        super(credentialsBean, name, surname, city, description, isInPerson, isOnline, isPAG);
        this.patientsBean=new ArrayList<>();
    }
    public ArrayList<PatientBean> getPatientsBean() {
        return patientsBean;
    }
    public void addPatientBean(PatientBean patientBean){
        this.patientsBean.add(patientBean);
    }
    public void removePatientBean(PatientBean patientBean){
        this.patientsBean.remove(patientBean);
    }
}
