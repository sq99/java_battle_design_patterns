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
public class KonBuilder {
    
    public Szybkosc szybkosc;
    public Stamina stamina;
    
    public KonBuilder(Szybkosc sz, Stamina st){
        this.szybkosc = sz;
        this.stamina = st;
        
    }
    
    public Kon build(){
        return new Kon(this);
                }
    }
    

