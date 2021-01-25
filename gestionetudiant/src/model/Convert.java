/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mariama Ba
 */
public class Convert {
    
     public static String listToString(List<String> modules){
        String StringModules="";
        for(String elt:modules){
            StringModules+=elt+";";
        }
        return StringModules;
    }
   
     public static List<String> StringToList (String modules){
         List<String> lModules=new ArrayList<>();
         String tab[]= modules.split(";");
         for(String elt :tab){
              lModules.add (elt);
         }
       return lModules;
           
                 
     }
    
}
