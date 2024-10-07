package com.example.theradiaryispw.logic.otherClasses.olddao;

import com.example.theradiaryispw.logic.otherClasses.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.LoggedUserBean;
import com.example.theradiaryispw.logic.otherClasses.other.Role;

public class RetrieveDAO {
    //elimina password ???ù
    public LoggedUserBean executePat(String mail, String password, Role role) {
        LoggedUserBean loggedUserBean = new LoggedUserBean();
        CredentialsBean cb = new CredentialsBean(mail, password, role);
        loggedUserBean.setCredentialsBean(cb);
        return loggedUserBean;

    }
    public LoggedUserBean executePsy(String mail, String password, Role role) {
        LoggedUserBean loggedUserBean = new LoggedUserBean();
        CredentialsBean cb = new CredentialsBean(mail, password, role);
        System.out.println("Se tutto è giusto il ruolo è psicologo -> Ruolo: " + cb.getRole());
        loggedUserBean.setCredentialsBean(cb);
        return loggedUserBean;
    }
}
