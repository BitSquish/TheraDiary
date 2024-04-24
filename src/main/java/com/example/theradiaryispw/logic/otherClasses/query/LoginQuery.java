package com.example.theradiaryispw.logic.otherClasses.query;

import com.example.theradiaryispw.logic.otherClasses.bean.login.CredentialsBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginQuery {
    public static ResultSet logQuery(Statement stmt, CredentialsBean credentialsBean) throws SQLException {
        String query;
        query = "SELECT * FROM users WHERE mail = '"+ credentialsBean.getMail() + "' and password = '"+ credentialsBean.getPassword() +"';";
        return stmt.executeQuery(query);
    }

    public static ResultSet retrievePsychologist(Statement stmt, String mail) throws SQLException {
        String query;
        query = "SELECT name, surname, city, description, inPerson, online, pag FROM psychologist WHERE mail = '" + mail + "'";
        return stmt.executeQuery(query);
    }

    public static ResultSet retrievePatient(Statement stmt, String mail) throws SQLException {
        String query;
        query = "SELECT name, surname, city, description, inPerson, online, pag FROM patient WHERE mail = '" + mail + "'";
        return stmt.executeQuery(query);
    }
}
