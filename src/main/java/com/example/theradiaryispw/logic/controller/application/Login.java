package com.example.theradiaryispw.logic.controller.application;

import com.example.theradiaryispw.logic.otherClasses.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.LoggedUserBean;
import com.example.theradiaryispw.logic.otherClasses.dao.LoginProcedureDAO;
import com.example.theradiaryispw.logic.otherClasses.dao.RetrievePatientDAO;
import com.example.theradiaryispw.logic.otherClasses.dao.RetrievePsychologistDAO;
import com.example.theradiaryispw.logic.otherClasses.exceptions.DAOException;

import java.sql.SQLException;

public class Login {
    CredentialsBean credentialsBean;
    public Login(CredentialsBean credentialsBean) {
        this.credentialsBean = credentialsBean;
    }

    public LoggedUserBean log() {

        try {
            CredentialsBean credentialsBean = new LoginProcedureDAO().execute(this.credentialsBean.getMail(), this.credentialsBean.getPassword());
            System.out.println("Credenziali: Mail: " + credentialsBean.getMail() + " Ruolo: " + credentialsBean.getRole());
            if(credentialsBean.getRole() == null){
                System.out.println("Errore!!!");
            }
            else if(credentialsBean.getRole().toString().equals("PSYCHOLOGIST")){
                System.out.println("Entra nell'if");
                LoggedUserBean loggedUserBean = new RetrievePsychologistDAO().execute(this.credentialsBean.getMail(), this.credentialsBean.getPassword(), credentialsBean.getRole());
                return loggedUserBean;
            }
            else if(credentialsBean.getRole().toString().equals("PATIENT")){
                LoggedUserBean loggedUserBean = new RetrievePatientDAO().execute(this.credentialsBean.getMail(), this.credentialsBean.getPassword(), credentialsBean.getRole());
                return loggedUserBean;
            }
            System.out.println("Mail: " + credentialsBean.getMail() + " Ruolo: " + credentialsBean.getRole().toString());
        } catch(DAOException | SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    //chiamo i DAO
}
