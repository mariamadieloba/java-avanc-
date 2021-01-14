/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import models.Classe;

/**
 *
 * @author Mariama Ba
 */
public class DaoClasse {
    private final String SQL_INSERT="INSERT INTO `classe` (`id`, `libelle`, `nombre`) VALUES (?, ?;";
    private final String SQL_SELET_ALL="select * from classe";
    
    public int insert(Classe classe){
        int nbreLigne=0;
        
        //insertion
        return nbreLigne;
    }
    
    public List<Classe>findAll(){
        List<Classe>lClasses=new ArrayList<>();
        
        //remplir la list
        return lClasses;
    }
}
