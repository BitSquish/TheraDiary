package com.example.theradiaryispw.logic.model.bean.generic;

import com.example.theradiaryispw.logic.model.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.other.Category;

import java.util.ArrayList;
import java.util.List;


public class PatientBean extends LoggedUserBean{
    private ArrayList<Category> categories;
    public PatientBean(CredentialsBean credentialsBean, String name, String surname, String city, String description, Boolean isInPerson, Boolean isOnline, Boolean isPAG, ArrayList<Category> categories,PsychologistBean psychologistBean) {
        super(credentialsBean, name, surname, city, description, isInPerson, isOnline, false);
        this.categories = (categories != null) ? categories : new ArrayList<>();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category){
        this.categories.add(category);
    }

}
