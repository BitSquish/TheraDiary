package com.example.theradiaryispw.logic.otherClasses.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveQuery {

    private RetrieveQuery(){}

    public static ResultSet searchPsychologist(Connection conn, String name, String surname, String city, boolean inPerson, boolean online, boolean pag) throws SQLException {
        String query = "SELECT mail, name, surname, city, description, inPerson, online, pag  FROM psychologist WHERE 1=1";
        if(!name.isEmpty())
            query += " AND name = ?";
        if(!surname.isEmpty())
            query += " AND surname = ?";
        if(!city.isEmpty())
            query += " AND city = ?";
        if(inPerson)
            query += " AND inPerson = ?";
        if(online)
            query += " AND online = ?";
        if(pag)
            query += " AND pag = ?";
        try  {
            PreparedStatement pstmt = conn.prepareStatement(query);
            int i = 1;
            if (!name.isEmpty()) {
                pstmt.setString(i, name);
                i++;
            }
            if (!surname.isEmpty()) {
                pstmt.setString(i, surname);
                i++;
            }

            if (!city.isEmpty()) {
                pstmt.setString(i, city);
                i++;
            }
            if (inPerson) {
                pstmt.setBoolean(i, true);
                i++;
            }
            if (online) {
                pstmt.setBoolean(i, true);
                i++;
            }
            if (pag) {
                pstmt.setBoolean(i, true);
            }
            return pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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

    public static ResultSet retrieveMedicalOffice(Connection conn, String mail) throws SQLException {
        String query = "SELECT mail, city, postCode, address, otherInfo FROM medicaloffice WHERE mail = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, mail);
        return pstmt.executeQuery();
    }
}
