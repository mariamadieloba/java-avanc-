/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import models.Classe;
import models.Details;
import models.Personne;

/**
 *
 * @author Mariama Ba
 */
public class DaoDetails {
    
    private final String SQL_INSERT="INSERT INTO `details` (`classe_id`, `professeur_id`, `modules`, `annee`) VALUES (?, ?)";
    
    private final String SQL_SELECT_BY_MODULES="select * from details where modules=?";
    
    
    
    
    public int insert (Details detail){
        int nbreLigne=0;
        //taritement insertion
        return nbreLigne;
    }

    public List<Classe> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
      public List<Details> findByModules (Details details) {
        List<Details> lDetails=new ArrayList<>();
        
        //recuperation
        return lDetails;
    }
    
    
    
}




