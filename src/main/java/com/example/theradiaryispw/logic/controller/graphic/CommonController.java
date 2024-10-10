package com.example.theradiaryispw.logic.controller.graphic;

import com.example.theradiaryispw.logic.controller.graphic.login.LoginController;
import com.example.theradiaryispw.logic.otherClasses.other.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;

public class CommonController {
    protected Session session;

    public CommonController(Session session){
        this.session = session;
    }


    @FXML
    private Line line1;

    @FXML
    private Label contattiLabel;

    @FXML
    private ImageView mail1;

    @FXML
    private ImageView stars1;

    @FXML
    private Label recensioneLabel;

    @FXML
    private ImageView faq1;

    @FXML
    private Label faqLabel;

    @FXML
    protected void goToHomepage(MouseEvent event){
        try{
            FXMLLoader loader;
            if(session.getUser() == null){
                // Carica la nuova pagina FXML
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/HomepageNotLogged.fxml"));
                // Imposta il controller per la nuova pagina
                loader.setControllerFactory(c -> new HomepageController(session));
            }
            else if(session.getUser().getRole().toString().equals("PATIENT")){
                // Carica la nuova pagina FXML
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/HomepageLoggedPt.fxml"));
                // Imposta il controller per la nuova pagina
                loader.setControllerFactory(c -> new HomepagePtLoggedController(session));
            }
            else{
                // Carica la nuova pagina FXML
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/HomepageLoggedPs.fxml"));
                // Imposta il controller per la nuova pagina
                loader.setControllerFactory(c -> new HomepagePtLoggedController(session));
            }
            Parent root = loader.load();
            changeScene(root, event);
        }catch(IOException e){
            System.out.println("Errore: " + e.getMessage());
        }
    }

    @FXML
    protected void goToAccountPage(MouseEvent event) {
        try {
            FXMLLoader loader;
            if (session.getUser() == null) {
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/Login.fxml"));
                loader.setControllerFactory(c -> new LoginController(session));
            } else {
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/Account.fxml"));
                loader.setControllerFactory(c -> new AccountController(session));
            }
            Parent root = loader.load();
            changeScene(root, event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void goToTasks(MouseEvent event){
        try {
            FXMLLoader loader;
            if(session.getUser()==null){
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/Login.fxml"));
                loader.setControllerFactory(c -> new LoginController(session));
            }
            else{
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/DiaryAndTasks.fxml"));
                loader.setControllerFactory(c -> new DiaryAndTasksController(session));
            }
            Parent root = loader.load();
            changeScene(root, event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void goToDashboard(MouseEvent event){
        try {
            FXMLLoader loader;
            if(session.getUser()==null){
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/Login.fxml"));
                loader.setControllerFactory(c -> new LoginController(session));
            }
            else{
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/Dashboard.fxml"));
                loader.setControllerFactory(c -> new DashboardController(session));
            }
            Parent root = loader.load();
            changeScene(root, event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void goToPAG(MouseEvent event){
        try {
            FXMLLoader loader;
            if(session.getUser()==null){
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/Login.fxml"));
                loader.setControllerFactory(c -> new LoginController(session));
            }
            else{
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/PAG.fxml"));
                loader.setControllerFactory(c -> new PAGController(session));
            }
            Parent root = loader.load();
            changeScene(root, event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void goToSearch(MouseEvent event){
        try {
            FXMLLoader loader;
            if(session.getUser()==null){
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/Login.fxml"));
                loader.setControllerFactory(c -> new LoginController(session));
            }
            else{
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/Search.fxml"));
                loader.setControllerFactory(c -> new SearchController(session));
            }
            Parent root = loader.load();
            changeScene(root, event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void goToArticles(MouseEvent event) {
        try {
            FXMLLoader loader;

            // Controllo se l'utente è loggato
            if (session.getUser() == null) {
                // Se l'utente non è loggato, lo reindirizzo alla pagina di login

                // Carico il file FXML per la pagina di login
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/Login.fxml"));
                // Specifico il controller per gestire gli elementi della pagina di login
                loader.setControllerFactory(c -> new LoginController(session));
            } else {
                // Se l'utente è loggato, lo reindirizzo alla pagina degli articoli

                // Carico il file FXML per la pagina degli articoli
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/Articles.fxml"));
                // Specifico il controller per gestire gli elementi della pagina degli articoli
                loader.setControllerFactory(c -> new ArticlesController(session));
            }

            // Carico gli elementi grafici dalla radice del file FXML
            Parent root = loader.load();
            // Cambio la scena passando gli elementi grafici e l'evento che ha chiamato questo metodo
            changeScene(root, event);
        } catch (IOException e) {
            // Lancio un'eccezione runtime se si verifica un errore durante il caricamento del file FXML
            throw new RuntimeException(e);
        }
    }


    protected void changeScene(Parent root, MouseEvent event) {
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


}