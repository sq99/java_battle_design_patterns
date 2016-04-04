/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.List;

/**
 *
 * @author serq9_000
 */
public class UberCzlowiek extends Czlowiek{
    
    UberCzlowiek(List<Weapon> bronie2, List<Mover> transport2,int lvlA,int lvlM,int lvlH)
    {
        super(bronie2,transport2,lvlA,lvlM,lvlH);
        this.bronie = bronie2;
        this.transport = transport2;
       
    }
    
    @Override
    public float getPointsAttack() {
        float ret =0;
        for(int i = 0; i < bronie.size();i++)
        {
              Weapon wp = (Weapon)bronie.get(i);
              ret += wp.getHitPoints();
        }        
        if(ret>0){
        ret *= lvlAttack/MAX_ATT_POINTS;     
        }   
        
        return ret/2;
    }
    
    @Override
    public float getPointsHealth()
    {
       return pointsHealth * getLvlHealth() * 2;        
    }
}
