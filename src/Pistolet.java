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
public class Pistolet extends Weapon {
    
    
    
    float moc = 1;
    float kaliber = 1;
    
    float zasieg = 4;
    
    int forwho = 2;
    
    /**
     *
     */
    public Pistolet()
    {
        
    }
    
    @Override
    public int getHitPoints()
    {
        return super.getHitPoints()* (int)moc + (int)kaliber;
    }
    
//    @Override
//    public int getRangePoints()
//    {
//        return super.getRangePoints()* (1/2) * (int)zasieg;
//    }
    
    
}
