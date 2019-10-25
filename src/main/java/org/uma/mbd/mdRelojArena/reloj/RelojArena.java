package org.uma.mbd.mdRelojArena.reloj;

public class RelojArena
{

    private final int tiempoTotal;
    private int tiempoRestante;

    public RelojArena (int tiempoTotal)
    {

        if (tiempoTotal <= 0) {
            throw new IllegalArgumentException ("No hay arena en el reloj");
        }

        this.tiempoTotal = tiempoTotal;
        tiempoRestante = 0;

    }

    public void gira ()
    {

        tiempoRestante = tiempoTotal - tiempoRestante;

    }

    public void pasaTiempo ()
    {

        tiempoRestante = 0;

    }

    public int getTiempoRestante ()
    {

        return tiempoRestante;

    }

    public void pasaTiempo (RelojArena reloj)
    {

        if (tiempoRestante < reloj.tiempoRestante) {
            pasaTiempo();
        }
        else{
            tiempoRestante -= reloj.tiempoRestante;
        }

        reloj.pasaTiempo();

    }

    @Override
    public String toString()
    {

        return "R(" + tiempoRestante + ", " + (tiempoTotal-tiempoRestante) + ")";

    }

}
