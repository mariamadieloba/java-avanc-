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
import model.Admin;
import model.Classe;
import model.Convert;
import model.Etudiant;
import model.Personne;
import model.Professeur;

/**
 *
 * @author user
 */
public class DaoPersonne implements IDao<Personne>{
    private final String SQL_SELECT_BY_CLASSE="select p.id,nom_Complet,tuteur,p.id,libelle,nbre from personne p,classe cl where type='Etudiant' and classe_id=? and cl.id=p.classe_id";
    //private final String SQL_INSERT="INSERT INTO `personne` (`type`, `id`, `nom_complet`, `tuteur`, `modules`, `grade`, `classe_id`) VALUES (?, ?, ?, ?, ?, ?,?);";
    private final String SQL_INSERT_ETUDIANT="INSERT INTO `personne` ( `type`, `nom_complet`, `tuteur`,`classe_id`) VALUES (?,?,?,?);";    
    private final String SQL_INSERT_PROFESSEUR="INSERT INTO `personne` (`type`, `nom_complet`, `grade`,`modules`,`matricule`) VALUES (?,?,?,?,?);";    
    private final String SQL_SELECT_PROFESSEUR="select * from personne where matricule=?";
    private final String SQL_SELECT_ALL_PROFESSEUR="select * from personne where type='Professeur'";
     private final String SQL_SELECT_CONNECT="select * from personne where login=? and pwd=?";
     private DaoMySql mysql;

    public DaoPersonne() {
        mysql=new DaoMySql();
        
    }
    
     
     
    public List<Etudiant> findByClasse(Classe classe){
          List<Etudiant> lEtudiants=new ArrayList<>();
          
        try {
          
            //ouvrir la connexion
            mysql.ouvrirConnexionBD();
            //preparer la Requete
            mysql.preparerRequete(SQL_SELECT_BY_CLASSE);
            try {
                mysql.getPs().setInt(1, classe.getId());
            } catch (SQLException ex) {
                Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
            }
            //execution de la requete
            ResultSet rs=mysql.executeSelect();
            //recuperation des ifos de la requete
            while(rs.next()) {
                Etudiant etu=new Etudiant();
                etu.setNomComplet(rs.getString("nomComplet"));
                etu.setId(rs.getInt("id"));
                etu.setTuteur(rs.getString("Tuteur"));
                //recuperation des donnees de la classe
                Classe cl=new Classe();
                cl.setId(rs.getInt("classe_id"));
                cl.setLibelle(rs.getString("Libelle"));
                cl.setNbre(rs.getInt("nbre"));
                
                etu.setCl(cl);
                lEtudiants.add(etu);
                
            }    
         
        } catch (SQLException ex) {
            System.err.println("Erreur d'execution de la requete");
        } finally {
            mysql.closeConnection();
        }
           return lEtudiants;
        
        
    }

    
    
    /*public int insert(Personne pers){
        int nbreLigne=0;
        //Traitement Insertion
        return nbreLigne;
        
    }
    */
    
   public int insertEtudiant(Etudiant etu){
       int nbreLigne=0;
       //Traitement Insertion
        try {
           //1-chargement du driver etouvrir connexion
           mysql.ouvrirConnexionBD();
           //preparer la requete
           mysql.preparerRequete(SQL_INSERT_ETUDIANT);
           //(facultative) Remplacer les variables de la requete par les valeurs
           //un objet vers la base de données
           mysql.getPs().setString(1, etu.getType());
            mysql.getPs().setString(2, etu.getNomComplet());
             mysql.getPs().setString(3, etu.getTuteur());
              mysql.getPs().setInt(4, etu.getCl().getId());
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
   
   
   public int insertProfesseur(Professeur prof){
       int nbreLigne=0;
       //Traitement Insertion
        try {
           //1-chargement du driver etouvrir connexion
           mysql.ouvrirConnexionBD();
           //preparer la requete
           mysql.preparerRequete(SQL_INSERT_PROFESSEUR);
           //(facultative) Remplacer les variables de la requete par les valeurs
           //un objet vers la base de données
           mysql.getPs().setString(1, prof.getType());
            mysql.getPs().setString(2, prof.getNomComplet());
             mysql.getPs().setString(3, prof.getGrade());
              mysql.getPs().setString(4, Convert.listToString(prof.getModules()));
             mysql.getPs().setString(5, prof.getMatricule());
             
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
   
    
    public Professeur findProfesseurByMatricule(String matricule){
        Professeur professeur=null;
        
         
        try {
            //ouvrir la connexion
            mysql.ouvrirConnexionBD();
            //preparer la Requete
            mysql.preparerRequete(SQL_SELECT_PROFESSEUR);
            mysql.getPs().setString(1, matricule);
            ResultSet rs=mysql.executeSelect();
            if(rs.next()){
            
                professeur=new Professeur();
                professeur.setId(rs.getInt("id"));
                professeur.setNomComplet(rs.getString("nom_complet"));
                professeur.setGrade(rs.getString("grade"));
                professeur.setMatricule(rs.getString("matricule"));
                professeur.setModules(Convert.StringToList(rs.getString("modules")));  
            } 
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return professeur;
    }
    public List<Professeur> findProfesseur(){
        List<Professeur>lProfesseurs=new ArrayList<>();
        
        //Remplir la liste
        return lProfesseurs;
    }
    public Personne findUserConnect(String login,String pwd){
        Personne personne=null;
        mysql.ouvrirConnexionBD();
        mysql.preparerRequete(SQL_SELECT_CONNECT);
         try {
            mysql.getPs().setString(1, login);
            mysql.getPs().setString(2, pwd);
            ResultSet rs=mysql.executeSelect();
            if(rs.next()){
                if(rs.getString("type").trim().compareTo("Etudiant")==0) {
                    personne=new Etudiant(rs.getString("Tuteur"));
                }else{
                    if(rs.getString("type").trim().compareTo("Professeur")==0) {
                     personne=new Professeur();   
                     ((Professeur)personne).setGrade(rs.getString("grade"));
                     ((Professeur)personne).setMatricule(rs.getString("matricule"));
                     ((Professeur)personne).setModules(Convert.StringToList(rs.getString("modules")));
                     
                    }else{
                        personne=new Admin();
                    }
                }
                
                personne.setId(rs.getInt("id"));
                personne.setNomComplet(rs.getString("nom_complet"));
                personne.setLogin(rs.getString("Login"));
                personne.setPwd(rs.getString("pwd"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return personne;
    }
    
    

    @Override
    public int insert(Personne objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
