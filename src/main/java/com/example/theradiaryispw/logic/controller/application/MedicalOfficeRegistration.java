package com.example.theradiaryispw.logic.controller.application;

import com.example.theradiaryispw.logic.model.MedicalOffice;
import com.example.theradiaryispw.logic.model.bean.generic.MedicalOfficeBean;
import com.example.theradiaryispw.logic.otherClasses.dao.RegistrationDAO;

import java.sql.SQLException;

public class MedicalOfficeRegistration {
    public void register(MedicalOfficeBean medicalOfficeBean) throws SQLException {
        MedicalOffice medicalOffice = new MedicalOffice(medicalOfficeBean.getMail(), medicalOfficeBean.getCity(), medicalOfficeBean.getPostCode(), medicalOfficeBean.getAddress(), medicalOfficeBean.getOtherInfo());
        try{
            RegistrationDAO.registerMedicalOffice(medicalOffice);
        }catch(SQLException exception){
            throw new RuntimeException(exception.getMessage()); //ECCEZIONE DA VERIFICARE
        }
    }
}
