package com.example.theradiaryispw.logic.otherClasses.bean.login;

public class PatientBean extends LoggedUserBean{
    public PatientBean(CredentialsBean credentialsBean, String name, String surname, String city, String description, boolean inPerson, boolean online, boolean PAG) {
        super();
        setCredentialsBean(credentialsBean);
        setName(name);
        setSurname(surname);
        setCity(city);
        setDescription(description);
        setInPerson(inPerson);
        setOnline(online);
        setPAG(PAG);
    }
}
