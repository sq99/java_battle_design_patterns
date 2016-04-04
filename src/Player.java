/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.ArrayList;
import java.util.List;
import java.lang.Object;
import java.util.Random;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Observable;
import java.util.Iterator;


/**
 *
 * @author serq9_000
 */
public class Player extends Observable {

    List<Warrior> team = new ArrayList<Warrior>();
   ///private static Map<WarriorName, Warrior> team;
    Random generator = new Random(System.currentTimeMillis());
    
    private int counter;
    private int id;
    //static private int globalCounter = 0;
     
    //private static int idx = 0;
    //private static Player[] __soleInstances = new Player[6];
     
    public Player(int id) {
       counter = 0;
       this.id = id;
    }
    
//     public static Warrior getInstance(WarriorName name) {
//		return team.get(name);
//  }
//  
//  static {
//		team = new ConcurrentHashMap<>();
//		team.put(WarriorName.w1, new Warrior(,WarriorName.w1));
//		nazguls.put(NazgulName.MURAZOR, new Nazgul(NazgulName.MURAZOR));
//		nazguls.put(NazgulName.DWAR, new Nazgul(NazgulName.DWAR));
//		nazguls.put(NazgulName.JI_INDUR, new Nazgul(NazgulName.JI_INDUR));
//		nazguls.put(NazgulName.AKHORAHIL, new Nazgul(NazgulName.AKHORAHIL));
//		nazguls.put(NazgulName.HOARMURATH, new Nazgul(NazgulName.HOARMURATH));
//		nazguls.put(NazgulName.ADUNAPHEL, new Nazgul(NazgulName.ADUNAPHEL));
//		nazguls.put(NazgulName.REN, new Nazgul(NazgulName.REN));
//		nazguls.put(NazgulName.UVATHA, new Nazgul(NazgulName.UVATHA));
//	}
//	
    
   // public Player()
    //{}
    
    public void ZwiekszHPWarriora(Warrior w,int oIle)
    {
         w.setLvlHealth(w.getLvlHealth()+oIle);
    }
    
   public void addWarrior(Warrior w)
   {
       
          
               team.add(w);
   }
   
   public void Cud(int x)
   {
       for (int i = 0; i< this.getCount();i++){
           
                team.get(i).setPointsHealth(team.get(i).getPointsHealth()+x);
                if(team.get(i).getPointsHealth() >= 100){
                    team.get(i).setPointsHealth(100);
                    State fulhp = new FullHPState();
                    team.get(i).zmienStan(fulhp);
          }
       }
      setChanged();
      notifyObservers(Akcja.OSWIECONY);
      clearChanged();
   }
   
   public void uderzony()
   {

       setChanged();
       notifyObservers(Akcja.UDERZONY);
       clearChanged();
   }
   
   public Warrior getWarrior(int i)
   {
       return team.get(i);
   }
    
    public void removeWarrior(int i)
    {
        team.remove(i);
    }
    public int getCount()
    {
        return this.team.size();
    }
    
    //public void printStats()
    //{
       // for(int i=0;i<this.getCount();i++)
            //{
               // System.out.println("Pozycja " +this.team.get(i).name() +" nr " +i +"  " +"X:"+this.team.get(i).getPos().getX()+ "  " +"Y:"+this.team.get(i).getPos().getY());
                //System.out.println("Zycie " +this.team.get(i).name()   +" nr " +i +": " +this.team.get(i).getPointsHealth());
           // }
    //}
    
    
    public void Attack(Player p2, int x, int y)
    {
       // int i = 0; 
        if(p2.getCount()==0 || this.getCount()==0)
        {
            return;
        }
        //System.out.println("count2="+p2.getCount());
        //System.out.println("count1="+this.getCount());
        int przeciwnik = x; 
        //System.out.println("przeciwnik="+przeciwnik);
        int attacker = y;
        //System.out.println("attacker="+attacker);
       // System.out.print(przeciwnik);
        
        this.team.get(attacker).Attack(p2.team.get(przeciwnik));
        //p2.team.get(przeciwnik).stan.zwrocStan(p2.team.get(przeciwnik));
        if(this.team.get(attacker).atakuje == 1)
        {    
            if(p2.team.get(przeciwnik).getPointsHealth() <= 0)
            {
//                System.out.println("Postac nr " +attacker + " atakuje postac nr " +przeciwnik +" pozbawiajac ja zycia.");
                System.out.println(this.team.get(attacker).classname() +" nr " +attacker + " atakuje " +p2.team.get(przeciwnik).classname() +" nr " +przeciwnik +" pozbawiajac go zycia.");
                p2.removeWarrior(przeciwnik);
                p2.uderzony();
                
            }
            else    
            System.out.println(this.team.get(attacker).classname() +" nr " +attacker + " atakuje " +p2.team.get(przeciwnik).classname() + " nr " +przeciwnik + " pozostawiajac mu " +p2.team.get(przeciwnik).getPointsHealth() +" punktow zycia");
            p2.uderzony();
        }
        else
        System.out.println(this.team.get(attacker).classname() +" nr " +attacker + " idzie w strone " +p2.team.get(przeciwnik).classname() + " nr "+przeciwnik);

    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    
}
