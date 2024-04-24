package com.example.theradiaryispw.logic.controller.application;

import com.example.theradiaryispw.logic.otherClasses.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.LoggedUserBean;
import com.example.theradiaryispw.logic.otherClasses.dao.LoginDAO;

import java.sql.SQLException;

public class Login {


    public LoggedUserBean log(CredentialsBean credentialsBean) {
        LoggedUserBean lub = null;
        try {
            lub = LoginDAO.login(credentialsBean);
        } catch(SQLException e) {
            System.out.println("Errore: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return lub;
    }

    //chiamo i DAO
}
