/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Random;
/**
 *
 * @author serq9_000
 */
public class Karabin extends Weapon {
    
    
    
    
    
    float moc = 12;
    float kaliber = 2;
    
    float zasieg = 1;
    
    int forwho = 1;
    
    
    
    public Karabin()
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
//    
    
}

