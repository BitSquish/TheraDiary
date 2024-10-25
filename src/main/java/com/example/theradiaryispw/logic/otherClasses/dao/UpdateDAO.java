package com.example.theradiaryispw.logic.otherClasses.dao;

import com.example.theradiaryispw.logic.model.MedicalOffice;
import com.example.theradiaryispw.logic.otherClasses.other.ConnectionFactory;
import com.example.theradiaryispw.logic.otherClasses.query.LoginAndRegistrationQuery;
import com.example.theradiaryispw.logic.otherClasses.query.UpdateQuery;

import java.sql.Connection;
import java.sql.SQLException;

public class UpdateDAO {
    public static void modifyMedicalOffice(MedicalOffice medicalOffice) throws SQLException {
        try(Connection conn = ConnectionFactory.getConnection()){
            UpdateQuery.modifyMedicalOffice(conn, medicalOffice.getMail(), medicalOffice.getCity(), medicalOffice.getPostCode(), medicalOffice.getAddress(), medicalOffice.getOtherInfo());
        } catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
    }
}
