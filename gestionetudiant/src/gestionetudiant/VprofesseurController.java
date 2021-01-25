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

/**
 * FXML Controller class
 *
 * @author Mariama Ba
 */
public class VprofesseurController implements Initializable {

    @FXML
    private TableView<?> tblvProfesseur;
    @FXML
    private TableColumn<?, ?> tblcId;
    @FXML
    private TableColumn<?, ?> tblcNNomPrenom;
    @FXML
    private TableColumn<?, ?> tblcGrade;
    @FXML
    private TableView<?> tblvModules;
    @FXML
    private TableColumn<?, ?> tblcLibelle;
    @FXML
    private TableColumn<?, ?> tblcClasse;
    @FXML
    private ComboBox<?> cmbClasse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleRechercher(ActionEvent event) {
    }
    
}
