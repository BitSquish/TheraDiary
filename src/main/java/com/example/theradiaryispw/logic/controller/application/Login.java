package com.example.theradiaryispw.logic.controller.application;

import com.example.theradiaryispw.logic.model.Credentials;
import com.example.theradiaryispw.logic.otherClasses.dao.LoginDAO;
import com.example.theradiaryispw.logic.otherClasses.exceptions.WrongEmailOrPasswordException;

import java.sql.SQLException;

public class Login {


    public Credentials log(Credentials credentials) {

        try {
            LoginDAO loginDAO = new LoginDAO();
            Credentials cred = loginDAO.login(credentials);
            return cred;
        } catch(SQLException e) {
            System.out.println("Errore: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (WrongEmailOrPasswordException e) {
            throw new RuntimeException(e);
        }
    }

    //chiamo i DAO
}
