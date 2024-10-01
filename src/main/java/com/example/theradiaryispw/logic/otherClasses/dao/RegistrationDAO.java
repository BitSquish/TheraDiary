package com.example.theradiaryispw.logic.otherClasses.dao;

import com.example.theradiaryispw.logic.otherClasses.bean.login.PatientBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.PsychologistBean;
import com.example.theradiaryispw.logic.otherClasses.other.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationDAO {
    private RegistrationDAO(){}
    public static void registerPatient(PatientBean patientBean) throws SQLException{
        String query="INSERT INTO patients(mail,password,role,name,surname,city,description, inPerson, online, pag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection conn= ConnectionFactory.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(query)){
            pstmt.setString(1, patientBean.getCredentialsBean().getMail());
            pstmt.setString(2, patientBean.getCredentialsBean().getPassword());
            pstmt.setString(3, patientBean.getCredentialsBean().getRole().name());
            pstmt.setString(4, patientBean.getName());
            pstmt.setString(5, patientBean.getSurname());
            pstmt.setString(6, patientBean.getCity());
            pstmt.setString(7, patientBean.getDescription());
            pstmt.setBoolean(8, patientBean.isInPerson());
            pstmt.setBoolean(9, patientBean.isOnline());
            pstmt.setBoolean(10, patientBean.isPag());
            pstmt.executeUpdate();
        }
    }

    public static void registerPsychologist(PsychologistBean psychologistBean) throws SQLException {
        String query = "INSERT INTO psychologists (mail, password, role, name, surname, city, description, inPerson, online, pag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, psychologistBean.getCredentialsBean().getMail());
            pstmt.setString(2, psychologistBean.getCredentialsBean().getPassword());
            pstmt.setString(3, psychologistBean.getCredentialsBean().getRole().name());
            pstmt.setString(4, psychologistBean.getName());
            pstmt.setString(5, psychologistBean.getSurname());
            pstmt.setString(6, psychologistBean.getCity());
            pstmt.setString(7, psychologistBean.getDescription());
            pstmt.setBoolean(8, psychologistBean.isInPerson());
            pstmt.setBoolean(9, psychologistBean.isOnline());
            pstmt.setBoolean(10, psychologistBean.isPag());
            pstmt.executeUpdate();
        }
    }
}

