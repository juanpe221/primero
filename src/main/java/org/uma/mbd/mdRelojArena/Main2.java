package org.uma.mbd.mdRelojArena;

import org.uma.mbd.mdRelojArena.reloj.MedidorTiempo;

public class Main2
{

    public static void main(String[] args)
    {

        MedidorTiempo m = new MedidorTiempo (5, 7);

        System.out.println (m);
        m.giraIzquierdo();
        System.out.println (m);
        m.giraDerecho();
        System.out.println (m);
        m.giraAmbos();
        System.out.println (m);
        m.pasaTiempo();
        System.out.println (m);
        m.pasaTiempo();
        System.out.println (m);

        System.out.println ("El tiempo total es " + m.getTiempoTotal() + " segundos");

    }

}
