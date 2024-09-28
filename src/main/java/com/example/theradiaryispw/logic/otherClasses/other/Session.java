package com.example.theradiaryispw.logic.otherClasses.other;

import com.example.theradiaryispw.logic.otherClasses.bean.login.LoggedUserBean;

public class Session {
    private LoggedUserBean user;  //utente loggato
    private Role role;
    private String homepage;

    private boolean commandLine;    //seconda interfaccia


    //NOTA: Interfaccia per scorso anno, ora non va più bene
    public void setCommandLine(boolean commandLine){ this.commandLine = commandLine; }
    public boolean isCommandLine(){ return commandLine; }
    public Session(boolean commandLine) {
        this.user = null;
        this.commandLine = commandLine;
        if(isCommandLine())
            this.homepage="/com/example/theradiaryispw/logic/view/HomepageNotLogged.fxml";  //ATTENZIONE: QUI VA LA SECONDA INTERFACCIA, ANCORA DA FARE
        else
            this.homepage = "/com/example/theradiaryispw/logic/view/HomepageNotLogged.fxml"; //homepage con gui
    }

    public String getHomepage(){
        return this.homepage;
    }

    public void setHomepage(Role role){
        //Assegna homepage a seconda del ruolo
    }

    public LoggedUserBean getUser(){
        return this.user;
    }

    public void setUser(LoggedUserBean user){
        this.user = user;
    }


}
