/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import models.Classe;
import models.Personne;
import models.Professeur;

/**
 *
 * @author Mariama Ba
 */
public class DaoPersonne {
    private final String SQL_SELECT_BY_CLASSE="select * from personne where type='Etudiant' and classe_id=?";
    
    private final String SQL_INSERT="INSERT INTO 'personne' ('classe.id', 'type', 'id', 'nomComplet', 'tuteur', 'modules', 'grade') VALUES (?, ?, ?, ?, ?, ?)";
    
    private final String SQL_SELECT_PROFESSEUR="select * from personne where matricule=?";
    
    private final String SQL_SELECT_BY_PROFESSEUR="select * from personne where classe_id=?";
    
    
    
    public List<Personne> findByClasse(Classe classe) {
        List<Personne> lEtudiants=new ArrayList<>();
        
        //recuperation
        return lEtudiants;
    }
    
     public List<Personne> findByProfesseur (Personne professeur) {
        List<Personne> lProfesseur=new ArrayList<>();
        
        //recuperation
        return lProfesseur;
    }
    
    
    
    public int insert (Personne pers){
        int nbreLigne=0;
        
        // traitement insertion
        return nbreLigne;
    }
    
   public Professeur findProfesseurByMatricule(String matricule){
       Professeur professeur=null;
        Professeur Professeur = null;
       //recherche
       return Professeur;
   }

    public List<Classe> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
