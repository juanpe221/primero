package org.uma.mbd.mdEstadistica.estadistica;

public class Estadistica
{

    private int numElementos;
    private double sumaX;
    private double sumaX2;

    public void agrega (double d)
    {

        numElementos++;
        sumaX += d;
        sumaX2 += Math.pow (d, 2);

    }

    public void agrega (double d, int n)
    {

        numElementos += n;
        sumaX += n*d;
        sumaX2 += n * Math.pow (d, 2);

    }

    public double media ()
    {

        return sumaX / numElementos;

    }

    public double varianza ()
    {

        return sumaX2 / numElementos - Math.pow (media(), 2);

    }

    public double desviacionTipica ()
    {

        return Math.sqrt (varianza());

    }

}
