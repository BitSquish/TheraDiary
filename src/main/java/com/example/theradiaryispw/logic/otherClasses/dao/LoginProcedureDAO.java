package com.example.theradiaryispw.logic.otherClasses.dao;

import com.example.theradiaryispw.logic.otherClasses.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.exceptions.DAOException;
import com.example.theradiaryispw.logic.otherClasses.other.ConnectionFactory;
import com.example.theradiaryispw.logic.otherClasses.other.Role;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class LoginProcedureDAO implements GenericProcedureDAO<CredentialsBean> {
    @Override
    public CredentialsBean execute(Object... params) throws DAOException, SQLException {
        //estrazione mail e password
        String mail = (String) params[0];
        String password = (String) params[1];
        int role;
        try {
            Connection conn = ConnectionFactory.getConnection();
            //statement per chiamare stored procedure login
            CallableStatement cs = conn.prepareCall("{call login(?,?,?)}");
            //mail e password sono parametri di input, infatti fa set
            cs.setString(1, mail);
            cs.setString(2, password);
            //metodo per registrare parametro di output
            cs.registerOutParameter(3, Types.NUMERIC);
            cs.executeQuery();
            role = cs.getInt(3);
        } catch(SQLException e) {
            throw new DAOException("Errore nel login" +
                    ": " + e.getMessage());
        }
        return new CredentialsBean(mail, password, Role.convertIntToRole(role));
    }
}
