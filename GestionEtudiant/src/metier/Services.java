/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.DaoClasse;
import dao.DaoDetails;
import dao.DaoPersonne;
import java.util.List;
import models.Classe;
import models.Details;
import models.Etudiant;
import models.Personne;
import models.Professeur;

/**
 *
 * @author Mariama Ba
 */
public class Services {
    private DaoClasse daoClasse;
    private DaoPersonne daoPersonne;
    private DaoDetails daoDetails;

    public Services() {
        daoClasse=new DaoClasse();
        daoPersonne=new DaoPersonne();
        daoDetails=new DaoDetails();
    }
    
    
    public List<Personne> listerEtudiantParClasse (Classe classe){
        return daoPersonne.findByClasse(classe);
    }
            
    public boolean creerClasse(Classe classe){
        
        int nbreLigne= daoClasse.insert(classe);
        return nbreLigne != 0;
    }
    
    public List<Classe> listerClasse(){
        return daoClasse.findAll();
    }
    
    /*
    public boolean creerEtudiant(Etudiant etu){
          return daoPersonne.insert(etu)!=0;
          
    }
    
     public boolean creerProfesseur(Professeur pers){
          return daoPersonne.insert(prof)!=0;
          
    }
    */
    
     public boolean creerPersonne(Personne pers){
          return daoPersonne.insert(pers)!=0;
          
    }
    
    
    public Professeur chercherProfesseur (String matricule){
        return daoPersonne.findProfesseurByMatricule(matricule);
    }
   
    
    public boolean attribuerClasse(Classe classe,
                                  Professeur prof,
                                  List<String> modules,
                                  String annee){
        
         if (prof.getId()==0){
            int id= daoPersonne.insert(prof);
            prof.setId(id);
            
        
    }
         Details detail=new Details(annee, modules, classe, prof);
         return daoDetails.insert(detail)!=0;
    
}
  
       public List<Classe> listerProfesseur(){
        return daoPersonne.findAll();
    }     
       
        public List<Classe> listerModules(){
        return daoDetails.findAll();
    }     
      
      public List<Personne> listerModulesParClasse (Classe details){
        return daoPersonne.findByClasse(details);
    }   
    
}
