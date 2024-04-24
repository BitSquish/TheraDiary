package com.example.theradiaryispw.logic.otherClasses.dao;

import com.example.theradiaryispw.logic.otherClasses.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.LoggedUserBean;
import com.example.theradiaryispw.logic.otherClasses.other.ConnectionFactory;
import com.example.theradiaryispw.logic.otherClasses.other.Role;
import com.example.theradiaryispw.logic.otherClasses.query.LoginQuery;

import javax.security.auth.login.CredentialException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
    private LoginDAO(){};

    public static LoggedUserBean login(CredentialsBean credentialsBean) throws SQLException {
        Statement stmt = null;
        Connection conn = null;
        LoggedUserBean loggedUserBean = new LoggedUserBean();
        try{
            conn = ConnectionFactory.getConnection();
            //TYPE_SCROLL_INSENSITIVE = il ResultSet può scorrere avanti e indietro e che non riflette automaticamente i cambiamenti nel database.
            //CONCUR_READ_ONLY = CONCUR_READ_ONLY indica che il ResultSet è in sola lettura e non può essere utilizzato per aggiornare i dati nel database.
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = LoginQuery.logQuery(stmt, credentialsBean);
            if(rs.next()){
                String mail = rs.getString("mail");
                String password = rs.getString("password");
                Role role = Role.valueOf(rs.getString("role"));
                CredentialsBean cred = new CredentialsBean(mail, password, role);
                loggedUserBean.setCredentialsBean(cred);
                ResultSet rs1;
                if(role.getId() == 1){
                    System.out.println("Qui ci entra");
                    rs1 = LoginQuery.retrievePsychologist(stmt, mail);
                }
                else{
                    rs1 = LoginQuery.retrievePatient(stmt, mail);
                }
                if (rs1.next()) {// Check if ResultSet rs1 has at least one row
                    loggedUserBean.setName(rs1.getString("name"));
                    System.out.println("Dato1: " + loggedUserBean.getName());
                    loggedUserBean.setSurname(rs1.getString("surname"));
                    System.out.println("Dato2: " + loggedUserBean.getSurname());
                    loggedUserBean.setCity(rs1.getString("city"));
                    loggedUserBean.setDescription(rs1.getString("description"));
                    loggedUserBean.setInPerson(rs1.getBoolean("inPerson"));
                    loggedUserBean.setOnline(rs1.getBoolean("online"));
                    loggedUserBean.setPAG(rs1.getBoolean("pag"));
                    return loggedUserBean;
                } else {
                    // Handle empty result set for rs1
                    System.out.println("ResultSet vuoto");
                }
            }
            else{
                //gestisci credenziali errate
            }

        } finally{
            // Chiusura dello statement per rilasciare le risorse
            if (stmt != null)
                stmt.close();
        }
        return loggedUserBean;
    }
}
