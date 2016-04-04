/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author serq9_000
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Odwiedzajacy {
    public static void OdwiedzDruzyne(Map<Object, Player> gracze, int id,Collection<Warrior> odwiedzani, int oIle){        
      
        //int i=0;
               Iterator itr = odwiedzani.iterator();
                while(itr.hasNext()) 
               {
                     //i++;
                    Warrior element = (Warrior)itr.next();  
                    gracze.get(id).ZwiekszHPWarriora(element, oIle);
               }
                
    }
    
      public static void OdwiedzOsobe(Map<Object, Player> gracze, int id,int oIle){        
      
          gracze.get(id).Cud(oIle);
//          for (int i = 0; i< gracze.get(id).getCount();i++){
//                gracze.get(id).ZwiekszHPWarriora(gracze.get(id).getWarrior(i), oIle);
//                gracze.get(id).getWarrior(i).cuda = gracze.get(id).getWarrior(i).cuda + 1; 
//          }
    }
    
}
