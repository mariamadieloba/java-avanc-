/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Classe;
import model.Convert;
import model.Details;
import model.Personne;
import model.Professeur;

/**
 *
 * @author user
 */
public class DaoDetails implements IDao<Details> {
    
    private final String SQL_INSERT="INSERT INTO `details` (`modules`, `annee`, `classe_id`, `professeur_id`) VALUES (?, ?, ?, ?);";
    private final String SQL_SELECT_MODULES="select * from details where classe_id=? and professeur_id=?";
    private final String SQL_SELECT_ALL_MODULES="select modules from details"; 
    
    private DaoMySql mysql;
    
    @Override
    //override:methode redéfinie
    public int insert(Details details){
        int nbreLigne=0;
        try {
           //1-chargement du driver etouvrir connexion
           mysql.ouvrirConnexionBD();
           //preparer la requete
           mysql.preparerRequete(SQL_INSERT);
           //(facultative) Remplacer les variables de la requete par les valeurs
           //un objet vers la base de données
           mysql.getPs().setString(1, Convert.listToString(details.getModules()));
           mysql.getPs().setString(2, details.getAnnee());
           mysql.getPs().setInt(3, details.getClasse().getId());
           mysql.getPs().setInt(4, details.getProfesseur().getId());
           //Executer la requete
           //insert,select,update
           nbreLigne=mysql.executeMisAJour();
       } catch (SQLException ex) {
           Logger.getLogger(DaoClasse.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           mysql.closeConnection();
       }
        
         return nbreLigne;   
   
    }
       

    public List<Details>findModules(Details details){
        List<Details> lModules=new ArrayList<>();
        
         try {
           //1 ouvrir la connexion
           mysql.ouvrirConnexionBD();
           //2 preparer la requete
           mysql.preparerRequete(SQL_SELECT_MODULES);
           //vérification des parametres et injection dans la requete
           mysql.getPs().setInt(1, details.getClasse().getId());
           mysql.getPs().setInt(2, details.getProfesseur().getId());
           //execution de la requete
           ResultSet rs=mysql.executeSelect();
           //etape de recuperation des informations de la requete
           while(rs.next()){
               //recuperer les données des details
               details.setModules(Convert.StringToList(rs.getString("modules")));        
               //recuperer les données de la classe et du professeur
                Classe cl=new Classe();
                cl.setId(rs.getInt("classe_id"));
                cl.setLibelle(rs.getString("libelle"));
                cl.setNbre(rs.getInt("nbre"));
               Professeur prof=new Professeur();
               prof.setId(rs.getInt("id"));
               prof.setNomComplet(rs.getString("nomComplet"));
               prof.setGrade(rs.getString("grade"));
               prof.setMatricule(rs.getString("matricule"));
               //faire la relation
               details.setProfesseur(prof);
               details.setClasse(cl);
               //ajouter les modules dans la liste
               lModules.add(details);
           }
       } catch (SQLException ex) {
           Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           mysql.closeConnection();
       }
        
        
        //Remplir la liste
        return lModules;

    }
    
    
    public List<Details>findAllModules(){
         List<Details> lModules=new ArrayList<>();
         try{
                   mysql.ouvrirConnexionBD();
                   mysql.preparerRequete(SQL_SELECT_ALL_MODULES);
                   //Executer la requete
                    //une requete select() retourne toujours un resultset
                   ResultSet rs=mysql.executeSelect();
                   
                   //Parcourir le resultat de la requete
                   while(rs.next()){
                          Details details=new Details();
                          details.setModules(Convert.StringToList(rs.getString("modules")));
                         
                          //ajout dans la liste
                          lModules.add(details);
                   }
           }catch (SQLException ex) {
               Logger.getLogger(DaoClasse.class.getName()).log(Level.SEVERE, null, ex);
           }finally{
           mysql.closeConnection();
       }
       //Remplir la liste
       return lModules;      
  }
    

    
    
}
