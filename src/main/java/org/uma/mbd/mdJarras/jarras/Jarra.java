package org.uma.mbd.mdJarras.jarras;

public class Jarra
{

    private int contenido;
    private final int capacidad;

    public Jarra (int capacidad)
    {

        if (capacidad <= 0)
        {

            throw new IllegalArgumentException ("capacidad negativa o 0");

        }

        contenido = 0;
        this.capacidad = capacidad;

    }

    public int getContenido()
    {

        return contenido;

    }

    public int getCapacidad()
    {

        return capacidad;

    }

    public void llena ()
    {

        contenido = capacidad;

    }

    public void vacia ()
    {

        contenido = 0;

    }

    public void llenaDesde (Jarra j)
    {

        int parteVacia = capacidad - contenido;

        if (j.contenido > parteVacia)
        {

            // hay más de lo que cabe

            contenido = capacidad;
            j.contenido -= parteVacia;

        }
        else
        {

            // todo lo que hay cabe

            contenido += j.contenido;
            j.contenido = 0;

        }

    }

    @Override
    public String toString()
    {

        return "Jarra(" + contenido + "," + capacidad + ")";

    }

}










