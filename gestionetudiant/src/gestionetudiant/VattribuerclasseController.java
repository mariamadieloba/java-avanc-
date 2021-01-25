/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionetudiant;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mariama Ba
 */
public class VattribuerclasseController implements Initializable {

    @FXML
    private TableView<?> tblvModulesEnseigne;
    @FXML
    private TableColumn<?, ?> tblcLibelle;
    @FXML
    private ComboBox<?> cmbGrade;
    @FXML
    private ComboBox<?> cmbModules;
    @FXML
    private TextField txtMatricule;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtNom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleAttribuerClasse(ActionEvent event) {
    }
    
}
