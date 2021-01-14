/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours.list;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mariama Ba
 */
public class Exercice1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
           creer une liste string
           ajouter des elements
           affichage de la liste
           supprimer des elts
           modifier un elts de la liste
           rechercher un elts de la liste
        */
        
        //1- creer une liste String
        List<String> lString=new ArrayList();
        
        //2- ajouter des elts
        lString.add ("Bonjour");
        lString.add ("Au Revoir");
        lString.add ("Les Etudiants de la liage 3");
        
        //3- affichage de la liste
        //Methode1
        lString.forEach((elt) -> {
            System.out.println(elt);
        });
            
        lString.add(0, "Debut");
        lString.forEach((elt) -> {
            System.out.println(elt);
        });
        
       //4- supprimer des elts
       lString.remove ("Debut");
       lString.remove(2);
       System.out.println("Affichage apres Supression");
       lString.forEach((elt) -> {
            System.out.println(elt);
        });
       
       //5- modifier un elts
        lString.set (0, "Bonsoir");
        System.out.println("Affichage apres Modification");
        lString.forEach((elt) -> {
            System.out.println(elt);
        });
       
         //5- rechercher un elts de la liste
        if (lString.contains ("Bonjour")==true) {;
            System.out.println("Element existe");
        }else{
             System.out.println("Element Pas existe");
        };
       
        
       
       
             
        
        
                
                
    }
    
}
