package com.example.theradiaryispw.logic.otherClasses.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchQuery {

    private SearchQuery(){}

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
}
