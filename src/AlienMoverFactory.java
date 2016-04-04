/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;


public class AlienMoverFactory implements MoverFactory {

    @Override
    public Mover getMover(TypMovera moverType) {
        Mover mv = new Mover();
        switch(moverType){
            case UFO:
                mv = new Ufo();
                return mv;
            case STATEK:
                mv = new StatekKosm();
        }
        return mv;
    }
}
