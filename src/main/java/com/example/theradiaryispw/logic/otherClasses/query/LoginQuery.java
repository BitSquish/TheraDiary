package com.example.theradiaryispw.logic.otherClasses.query;

import com.example.theradiaryispw.logic.model.Credentials;
import com.example.theradiaryispw.logic.model.Patient;
import com.example.theradiaryispw.logic.model.Psychologist;
import com.example.theradiaryispw.logic.otherClasses.exceptions.MailAlreadyExistsException;

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
    public static int registerUser(Connection conn, Credentials credentialsBean) throws SQLException{
        String query = "INSERT INTO users (mail, password, role) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, credentialsBean.getMail());
        pstmt.setString(2, credentialsBean.getPassword());
        pstmt.setString(3, credentialsBean.getRole().toString());
        return pstmt.executeUpdate(); //restituisce il numero di righe influenzate dalla query
    }

    public static void registerPsychologist(Connection conn, Psychologist psychologist) throws SQLException, MailAlreadyExistsException {
        String query = "INSERT INTO psychologist (mail, name, surname, city, description, inPerson, online, pag) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, psychologist.getCredentials().getMail());
        pstmt.setString(2, psychologist.getName());
        pstmt.setString(3, psychologist.getSurname());
        pstmt.setString(4, psychologist.getCity());
        pstmt.setString(5, psychologist.getDescription());
        pstmt.setBoolean(6, psychologist.isInPerson());
        pstmt.setBoolean(7, psychologist.isOnline());
        pstmt.setBoolean(8, psychologist.isPag());
        int rs = pstmt.executeUpdate();
        if(rs == 0){
            throw new MailAlreadyExistsException("Mail già esistente");
        }
    }

    public static void registerPatient(Connection conn, Patient patient) throws SQLException, MailAlreadyExistsException {
        String query = "INSERT INTO patient (mail, name, surname, city, description, inPerson, online, pag) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, patient.getCredentials().getMail());
        pstmt.setString(2, patient.getName());
        pstmt.setString(3, patient.getSurname());
        pstmt.setString(4, patient.getCity());
        pstmt.setString(5, patient.getDescription());
        pstmt.setBoolean(6, patient.isInPerson());
        pstmt.setBoolean(7, patient.isOnline());
        pstmt.setBoolean(8, patient.isPag());
        int rs = pstmt.executeUpdate();
        if(rs == 0){
            throw new MailAlreadyExistsException("Mail già esistente");
        }
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
