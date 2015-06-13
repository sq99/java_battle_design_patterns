/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Math;
import java.util.Iterator;
import java.util.Observable;

/**
 *
 * @author Filip
 */
public class Warrior { // extends Observable {

    public static final int MAX_ATT_POINTS = 100;
    public static final int MAX_MOVE_POINTS = 100;
    public static final int MAX_HEALTH_POINTS = 10;
    public static final int MAX_POS_X = 8;
    public static final int MAX_POS_Y = 8;
    
    
    String classname;
    
    public String classname()
    {
           return classname;
    }

    private Vec2 Pos = new Vec2();

    public Vec2 getPos() {
        return Pos;
    }
    public void setPos(int x, int y) {
        Pos.setX(x);
        Pos.setY(y);
    }


    
//    public Vec2 setPos(int x, int y) {
//        Pos.setX(x);
//        Pos.setY(y);
//    }

    float lvlAttack; // 0 - MAX_ATT_POINTS
    float lvlMove;  // 0 - MAX_MOVE_POINTS 
    protected float lvlHealth; // 0 - MAX_HEALTH_POINTS

    protected float pointsAttack;
    protected float pointsMove;
    protected float pointsHealth;
    
    protected int cuda;
    
    public State stan = null;

    
    //setchanged
    //notify observers
    //private WarriorName name;

    List<Weapon> bronie = new ArrayList<Weapon>();
    List<Mover> transport = new ArrayList<Mover>();

    public Warrior(List<Weapon> bronie, List<Mover> transport, int lvlA, int lvlM, int lvlH) {
        this.bronie = bronie;
        this.transport = transport;

        this.lvlAttack = lvlA;
        this.lvlMove = lvlM;
        this.lvlHealth = lvlH;
        this.pointsHealth = 100;
        classname = "warrior";
        this.cuda = 0;
        this.stan = new FullHP(); 
        
        //this.getStan();
 
        //this.name = name;
    }
    
//    public static Warrior getInstance(WarriorName name) {
//		return nazguls.get(name);
//	}
//	
	//public WarriorName getName() {
	//	return name;
	//}
   
    
    
    public void getStan()
    {
        this.stan.zwrocStan(this);
    }
    
    /**
     * @return the pointsAttack
     */
    
    public float getPointsAttack() {
        float ret = 0;
        Iterator iter1 = bronie.iterator();
//        for (int i = 0; i < bronie.size(); i++) {
//            Weapon wp = (Weapon) bronie.get(i);
//            ret += wp.getHitPoints();
        while(iter1.hasNext())
        {
            Object wp = (Object)iter1.next();
            ret+=((Weapon)wp).getHitPoints();
        }
        if (ret > 0) {
            ret *= lvlAttack / MAX_ATT_POINTS;
        }

        return ret;
    }

    /**
     *
     * /
     *
     **
     * @return the pointsMove
     */
    public float getPointsMove() {
        float ret = 0;
        Iterator iter2 = transport.iterator();

        while(iter2.hasNext())
        {
            Object mv = (Object)iter2.next();
            ret+=((Mover)mv).getMovePoints();
        }
        
//        for (int i = 0; i < transport.size(); i++) {
//            Mover mv = (Mover) transport.get(i);
//            ret += mv.getMovePoints();
//        }
        if (ret > 0) {
            ret *= lvlMove / MAX_MOVE_POINTS;
        }
        
        return ret;
    }

    public float getPointsHealth() {
        return pointsHealth * getLvlHealth();
    }

//    public float getAttackWithMove(){
//    
//        return getPointsAttack()/getPointsMove();
//    }
    
public int atakuje = 0;


    
    public void Attack(Warrior Defender) {

       // Mover mv = new Mover();

//      if(bronie.get(randBron).getRangePoints() >=  Math.hypot(Defender.getPos().getX()-this.getPos().getX(),Defender.getPos().getY()-this.getPos().getY())) {
//          Defender.setPointsHealth(Defender.getPointsHealth() - bronie.get(randBron).getHitPoints());
//      else{
//          int pozostale = (int)this.getPointsMove();
//          while(pozostale > 0){
//          
//              if(Defender.getPos().getX() > this.getPos().getX())
//                  this.setPos(this.getPos.getX()+1,this.getPos.getY());
//              
//              pozostale--;
//          }
//         
//      }
//      while(this.getPointsMove())
//      mv.MoveTo(Defender);
        if (Math.abs(Defender.getPos().getX() - this.getPos().getX()) == 1 && Math.abs(Defender.getPos().getY() - this.getPos().getY()) == 1) {
            atakuje = 1;
            Defender.setPointsHealth(Defender.getPointsHealth() - this.getPointsAttack());
            Defender.getStan();

            if (Defender.getPointsHealth() <= 0) {
                Defender.setPointsHealth(0);
            }

        }
     int move = (int) this.getPointsMove();
    
       while(move > 0 && (Math.abs(Defender.getPos().getX() - this.getPos().getX()) != 1 || Math.abs(Defender.getPos().getY() - this.getPos().getY()) != 1))
        {
            if(this.getPos().getX() < Defender.getPos().getX())
            {
                if(this.getPos().getY() < Defender.getPos().getY()){
                    this.setPos(this.getPos().getX()+1,this.getPos().getY()+1);
                    //notifyObservers(0);
                }
                if(this.getPos().getY() > Defender.getPos().getY()){
                    this.setPos(this.getPos().getX()+1,this.getPos().getY()-1);
                    //notifyObservers(0);
                }
                else{
                    this.setPos(this.getPos().getX()+1,this.getPos().getY());
                    //notifyObservers(0);
                }
            }
            
            if(this.getPos().getX() > Defender.getPos().getX())
            {
                if(this.getPos().getY() < Defender.getPos().getY()){
                    this.setPos(this.getPos().getX()-1,this.getPos().getY()+1);
                    //notifyObservers(0);
                }
                if(this.getPos().getY() > Defender.getPos().getY()){
                    this.setPos(this.getPos().getX()-1,this.getPos().getY()-1);
                    //notifyObservers(0);
                }
                else{
                    this.setPos(this.getPos().getX()-1,this.getPos().getY());
                    //notifyObservers(0);
                }
            }
            
            if(this.getPos().getX() == Defender.getPos().getX())
            {
                if(this.getPos().getY() < Defender.getPos().getY()){
                    this.setPos(this.getPos().getX(),this.getPos().getY()+1);
                    //notifyObservers(0);
                }
                if(this.getPos().getY() > Defender.getPos().getY()){
                    this.setPos(this.getPos().getX(),this.getPos().getY()-1);
                    //notifyObservers(0);
                }
             
            }
            
           move--; 
        }
        if (Math.abs(Defender.getPos().getX() - this.getPos().getX()) <= 1 && Math.abs(Defender.getPos().getY() - this.getPos().getY()) <= 1) {
            atakuje = 1;
            Defender.setPointsHealth(Defender.getPointsHealth() - this.getPointsAttack());
            Defender.getStan();

            if (Defender.getPointsHealth() <= 0) {
                Defender.setPointsHealth(0);
            }

        }
        
  }
    /**
         * @return the lvlHealth
         */
    public float getLvlHealth() {
        return lvlHealth;
    }

    /**
     * @param lvlHealth the lvlHealth to set
     */
    public void setLvlHealth(float lvlHealth) {
        this.lvlHealth = lvlHealth;
    }

    /**
     * @param pointsHealth the pointsHealth to set
     */
    public void setPointsHealth(float pointsHealth) {
        this.pointsHealth = pointsHealth;
        //notifyObservers();
        
    }
    
    public String getHash()
    {            
        return this.classname+this.lvlAttack+this.lvlMove;
    
    }
    
    
}
