/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.List;


public class AlienWarriorAbstractFactory implements WarriorAbstractFactory {
    
    @Override
    public Warrior createWarrior(List<Weapon> bronie, List<Mover> transport, int lvlA, int lvlM, int lvlH) {
        return new Alien(bronie,transport,lvlA,lvlM,lvlH);
    }
}
