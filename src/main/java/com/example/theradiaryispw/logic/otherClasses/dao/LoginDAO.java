package com.example.theradiaryispw.logic.otherClasses.dao;

import com.example.theradiaryispw.logic.model.Credentials;
import com.example.theradiaryispw.logic.otherClasses.exceptions.WrongEmailOrPasswordException;
import com.example.theradiaryispw.logic.otherClasses.other.ConnectionFactory;
import com.example.theradiaryispw.logic.otherClasses.other.Role;
import com.example.theradiaryispw.logic.otherClasses.query.LoginQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

//I BEAN NON VANNO PASSATI NEL DAO


public class LoginDAO {

    public static void login(Credentials credentials) throws SQLException, WrongEmailOrPasswordException {
        try (Connection conn = ConnectionFactory.getConnection();
             ResultSet rs = LoginQuery.logQuery(conn, credentials)) {
            if (rs.next()) {
                credentials.setRole(Role.valueOf(rs.getString("role")));
                /*try (ResultSet rs1 = role.getId() == 1 ?
                        LoginQuery.retrievePsychologist(conn, mail) :
                        LoginQuery.retrievePatient(conn, mail)) {
                    if (rs1.next()) { //Se nel resultSet c'è almeno una riga
                        loggedUser.setName(rs1.getString("name"));
                        loggedUser.setSurname(rs1.getString("surname"));
                        loggedUser.setCity(rs1.getString("city"));
                        loggedUser.setDescription(rs1.getString("description"));
                        loggedUser.setInPerson(rs1.getBoolean("inPerson"));
                        loggedUser.setOnline(rs1.getBoolean("online"));
                        loggedUser.setPag(rs1.getBoolean("pag"));
                        return loggedUser;
                    } else {
                        System.out.println("ResultSet vuoto");
                    }
                }*/
            }
        } catch (SQLException e) {
            throw new WrongEmailOrPasswordException("Mail o password errati");
        }
    }
}
