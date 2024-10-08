package com.example.theradiaryispw.logic.otherClasses.dao;

import com.example.theradiaryispw.logic.otherClasses.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.LoggedUserBean;
import com.example.theradiaryispw.logic.otherClasses.other.ConnectionFactory;
import com.example.theradiaryispw.logic.otherClasses.other.Role;
import com.example.theradiaryispw.logic.otherClasses.query.LoginQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAO {
    private LoginDAO(){};

    public static LoggedUserBean login(CredentialsBean credentialsBean) throws SQLException {
        LoggedUserBean loggedUserBean = new LoggedUserBean();
        try (Connection conn = ConnectionFactory.getConnection();
             ResultSet rs = LoginQuery.logQuery(conn, credentialsBean)) {
            if (rs.next()) {
                String mail = rs.getString("mail");
                String password = rs.getString("password");
                Role role = Role.valueOf(rs.getString("role"));
                CredentialsBean cred = new CredentialsBean(mail, password, role);
                loggedUserBean.setCredentialsBean(cred);
                try (ResultSet rs1 = role.getId() == 1 ?
                        LoginQuery.retrievePsychologist(conn, mail) :
                        LoginQuery.retrievePatient(conn, mail)) {
                    if (rs1.next()) { //Se nel resultSet c'è almeno una riga
                        loggedUserBean.setName(rs1.getString("name"));
                        loggedUserBean.setSurname(rs1.getString("surname"));
                        loggedUserBean.setCity(rs1.getString("city"));
                        loggedUserBean.setDescription(rs1.getString("description"));
                        loggedUserBean.setInPerson(rs1.getBoolean("inPerson"));
                        loggedUserBean.setOnline(rs1.getBoolean("online"));
                        loggedUserBean.setPag(rs1.getBoolean("pag"));
                        return loggedUserBean;
                    } else {
                        System.out.println("ResultSet vuoto");
                    }
                }
            } else {
                //throw new InvalidCredentialsException("Username o password errati");
            }
        } catch (SQLException e) {
            // handle exception
        }
        return loggedUserBean;
    }
}
