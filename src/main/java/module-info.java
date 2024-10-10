module com.example.theradiaryispw {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    exports com.example.theradiaryispw.logic.view;
    opens com.example.theradiaryispw.logic.view to javafx.fxml;
    exports com.example.theradiaryispw.test;
    opens com.example.theradiaryispw.test to javafx.fxml;
    exports com.example.theradiaryispw.logic.controller.graphic;
    opens com.example.theradiaryispw.logic.controller.graphic to javafx.fxml;
    exports com.example.theradiaryispw.logic.otherClasses.other;
    opens com.example.theradiaryispw.logic.otherClasses.other to javafx.fxml;
    exports com.example.theradiaryispw.logic.otherClasses.bean.login;
    opens com.example.theradiaryispw.logic.otherClasses.bean.login to javafx.fxml;
    exports com.example.theradiaryispw.logic.model;
    opens com.example.theradiaryispw.logic.model to javafx.fxml;
    exports com.example.theradiaryispw.logic.otherClasses.bean;
    opens com.example.theradiaryispw.logic.otherClasses.bean to javafx.fxml;
    exports com.example.theradiaryispw.logic.controller.graphic.login;
    opens com.example.theradiaryispw.logic.controller.graphic.login to javafx.fxml;

}