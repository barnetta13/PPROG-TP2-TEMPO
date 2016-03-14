/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel Martins
 */
public class TesteTempo {
    
    public static void main(String[] args) {
        Tempo t1 = new Tempo (5,30,12);
        System.out.println(t1);
        System.out.println(t1.toStringAmOrPm());
        t1.acrescentaSegundo();
        System.out.println(t1.toStringAmOrPm());
        Tempo t2 = new Tempo (18,5,20);
        t2.toStringAmOrPm();
        System.out.println(t1.comparaTempo(t2));
        System.out.println(t1.comparaTempo(23, 7, 4));
        System.out.println(t1.diferencaSegundos(t2));
        //System.out.println(t1.diferencaTempo(t2));
        
        
    }
    
}
