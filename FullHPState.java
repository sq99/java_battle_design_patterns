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
public class FullHPState extends State{
    public void zwrocStan(Warrior w){
        if(w.getPointsHealth() == 100)
        System.out.print("Wojownik jest w pelnym zdrowiu\n");
    }
    
}
