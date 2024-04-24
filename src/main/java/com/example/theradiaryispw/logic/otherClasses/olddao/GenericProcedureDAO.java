package com.example.theradiaryispw.logic.otherClasses.olddao;

import com.example.theradiaryispw.logic.otherClasses.exceptions.DAOException;

import java.sql.SQLException;

public interface GenericProcedureDAO<T> {
    T execute(Object... params) throws DAOException, SQLException;
}
