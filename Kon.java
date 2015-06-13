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
public class Kon extends Mover{
    
    int szybkosc; //= 8;
    int stamina; //= 10;
    
    public Kon(KonBuilder kb)
    {
        this.szybkosc = kb.szybkosc.szybkosc;
        this.stamina = kb.stamina.stamina;
    }
    
    @Override
    public int getMovePoints() {
        return super.getMovePoints()+szybkosc;
    }
    
}
