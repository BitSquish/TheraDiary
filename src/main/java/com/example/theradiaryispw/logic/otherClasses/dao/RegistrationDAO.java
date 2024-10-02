package com.example.theradiaryispw.logic.otherClasses.dao;

import com.example.theradiaryispw.logic.otherClasses.bean.login.PatientBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.PsychologistBean;
import com.example.theradiaryispw.logic.otherClasses.other.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationDAO {
    private RegistrationDAO(){}
    //controllo se l'email è presente o meno
    public static boolean emailExists(String mail) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE mail = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, mail);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }
    //inserisco l'utente nel database
    public static void insertUser(String mail, String password, String role) throws SQLException {
        String query = "INSERT INTO users (mail, password, role) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, mail);
            pstmt.setString(2, password);
            pstmt.setString(3, role);
            pstmt.executeUpdate();
        }
    }
    public static void registerPatient(PatientBean patientBean) throws SQLException{
        if(emailExists(patientBean.getCredentialsBean().getMail())) {
            throw new SQLException(("Email already exists"));//email esistente nel database
        }//inserisco la password e l'email in user
        insertUser(patientBean.getCredentialsBean().getMail(), patientBean.getCredentialsBean().getPassword(), "PATIENT");
        String query="INSERT INTO patient(mail,name,surname,city,description, inPerson, online, pag) VALUES (?, ?, ?, ?, ?, ?, ?,?)";//inserisco in patient
        try(Connection conn= ConnectionFactory.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(query)){
            pstmt.setString(1, patientBean.getCredentialsBean().getMail());
            pstmt.setString(2, patientBean.getName());
            pstmt.setString(3, patientBean.getSurname());
            pstmt.setString(4, patientBean.getCity());
            pstmt.setString(5, patientBean.getDescription());
            pstmt.setBoolean(6, patientBean.isInPerson());
            pstmt.setBoolean(7, patientBean.isOnline());
            pstmt.setBoolean(8, patientBean.isPag());
            pstmt.executeUpdate();
        }
    }

    public static void registerPsychologist(PsychologistBean psychologistBean) throws SQLException {//stessa cosa che ho fatto sopra ma per lo psicologo
        if (emailExists(psychologistBean.getCredentialsBean().getMail())) {
            throw new SQLException("Email already exists");
        }
        insertUser(psychologistBean.getCredentialsBean().getMail(), psychologistBean.getCredentialsBean().getPassword(), "PSYCHOLOGIST");
        String query = "INSERT INTO psychologist (mail,name, surname, city, description, inPerson, online, pag) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, psychologistBean.getCredentialsBean().getMail());
            pstmt.setString(2, psychologistBean.getName());
            pstmt.setString(3, psychologistBean.getSurname());
            pstmt.setString(4, psychologistBean.getCity());
            pstmt.setString(5, psychologistBean.getDescription());
            pstmt.setBoolean(6, psychologistBean.isInPerson());
            pstmt.setBoolean(7, psychologistBean.isOnline());
            pstmt.setBoolean(8, psychologistBean.isPag());
            pstmt.executeUpdate();
        }
    }
}

