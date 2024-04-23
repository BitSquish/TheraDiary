package com.example.theradiaryispw.logic.otherClasses.dao;

import com.example.theradiaryispw.logic.otherClasses.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.LoggedUserBean;
import com.example.theradiaryispw.logic.otherClasses.exceptions.DAOException;
import com.example.theradiaryispw.logic.otherClasses.other.ConnectionFactory;
import com.example.theradiaryispw.logic.otherClasses.other.Role;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class RetrievePsychologistDAO {//implements GenericProcedureDAO {
/*    @Override
    public LoggedUserBean execute(Object... params) throws DAOException, SQLException {
        //estrazione mail e password
        String mail = (String) params[0];
        String name, surname, city, description;
        boolean inPerson, online, pag;
        try {
            Connection conn = ConnectionFactory.getConnection();
            //statement per chiamare stored procedure login
            CallableStatement cs = conn.prepareCall("{call retrievePsychologist(?)}");
            //mail e password sono parametri di input, infatti fa set
            cs.setString(1, mail);
            //metodo per registrare parametro di output
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.executeQuery();

            name = cs.getString(1);
        } catch(SQLException e) {
            throw new DAOException("Errore nel login: " + e.getMessage());
        }
        return new LoggedUserBean();
    }*/
//elimina password e ruolo
    public LoggedUserBean execute(String mail, String password, Role role) {
        LoggedUserBean loggedUserBean = new LoggedUserBean();
        CredentialsBean cb = new CredentialsBean(mail, password, role);
        System.out.println("Se tutto è giusto il ruolo è psicologo -> Ruolo: " + cb.getRole());
        loggedUserBean.setCredentialsBean(cb);
        return loggedUserBean;
    }
}
