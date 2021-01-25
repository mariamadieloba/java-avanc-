/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionetudiant;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import metier.Service;
import model.Personne;

/**
 * FXML Controller class
 *
 * @author Mariama Ba
 */
public class VconnexionController implements Initializable {

    @FXML
    private PasswordField txtpwd;
    @FXML
    private TextField txtlogin;
    @FXML
    private Text lblError;
    
    private Service metier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblError.setVisible(false);
        metier=new Service();
        // TODO
    }    

    @FXML
    private void handleConnexion(ActionEvent event) throws IOException {
        String Login=txtlogin.getText();
        String pwd=txtpwd.getText();
        Personne personne=metier.seConnecter(Login, pwd);
        if (personne==null){
            lblError.setVisible(true);
        }else{
            txtlogin.getScene().getWindow().hide();
            //ouvrir la fenetre
            AnchorPane View= FXMLLoader.load(getClass().getResource("vmenu.fxml"));
            Scene scene=new Scene (View);
            
            Stage stage=new Stage();
                stage.setScene(scene);
                stage.showAndWait();
            
            
            
            
        }
                
                
                
    }
}
