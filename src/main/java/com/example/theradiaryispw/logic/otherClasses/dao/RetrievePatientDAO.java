package com.example.theradiaryispw.logic.otherClasses.dao;

import com.example.theradiaryispw.logic.otherClasses.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.LoggedUserBean;
import com.example.theradiaryispw.logic.otherClasses.other.Role;

public class RetrievePatientDAO {
    //elimina password
    public LoggedUserBean execute(String mail, String password, Role role) {
        LoggedUserBean loggedUserBean = new LoggedUserBean();
        CredentialsBean cb = new CredentialsBean(mail, password, role);
        loggedUserBean.setCredentialsBean(cb);
        return loggedUserBean;
    }
}
