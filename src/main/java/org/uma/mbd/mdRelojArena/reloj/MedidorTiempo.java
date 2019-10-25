package org.uma.mbd.mdRelojArena.reloj;

public class MedidorTiempo
{

    private RelojArena izdo;
    private RelojArena drcho;
    private int tiempoTotal;

    public MedidorTiempo (int t1, int t2)
    {

        izdo = new RelojArena (t1);
        drcho = new RelojArena (t2);
        tiempoTotal = 0;

    }

    public void giraIzquierdo ()
    {

        izdo.gira();
        pasaTiempo();

    }

    public void giraDerecho ()
    {

        drcho.gira();
        pasaTiempo();

    }

    public void giraAmbos ()
    {

        izdo.gira();
        drcho.gira();
        pasaTiempo();

    }

    public void pasaTiempo ()
    {

        if (izdo.getTiempoRestante() == 0) {
            tiempoTotal += drcho.getTiempoRestante();
            drcho.pasaTiempo();
        }
        else if (drcho.getTiempoRestante() == 0) {
            tiempoTotal += izdo.getTiempoRestante();
            izdo.pasaTiempo();
        }
        else {

            if (izdo.getTiempoRestante() < drcho.getTiempoRestante()) {
                tiempoTotal += izdo.getTiempoRestante();
                drcho.pasaTiempo(izdo);
            }
            else {
                tiempoTotal += drcho.getTiempoRestante();
                izdo.pasaTiempo(drcho);
            }

        }

    }

    public int getTiempoTotal ()
    {

        return tiempoTotal;

    }

    @Override
    public String toString()
    {

        return "M(" + izdo + ", " + drcho + ", tiempo total = " + tiempoTotal + ")";

    }

}
