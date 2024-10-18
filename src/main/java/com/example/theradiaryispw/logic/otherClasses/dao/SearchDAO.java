package com.example.theradiaryispw.logic.otherClasses.dao;

import com.example.theradiaryispw.logic.model.Credentials;
import com.example.theradiaryispw.logic.model.Psychologist;
import com.example.theradiaryispw.logic.otherClasses.exceptions.NoResultException;
import com.example.theradiaryispw.logic.otherClasses.other.ConnectionFactory;
import com.example.theradiaryispw.logic.otherClasses.other.Role;
import com.example.theradiaryispw.logic.otherClasses.query.SearchQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SearchDAO {
    private SearchDAO(){}

    public static void searchDao(List<Psychologist> psychologists, String name, String surname, String city, boolean inPerson, boolean online, boolean pag) throws NoResultException{

        try (Connection conn = ConnectionFactory.getConnection();
             ResultSet rs = SearchQuery.searchPsychologist(conn, name, surname, city, inPerson, online, pag)) {
            if(!rs.next())
                throw new NoResultException("La ricerca non ha prodotto risultati");
             do{
                //Passare la password come null o creare nuovo costruttore solo con la mail?
                Credentials credentials = new Credentials(rs.getString("mail"), null, Role.PSYCHOLOGIST);
                Psychologist psychologist = new Psychologist(
                        credentials,
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("city"),
                        rs.getString("description"),
                        rs.getBoolean("inPerson"),
                        rs.getBoolean("online"),
                        rs.getBoolean("pag"),
                        null
                );
                psychologists.add(psychologist);
            }while(rs.next());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
