package com.example.theradiaryispw.logic.controller.application;

import com.example.theradiaryispw.logic.model.Psychologist;
import com.example.theradiaryispw.logic.model.bean.generic.PsychologistBean;
import com.example.theradiaryispw.logic.model.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.dao.RetrieveDAO;
import com.example.theradiaryispw.logic.otherClasses.exceptions.NoResultException;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class Search {

    public void search(List<PsychologistBean> psychologistBeans, TextField nomeP, TextField cognomeP, TextField cittaP, CheckBox inPresenza, CheckBox online, CheckBox pag) throws NoResultException {
        List<Psychologist> psychologists = new ArrayList<>();
        RetrieveDAO.searchPsychologists(psychologists, nomeP.getText(), cognomeP.getText(), cittaP.getText(), inPresenza.isSelected(), online.isSelected(), pag.isSelected());
        for(Psychologist psychologist : psychologists){
            CredentialsBean credentialsBean = new CredentialsBean(psychologist.getCredentials().getMail(), psychologist.getCredentials().getPassword(), psychologist.getCredentials().getRole());
            PsychologistBean psychologistBean = new PsychologistBean(credentialsBean, psychologist.getName(),psychologist.getSurname(), psychologist.getCity(), psychologist.getDescription(), psychologist.isInPerson(), psychologist.isOnline(), psychologist.isPag(), null);
            psychologistBeans.add(psychologistBean);
        }
    }
}
