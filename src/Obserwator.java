/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Observer;
import java.util.Observable;
/**
 *
 * @author serq9_000
 */
public class Obserwator implements Observer{
    
   public Obserwator()
   {
       
   }
    
    public void update(Observable obs, Object obj)
   {
      Akcja a = (Akcja) obj;
      Player p = (Player) obs;
      
      switch(a){
          case UDERZONY:
              System.out.print("Postac gracza " +p.getId()+1 + " zostaje uderzona\n");
          case OSWIECONY:
              System.out.print("Druzyna gracza " +p.getId()+1 + " zostaje oswiecona darem od Boga w postaci zwiekszenia punktow zycia\n");
      }
             
   }
    
//    public void notifyObservers(Object obj)
//    {
//        this.update(null,obj);
//        
//    }
    
    public void printStats()
    {
        //for(int i=0;i<pl.getCount();i++)
         //   {
          //     System.out.println("Pozycja " +this.team.get(i).name() +" nr " +i +"  " +"X:"+this.team.get(i).getPos().getX()+ "  " +"Y:"+this.team.get(i).getPos().getY());
          //     System.out.println("Zycie " +this.team.get(i).name()   +" nr " +i +": " +this.team.get(i).getPointsHealth());
          //  }
    }
    
}
