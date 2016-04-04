/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Filip
 */
public class Weapon {
    
    int forwho = 0;
    Weapon()
    {
    
    }
    
//    private int rangePoints;
//    
//    public int getRangePoints() {
//        return rangePoints;
//    }
//    
//    public void setRangePoints(int rangePoints) {
//        this.rangePoints = rangePoints;
//    }

   
    
    private int hitPoints;

    /**
     * 
     * @return the hitPoints
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * @param hitPoints the hitPoints to set
     */
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}
