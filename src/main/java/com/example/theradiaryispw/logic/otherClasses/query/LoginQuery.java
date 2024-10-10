package com.example.theradiaryispw.logic.otherClasses.query;

import com.example.theradiaryispw.logic.model.Credentials;
import com.example.theradiaryispw.logic.model.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.model.Patient;
import com.example.theradiaryispw.logic.model.Psychologist;

import java.sql.*;

//NOTA: conviene usare Statement per query senza input, per query con input si usa PreparedStatement

public class LoginQuery {
    public static ResultSet logQuery(Connection conn, Credentials credentialsBean) throws SQLException {
        String query = "SELECT mail, password, role FROM users WHERE mail = ? AND password = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, credentialsBean.getMail());
        pstmt.setString(2, credentialsBean.getPassword());
        return pstmt.executeQuery();
    }

    public static ResultSet retrievePsychologist(Connection conn, String mail) throws SQLException {

        String query = "SELECT name, surname, city, description, inPerson, online, pag FROM psychologist WHERE mail = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, mail);
        return pstmt.executeQuery();
    }

    public static ResultSet retrievePatient(Connection conn, String mail) throws SQLException {
        String query = "SELECT name, surname, city, description, inPerson, online, pag FROM patient WHERE mail = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, mail);
        return pstmt.executeQuery();
    }

    //QUERY REGISTRAZIONE
    public static int registerUser(Connection conn, CredentialsBean credentialsBean) throws SQLException{
        String query = "INSERT INTO users (mail, password, role) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, credentialsBean.getMail());
        pstmt.setString(2, credentialsBean.getPassword());
        pstmt.setString(3, credentialsBean.getRole().toString());
        return pstmt.executeUpdate(); //restituisce il numero di righe influenzate dalla query
    }

    public static int registerPsychologist(Connection conn, Psychologist psychologistBean) throws SQLException {
        String query = "INSERT INTO psychologist (mail, name, surname, city, description, inPerson, online, pag) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, psychologistBean.getCredentialsBean().getMail());
        pstmt.setString(2, psychologistBean.getName());
        pstmt.setString(3, psychologistBean.getSurname());
        pstmt.setString(4, psychologistBean.getCity());
        pstmt.setString(5, psychologistBean.getDescription());
        pstmt.setBoolean(6, psychologistBean.isInPerson());
        pstmt.setBoolean(7, psychologistBean.isOnline());
        pstmt.setBoolean(8, psychologistBean.isPag());
        return pstmt.executeUpdate();
    }

    public static int registerPatient(Connection conn, Patient patientBean) throws SQLException {
        String query = "INSERT INTO patient (mail, name, surname, city, description, inPerson, online, pag) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, patientBean.getCredentialsBean().getMail());
        pstmt.setString(2, patientBean.getName());
        pstmt.setString(3, patientBean.getSurname());
        pstmt.setString(4, patientBean.getCity());
        pstmt.setString(5, patientBean.getDescription());
        pstmt.setBoolean(6, patientBean.isInPerson());
        pstmt.setBoolean(7, patientBean.isOnline());
        pstmt.setBoolean(8, patientBean.isPag());
        return pstmt.executeUpdate();
    }

    public static int checkMail(Connection conn, String mail) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE mail = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, mail);
        ResultSet result = pstmt.executeQuery();
        result.next();
        return result.getInt(1);
    }
}
