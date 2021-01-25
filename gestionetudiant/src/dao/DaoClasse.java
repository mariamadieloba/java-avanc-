/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Classe;

/**
 *
 * @author user
 */

//DAO ORM (object Relationel
public class DaoClasse implements IDao<Classe> {
    private final String SQL_INSERT="INSERT INTO `classe` (`libelle`, `nbre`) VALUES (?,?)";
    private final String SQL_SELECT_ALL="select * from classe";
    private DaoMySql mysql;

    public DaoClasse() {
        mysql=new DaoMySql();
                
    }
    
    @Override
    public int insert(Classe classe){
        int nbreLigne=0;
        
         //insertion
           
        try {
            //1-chargement du driver etouvrir connexion
            mysql.ouvrirConnexionBD();
            //preparer la requete
            mysql.preparerRequete(SQL_INSERT);
            //Remplacer les variables de la requete par les valeurs
             mysql.getPs().setString(1, classe.getLibelle());
             mysql.getPs().setInt(2, classe.getNbre());
            //Executer la requete
            nbreLigne=mysql.executeMisAJour();
        } catch (SQLException ex) {
            Logger.getLogger(DaoClasse.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection();
        }
         return nbreLigne;  
   
    }
    public List<Classe> findAll(){
        List<Classe>lClasses=new ArrayList<>(); 
            try{
                    mysql.ouvrirConnexionBD();
                    mysql.preparerRequete(SQL_SELECT_ALL);
                    //Executer la requete
                    ResultSet rs=mysql.executeSelect();
                    //parcourir le resultat de la requete
                    while(rs.next()){
                     Classe cl = new Classe();
                           //parcours et hydratation des elements
                           /*
                            rs.getInt("id"),
                            rs.getString("libelle"),
                            rs.getInt("nbre"));
                           */
                           //base de donnee vers un object
                           cl.setId(rs.getInt("id"));
                           cl.setLibelle(rs.getString("libelle"));
                           cl.setNbre(rs.getInt("nbre"));
                           //ajout dans la liste
                           lClasses.add(cl);
                    }
            }catch (SQLException ex) {
                Logger.getLogger(DaoClasse.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            mysql.closeConnection();
        }
        //Remplir la liste
        return lClasses;
    }
    
    
    
}
