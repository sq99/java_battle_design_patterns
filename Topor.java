/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Random;
/**
 *
 * @author fzeglen
 */
public class Topor extends Weapon {
    
   
    
    Random generator = new Random();
    
    float dlugosc = 1;
    float moc = 1;
    
    float zasieg = 1;
    
    int forwho = 2;
    
    int jakosc;

    
    
    public Topor()
    { 
        
        jakosc = generator.nextInt(5);
    }

    @Override
    public int getHitPoints() {
       
        //if(postac == 2)
        {
        
            return (super.getHitPoints() * (int)dlugosc + (int)moc)* jakosc;
        }
    }
    
//    @Override
//    public int getRangePoints()
//    {
//        return super.getRangePoints()* (1/2) * (int)zasieg;
//    }
}

