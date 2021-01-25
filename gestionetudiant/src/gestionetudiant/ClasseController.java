/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionetudiant;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import metier.Service;
import model.Classe;
import model.Etudiant;

/**
 * FXML Controller class
 *
 * @author Mariama Ba
 */
public class ClasseController implements Initializable {
        //mes variables
        private Service metier;
        //observables
        ObservableList<Classe> obClasses;
        ObservableList<Etudiant> obEtudiants;
        
    @FXML
    private TextField txtLibelle;
    @FXML
    private TextField txtNbreEtudiant;
    
    
    @FXML
    private TableView<Classe> tblvClasse;
    @FXML
    private TableColumn<Classe, String> tblcId;
    @FXML
    private TableColumn<Classe, String> tblcLibelle;
    @FXML
    private TableColumn<Classe, String> tblcNbreEtudiant;
    @FXML
    private TableView<Etudiant> tblvEtudiant;
    @FXML
    private TableColumn<Etudiant, String> tblcEtuId;
    @FXML
    private TableColumn<Etudiant, String> tblcNomPrenom;
    @FXML
    private TableColumn<Etudiant, String> tblcTuteur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        metier=new Service();
        obClasses=FXCollections.observableArrayList(metier.listerClasse());
        
        loadTable();
    } 
    
    private void loadTable() {
        
          //Construction des cellule de table
        tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        tblcNbreEtudiant.setCellValueFactory(new PropertyValueFactory<>("nbre"));
        
       //tableView se souscrit à l'observable
       tblvClasse.setItems(obClasses);
        
        // TODO
        
    }

    @FXML
    private void handleCreerClasse(ActionEvent event) {
        String libelle=txtLibelle.getText();
        int nbre=Integer.parseInt(txtNbreEtudiant.getText());
        Classe cl=new Classe(libelle, nbre);
        
        if(metier.creerClasse(cl)) {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Classe ajoutée avec succes");
            alert.setTitle("Information");
            alert.show();
            //Mettre à jour la TAble View
            obClasses.add(cl);
            
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Erreur Insertion");
            alert.setTitle("Erreur");
            alert.show();
        }
        
    }
    
    

    @FXML
    private void handleShowEtudiant(MouseEvent event) {
        Classe classeSelect=tblvClasse.getSelectionModel().getSelectedItem();
        obEtudiants=FXCollections.observableArrayList (metier.listerEtudiantParClasse(classeSelect));
        
        //construire les colonnes
        tblcEtuId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcNomPrenom.setCellValueFactory(new PropertyValueFactory<>("Nom Prenom"));
        tblcTuteur.setCellValueFactory(new PropertyValueFactory<>("Tuteur"));
        
        //souscription de la tableview à l'observable
        tblvEtudiant.setItems(obEtudiants);
        
    }
    
}
