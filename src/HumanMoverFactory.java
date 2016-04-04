/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;


public class HumanMoverFactory implements MoverFactory {

    @Override
    public Mover getMover(TypMovera moverType) {
        Mover mv = new Mover();
        switch(moverType){
            case KAROCA:
                mv = new Karoca();
                return mv;
            case RYDWAN:
                mv = new Rydwan();
        }
        return mv;
    }
        
    
    
}
