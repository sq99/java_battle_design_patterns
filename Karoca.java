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
public class Karoca extends Mover{
    
    int szybkosc = 10;
    
    @Override
    public int getMovePoints() {
        return super.getMovePoints()+szybkosc;
    }
    
}
