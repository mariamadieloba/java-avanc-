/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionetudiant;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mariama Ba
 */
public class VmenuController implements Initializable {


    @FXML
    private AnchorPane AnchorContent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadView("vclasses");
        } catch (IOException ex) {
            Logger.getLogger(VmenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        // TODO
       

    @FXML
    private void handleLoadViewClasse(ActionEvent event) throws IOException {
       loadView("vclasses");
    }
    
    public void loadView(String view) throws IOException{
         AnchorPane ViewLoading=FXMLLoader.load(getClass().getResource(view+".fxml"));
         AnchorContent.getChildren().add(ViewLoading);
    }

    @FXML
    private void handleDeconnexion(ActionEvent event) throws IOException {
        AnchorContent.getScene().getWindow().hide();
            //ouvrir la fenetre
            AnchorPane View= FXMLLoader.load(getClass().getResource("vconnexion.fxml"));
            Scene scene=new Scene (View);
            
            Stage stage=new Stage();
                stage.setScene(scene);
                stage.showAndWait();
    }

    @FXML
    private void handleLoadViewInscription(ActionEvent event) throws IOException {
        loadView("vinscription");
    }

    @FXML
    private void handleLoadViewAttribuerClasse(ActionEvent event) throws IOException {
        loadView("vattribuerclasse");
    }

    @FXML
    private void handleLoadViewModules(ActionEvent event) throws IOException {
        loadView("vprofesseur");
    }

   
    
}
