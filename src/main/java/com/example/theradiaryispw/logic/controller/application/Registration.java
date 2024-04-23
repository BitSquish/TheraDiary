package com.example.theradiaryispw.logic.controller.application;

import com.example.theradiaryispw.logic.otherClasses.bean.login.PatientBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.PsychologistBean;

public class Registration {
    PatientBean patientBean = null;
    PsychologistBean psychologistBean = null;

    public Registration(PatientBean patientBean){
        this.patientBean = patientBean;
    }

    public Registration(PsychologistBean psychologistBean) { this.psychologistBean = psychologistBean; }


}
