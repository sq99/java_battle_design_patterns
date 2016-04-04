/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filip
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Gra gra = Gra.getInstance();
        //Gra gra = new Gra();
        gra.rozgrywka();
         
         
        
    }
    
}

/*
 wzorce:
1. iterator (w listach broni i moverów)                                                                              zaliczone
2. singleton (instancja na klasie gra)                                                                               zaliczone
3. odwiedzajacy (dar od boga dla warriorów w klasie Gra - pokombinowac z intem (random zrobic na przyklad))          zaliczone
4. obserwator (wypisywanie czy warrior dostal hita albo cud)                                                         zaliczone
5. multiton (playerzy na haszmapie)                                                                                  zaliczone
6. fasada (bronie i movery jako listy)                                                                               zaliczone
7. builder (KonBuilder)   !dokonczyc         
8. metoda wytworcza(movery dla czlowieka i aliena - bez konia)
9. dekorator            (czolgznazwa ?)     raczej zly pomysl             X 
10.

6 oddanych - 7 builder dokonczyc i 8 metoda wytworcza dobrze zrobic to zaliczy 7 i 8
do tego 9 i 10 jakies dorobic

dokumentacje dorobic
*/