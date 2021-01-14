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
public class exercice2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //1- creer une liste de Personne
        List<String> lPersonne=new ArrayList();
        
        //Ajouter 3 étudiants 
        lPersonne.add ("BA dielo");
        lPersonne.add ("CAMARA Diao");
        lPersonne.add ("Sylla Satou");
        
         //Ajouter 3 professeurs
        lPersonne.add ("WANE Baila");
        lPersonne.add ("SAMB Dora");
        lPersonne.add ("NDER Doudou");
        
        //3- affichage de la liste de Personne
        //Methode1
        lPersonne.forEach((elt) -> {
            System.out.println(elt);
        });
        
        //4- supprimer des elts
       lPersonne.remove ("0, D");
       lPersonne.remove(2);
       System.out.println("Affichage apres Supression");
       lPersonne.forEach((elt) -> {
            System.out.println(elt);
        });
        
        
        
    }
    
}
