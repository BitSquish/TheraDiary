package com.example.theradiaryispw.logic.model.bean.generic;

import com.example.theradiaryispw.logic.model.bean.login.CredentialsBean;

public class PsychologistBean extends LoggedUserBean{
    protected PsychologistBean(CredentialsBean credentialsBean, String name, String surname, String city, String description, Boolean isInPerson, Boolean isOnline, Boolean isPAG) {
        super(credentialsBean, name, surname, city, description, isInPerson, isOnline, isPAG);
        //DA COMPLETARE
    }
}
