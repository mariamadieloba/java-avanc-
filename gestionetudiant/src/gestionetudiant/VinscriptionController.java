/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionetudiant;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import metier.Service;
import model.Classe;
import model.Etudiant;

/**
 * FXML Controller class
 *
 * @author Mariama Ba
 */
public class VinscriptionController implements Initializable {
    
   private Service metier;
   ObservableList<Classe> obClasses;

   @FXML
   private ComboBox<Classe> cmbClasse;
   @FXML
   private TextField txtNom;
   @FXML
   private TextField txtPrenom;
   @FXML
   private TextField txtTuteur;

   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
       // TODO
       metier=new Service();
       //chargement de l'observableList à partir de List de classe
       obClasses=FXCollections.observableArrayList(metier.listerClasse());
       cmbClasse.setItems(obClasses);
   }    

   private void handleLoadInscrire(ActionEvent event) {
       
       }
  @FXML
    private void handleInscription(ActionEvent event) {
 String nom=txtNom.getText();
        String prenom=txtPrenom.getText();
        String tuteur=txtTuteur.getText();
        Classe cl=this.cmbClasse.getValue();
        Etudiant etu=new Etudiant(tuteur, prenom+ " " + nom);
        etu.setCl(cl);
       if(metier.creerEtudiant(etu)){
           Alert alert=new Alert(Alert.AlertType.INFORMATION);
           alert.setContentText("Etudiant inscrit avec succés");
           alert.setTitle("Information");
           alert.show();
           //mettre à jour la tableview
           obClasses.add(cl);
       }else{
           Alert alert=new Alert(Alert.AlertType.ERROR);
           alert.setContentText("Erreur Insertion");
           alert.setTitle("Erreur");
           alert.show();
    }
   
}
   }

  
