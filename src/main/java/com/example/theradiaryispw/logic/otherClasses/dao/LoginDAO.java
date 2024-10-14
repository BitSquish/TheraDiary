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

    private LoginDAO(){}

    public static void login(Credentials credentials) throws SQLException, WrongEmailOrPasswordException {
        try (Connection conn = ConnectionFactory.getConnection();
             ResultSet rs = LoginQuery.logQuery(conn, credentials)) {
            if (rs.next()) {
                credentials.setRole(Role.valueOf(rs.getString("role")));
            }
        } catch (SQLException e) {
            throw new WrongEmailOrPasswordException("Mail o password errati");
        }
    }
}
