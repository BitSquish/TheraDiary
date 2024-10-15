package com.example.theradiaryispw.logic.controller.application;

import com.example.theradiaryispw.logic.model.Credentials;
import com.example.theradiaryispw.logic.model.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.dao.LoginDAO;
import com.example.theradiaryispw.logic.otherClasses.exceptions.WrongEmailOrPasswordException;

import java.sql.SQLException;

public class Login {


    public void log(CredentialsBean credentialsBean) throws WrongEmailOrPasswordException {

        try {
            Credentials credentials = new Credentials(credentialsBean.getMail(), credentialsBean.getPassword(), credentialsBean.getRole());
            LoginDAO.login(credentials);
            credentialsBean.setRole(credentials.getRole());
            //return cred;
        } catch(SQLException e) { //CONTROLLARE ECCEZIONI
            System.out.println("Errore: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (WrongEmailOrPasswordException e) {
            System.out.println("Errore: " + e.getMessage());
            throw new WrongEmailOrPasswordException(e.getMessage());
        }
    }

}
