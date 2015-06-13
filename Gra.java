/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author serq9_000
 */
public class Gra {
    
    private static volatile Gra instance = null;
    private Obserwator obs;
    
    private void AddToMultiton(Map<Object, Player>gracze,Player pl,Object key)
    {
     if(!gracze.containsKey(key))
     {
         gracze.put(key, pl);
     }
    }
    
    Map<Object, Player> gracze = new HashMap<Object, Player>();
    
 
    
    private boolean tryb;
    private int trybtmp;
    
    public void menu(){
       
        Scanner scanner = new Scanner(System.in);
  
        System.out.println("********************************");
        System.out.println("*                              *");
        System.out.println("*   Gra - Ludzie vs. Kosmici   *");
        System.out.println("*                              *");
        System.out.println("********************************");
        System.out.println("*                              *");
        System.out.println("* Tryby gry:                   *");  
        System.out.println("*                              *");
        System.out.println("* 1. CPU vs CPU                *");
        System.out.println("* 2. Player vs CPU             *");
        System.out.println("*                              *");
        System.out.println("********************************\n");
        System.out.println("Wybierz tryb gry: ");
        
        try{
            setTrybtmp(scanner.nextInt());
        }
        catch(Exception e){
            System.out.println("\nWprowadz liczbe calkowita (1 lub 2)."); 
            try {
                Thread.sleep(3000);
            } catch (InterruptedException d) {
                e.printStackTrace();
            }
            menu();
        }
        if(getTrybtmp() == 1)                            //cpu vs cpu
            setTryb(false);
        else if(getTrybtmp() == 2)                      //player vs cpu
            setTryb(true);
        //System.out.println(getTryb());
     }
        
    
    
    
    
    public static Gra getInstance() {
        if (instance == null) {
            synchronized (Gra .class) {
                if (instance == null) {
                    instance = new Gra();
                }
            }
        }
        return instance;
    }
   
    Gra(){
        Random generator = new Random(System.currentTimeMillis()); 
        
//        Odwiedzajacy od1 = new Odwiedzajacy();
//        Odwiedzajacy od2 = new Odwiedzajacy();
        
        List<Weapon> bronie = new ArrayList<Weapon>();
        List<Weapon> bronie2 = new ArrayList<Weapon>();
       
        obs = new Obserwator();
        
        
        
        Player p1 = new Player(0);
        Player p2 = new Player(1);
        
        p1.addObserver(obs);
        p2.addObserver(obs);
       
        
        this.AddToMultiton(gracze, p1,p1.getId());
        this.AddToMultiton(gracze, p2,p2.getId());
        
//        WeaponInterface wi;
//        Weapon bron1,bron2,bron3,bron4;
//        
//        wi = new MieczInterface();
//	bron1 = wi.wytworzWeapon(WeaponType.MIECZ);
//	System.out.println(bron1);
//        wi = new KarabinInterface();
//	bron2 = wi.wytworzWeapon(WeaponType.KARABIN);
//	System.out.println(bron2);
//
//	wi = new ToporInterface();
//	bron3 = wi.wytworzWeapon(WeaponType.TOPOR);
//	System.out.println(bron3);
//        wi = new PistoletInterface();
//	bron4 = wi.wytworzWeapon(WeaponType.PISTOLET);
        
        
        Miecz bron1 = new Miecz();
        Karabin bron2 = new Karabin();

        Topor bron3 = new Topor();
        Pistolet bron4 = new Pistolet();

        bron1.setHitPoints(40);        
        bron2.setHitPoints(160);
        bron3.setHitPoints(20);
        bronie.add(bron1);
        bronie.add(bron2);
        bronie2.add(bron3);
        bronie2.add(bron4);

        List<Mover> transport = new ArrayList<Mover>();
        List<Mover> transport2 = new ArrayList<Mover>();
        
        MoverFactory hw = new HumanMoverFactory();
        MoverFactory aw = new AlienMoverFactory();
        
        Mover karoca = hw.getMover(TypMovera.KAROCA);
        Mover rydwan = hw.getMover(TypMovera.RYDWAN);
        
        Mover ufo = aw.getMover(TypMovera.UFO);
        Mover statek = aw.getMover(TypMovera.STATEK);

        Mover mover1 = new Mover();
        mover1.setMovePoints(60);
        Mover mover2 = new Mover();
        mover2.setMovePoints(30);
        
        Szybkosc sz = new Szybkosc(8);
        Stamina st = new Stamina(5);
        KonBuilder kb = new KonBuilder(sz, st);
        Kon kon = kb.build();
        //Rydwan rydwan = new Rydwan();

        //Ufo ufo = new Ufo();
        //StatekKosm statek = new StatekKosm();

        transport.add(kon);
        transport.add(rydwan);
        transport.add(karoca);

        transport2.add(ufo);
        transport2.add(statek);
        
        warriorFactory f1 = new HumanWarriorFactory();
        warriorFactory f2 = new AlienWarriorFactory();
        

            
//        Czlowiek c1 = new Czlowiek(bronie, transport, 100, 100, 1);
//        Czlowiek c2 = new Czlowiek(bronie, transport, 100, 100, 1);
//        Czlowiek c3 = new Czlowiek(bronie, transport, 100, 100, 1);
//        Czlowiek c4 = new Czlowiek(bronie, transport, 100, 100, 1);
//        
//        
//        
//        Czlowiek c5 = new Czlowiek(bronie, transport, 100, 100, 1);
       
//        c1.setPos(1,2);
//        c2.setPos(1,4);
//        c3.setPos(1,6);
//        c4.setPos(1,8);
//        c5.setPos(1,10);

//        Alien a1 = new Alien(bronie2, transport2, 100, 100, 1);
//        Alien a2 = new Alien(bronie2, transport2, 100, 100, 1);
//        Alien a3 = new Alien(bronie2, transport2, 100, 100, 1);
//        Alien a4 = new Alien(bronie2, transport2, 100, 100, 1);
//        Alien a5 = new Alien(bronie2, transport2, 100, 100, 1);
        
//        a1.setPos(10, 2);
//        a2.setPos(10, 4);
//        a3.setPos(10, 6);
//        a4.setPos(10, 8);
//        a5.setPos(10, 10);
//
//     
//        p1.addWarrior(c1);
//        p1.addWarrior(c2);
//        p1.addWarrior(c3);
//        p1.addWarrior(c4);
//        p1.addWarrior(c5);
//
//       
//        p2.addWarrior(a1);
//        p2.addWarrior(a2);
//        p2.addWarrior(a3);
//        p2.addWarrior(a4);
//        p2.addWarrior(a5);
        //int ilosc_rund = 0;
   }
   
           
           
    public void rozgrywka()
    {
       int ilosc_rund=0;
        menu();
        System.out.println("Rozpoczecie gry");
        Random generator2 = new Random(System.currentTimeMillis());
        Random generator3 = new Random(System.currentTimeMillis());
        Random generator4 = new Random(System.currentTimeMillis());
        Scanner scanner2 = new Scanner(System.in);
        Odwiedzajacy od1 = new Odwiedzajacy();
        Odwiedzajacy od2 = new Odwiedzajacy();
        int attacker1 = -1;
        int attacker2 = -1;
        while(gracze.get(0).getCount() != 0 && gracze.get(1).getCount() != 0)
        {
//            if(p1.getCount()==0)
//            {
//           
//                System.out.println("Armia kosmitow pokonala armie ludzi w "+ilosc_rund +" rundach");
//                System.out.println("Koniec gry");
//                break;
//            }
//        
//            if(p2.getCount()==0)
//            {
//                System.out.println("Armia ludzi pokonala armie kosmitow w "+ilosc_rund +" rundach");
//                System.out.println("Koniec gry");
//                break;
//            }
            
            System.out.println("Atakuja ludzie");
            if(getTryb() == false){ //cpu vs cpu
                int cel = generator2.nextInt(gracze.get(1).getCount());
                attacker1++;
                if(attacker1 >= gracze.get(0).getCount())
                    attacker1 = 0;
                gracze.get(0).Attack(gracze.get(1),cel,attacker1);

            }
            else if(getTryb() == true){ //player vs cpu
                int nasz = 0;
                 System.out.println("Wprowadz numer postaci ze swojej druzyny ktora bedziesz atakowac (0-4): ");
                try{
                      
                        nasz = scanner2.nextInt();
                        while(nasz < 0 || nasz >= gracze.get(0).getCount())
                        {
                            System.out.print("Podaj poprawna wartosc");
                            nasz = scanner2.nextInt();
                        }
                    }
                catch(Exception e){
                    System.out.println("\nWprowadz liczbe calkowita."); 
                     }
                int cel = 0;
                System.out.println("Wprowadz numer postaci z przeciwnej druzyny ktora chcesz zaatakowac (0-4): ");
                try{
                      
                        cel = scanner2.nextInt();
                        while(cel < 0 || cel >= gracze.get(1).getCount())
                        {
                            System.out.print("Podaj poprawna wartosc");
                            cel = scanner2.nextInt();
                        }
                    }
                catch(Exception e){
                    System.out.println("\nWprowadz liczbe calkowita."); 
                     }
                gracze.get(0).Attack(gracze.get(1),cel,nasz);
            
        }
            for(int i=0;i<gracze.get(0).getCount();i++)
                System.out.print("team 1 czlowiek " +i +" HP = " +gracze.get(0).getWarrior(i).getPointsHealth() + "\n") ;  
//            for(int i=0;i<p1.getCount();i++)
//            {
//                System.out.println("Pozycja czlowieka nr " +i +"  " +"X:"+p1.team.get(i).getPos().getX()+ "  " +"Y:"+p1.team.get(i).getPos().getY());
//                System.out.println("Zycie czlowieka nr " +i +": " +p1.team.get(i).getPointsHealth());
//            }
//            for(int i=0;i<p2.getCount();i++)
//            {
//                System.out.println("Pozycja kosmity nr " +i +"  " +"X:"+p2.team.get(i).getPos().getX()+ "  " +"Y:"+p2.team.get(i).getPos().getY());
//                System.out.println("Zycie kosmity nr " +i +": "+p2.team.get(i).getPointsHealth());
//            }
//            p1.printStats();
//            p2.printStats();
            System.out.println("Atakuja kosmici");
            int cel2 = generator2.nextInt(gracze.get(0).getCount());
            attacker2++;
            if(attacker2 >= gracze.get(1).getCount())
                attacker2 = 0;
            gracze.get(1).Attack(gracze.get(0),cel2,attacker2);
            

            
            for(int i=0;i<gracze.get(1).getCount();i++)
                System.out.print("team 2 alien " +i +" HP = " +gracze.get(1).getWarrior(i).getPointsHealth() + "\n") ; 
            
//            p2.Attack(p1);
//            p1.printStats();
//            p2.printStats();
//            for(int i=0;i<p1.getCount();i++)
//            {
//                System.out.println("Pozycja czlowieka nr " +i +"  " +"X:"+p1.team.get(i).getPos().getX()+ "  " +"Y:"+p1.team.get(i).getPos().getY());
//                System.out.println("Zycie czlowieka nr " +i +": " +p1.team.get(i).getPointsHealth());
//            }
//            for(int i=0;i<p2.getCount();i++)
//            {
//                System.out.println("Pozycja kosmity nr " +i +"  " +"X:"+p2.team.get(i).getPos().getX()+ "  " +"Y:"+p2.team.get(i).getPos().getY());
//                System.out.println("Zycie kosmity nr " +i +": "+p2.team.get(i).getPointsHealth());
//            }
            ilosc_rund++;
            
//            for(int i=0;i<p1.getCount();i++)
//            {
//                if(p1.team.get(i).getPointsHealth()==0)
//                    p1.removeWarrior(p1.team.get(i));
//            }
//            for(int i=0;i<p2.getCount();i++)
//            {
//                if(p2.team.get(i).getPointsHealth()==0)
//                    p2.removeWarrior(p2.team.get(i));
//            }
//            int x = 1;
//            od1.OdwiedzOsobe(gracze,gracze.get(0).getId(),gracze.get(0).team.get(x),20);
//            od2.OdwiedzOsobe(gracze,gracze.get(1).getId(),gracze.get(1).team.get(x),20);
            int szansa1 = generator3.nextInt(100);
            if(szansa1 < 10)
                od1.OdwiedzOsobe(gracze,gracze.get(0).getId(),1);
            int szansa2 = generator4.nextInt(100);
            if(szansa2 < 5)
                od2.OdwiedzOsobe(gracze,gracze.get(1).getId(),1);
//            
//            x++;
        
        if(gracze.get(0).getCount()==0)
        {
           
            System.out.println("Armia kosmitow pokonala armie ludzi w "+ilosc_rund +" rundach");
            System.out.println("Koniec gry");
            break;
        }
        
        if(gracze.get(1).getCount()==0)
        {
            System.out.println("Armia ludzi pokonala armie kosmitow w "+ilosc_rund +" rundach");
            System.out.println("Koniec gry");
            break;
        }
       }
//        System.out.println("Przed Atakiem " + SecondCreature.getPointsHealth());
//        
//    for(int i=0; i< ileAtakow ;i++){
//             FirstCreature.Attack(SecondCreature);}
//                
//       
//        System.out.println("Po " +  ileAtakow + " Ataku " + SecondCreature.getPointsHealth());
//        
//        String out = "Overall : " + FirstCreature.getAttackWithMove() + ",  Att : " + FirstCreature.getPointsAttack() + ", Move : " + FirstCreature.getPointsMove();
//        
//        System.out.println(out);
//        System.out.println("\n");
//         
//         
//        
//    System.out.println("Przed Atakiem " + FirstCreature.getPointsHealth());
//    
//    for(int i=0; i< ileAtakow ;i++){
//             SecondCreature.Attack(FirstCreature);}
//                
//       
//        System.out.println("Po " +  ileAtakow + " Ataku " + FirstCreature.getPointsHealth());
//        
//        String out2 = "Overall : " + SecondCreature.getAttackWithMove() + ",  Att : " + SecondCreature.getPointsAttack() + ", Move : " + SecondCreature.getPointsMove();
//        
//        System.out.println(out2);
        
    }

    /**
     * @return the tryb
     */
    public boolean getTryb() {
        return tryb;
    }

    /**
     * @param tryb the tryb to set
     */
    public void setTryb(boolean tryb) {
        this.tryb = tryb;
    }
    public int getTrybtmp() {
        return trybtmp;
    }

    /**
     * @param trybT he tryb to set
     */
    public void setTrybtmp(int trybT) {
        this.trybtmp = trybT;
    }
}
