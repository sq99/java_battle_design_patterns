/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.List;
import java.util.Iterator;
import java.util.Observable;

/**
 *
 * @author serq9_000
 */
public class Czlowiek extends Warrior{
   
    String classname;
    
   public Czlowiek(List<Weapon> bronie2, List<Mover> transport2,int lvlA,int lvlM,int lvlH)
   {
       super(bronie2,transport2,lvlA,lvlM,lvlH);
       this.bronie = bronie2;
        this.transport = transport2;
        classname = "czlowiek";
        
       
        
    
   }
   
   @Override
   public String classname()
    {
           return classname;
    }
   @Override
    public float getPointsAttack() {
        float ret =0;
        Iterator iter1 = bronie.iterator();
//        for(int i = 0; i < bronie.size();i++)
//        {
//            
//              
//                Weapon wp = (Weapon)bronie.get(i);
//                if(wp.forwho == 1)
//                ret += wp.getHitPoints();
//              
//                else
//                ret +=(wp.getHitPoints()/2);
//              //else
//              //{
//               //zmniejsza statystyki jesli bron   
//              //}
//        }
        while(iter1.hasNext())
        {
            Object wp = (Object)iter1.next();
            if(((Weapon)wp).forwho == 1)
               ret+=((Weapon)wp).getHitPoints();
             
              else
               ret+=(((Weapon)wp).getHitPoints()/2);

            
        }
        if(ret>0){
        ret *= lvlAttack/MAX_ATT_POINTS;     
        }   
        
        return ret;
    }
    
    @Override
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

    
    @Override
    public float getPointsHealth()
    {
       return pointsHealth * getLvlHealth();        
    }
    
    
//    public float getAttackWithMove(){
//    
//        return getPointsAttack()/getPointsMove();
//    }
    
    
//    public void Attack ( Warrior Defender)
//    {    
//     
//     Defender.setPointsHealth(Defender.getPointsHealth() - this.getAttackWithMove());
//          
//     if(Defender.getPointsHealth() <= 0)
//     {
//            Defender.setPointsHealth(0);
//     }
//     
//    }

    /**
     * @return the lvlHealth
     */
    public float getLvlHealth() {
        return lvlHealth;
    }

    /**
     * @param lvlHealth the lvlHealth to set
     */
    @Override
    public void setLvlHealth(float lvlHealth) {
        this.lvlHealth = lvlHealth;
    }

    /**
     * @param pointsHealth the pointsHealth to set
     */
    @Override
    public void setPointsHealth(float pointsHealth) {
        this.pointsHealth = pointsHealth;
    }

    
}
