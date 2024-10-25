package com.example.theradiaryispw.logic.controller.application;

import com.example.theradiaryispw.logic.model.MedicalOffice;
import com.example.theradiaryispw.logic.model.bean.generic.MedicalOfficeBean;
import com.example.theradiaryispw.logic.otherClasses.dao.RegistrationDAO;
import com.example.theradiaryispw.logic.otherClasses.dao.RetrieveDAO;
import com.example.theradiaryispw.logic.otherClasses.dao.UpdateDAO;

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

    public boolean retrieveMedicalOffice(MedicalOfficeBean medicalOfficeBean) throws SQLException{
        MedicalOffice medicalOffice = new MedicalOffice(medicalOfficeBean.getMail(), medicalOfficeBean.getCity(), medicalOfficeBean.getPostCode(), medicalOfficeBean.getAddress(), medicalOfficeBean.getOtherInfo());
        boolean medOffAlreadyInserted = RetrieveDAO.retrieveMedicalOffice(medicalOffice);
        if(medOffAlreadyInserted){
            medicalOfficeBean.setMail(medicalOffice.getMail());
            medicalOfficeBean.setCity(medicalOffice.getCity());
            medicalOfficeBean.setPostCode(medicalOffice.getPostCode());
            medicalOfficeBean.setAddress(medicalOffice.getAddress());
            medicalOfficeBean.setOtherInfo(medicalOffice.getOtherInfo());
        }
        return medOffAlreadyInserted;
    }

    public void modify(MedicalOfficeBean medicalOfficeBean) {
        MedicalOffice medicalOffice = new MedicalOffice(medicalOfficeBean.getMail(), medicalOfficeBean.getCity(), medicalOfficeBean.getPostCode(), medicalOfficeBean.getAddress(), medicalOfficeBean.getOtherInfo());
        try{
            UpdateDAO.modifyMedicalOffice(medicalOffice);
        }catch(SQLException exception){
            throw new RuntimeException(exception.getMessage()); //ECCEZIONE DA VERIFICARE
        }
    }
}
