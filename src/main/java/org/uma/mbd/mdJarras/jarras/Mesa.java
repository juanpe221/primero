package org.uma.mbd.mdJarras.jarras;

public class Mesa
{

    private Jarra jarraA, jarraB;

    public Mesa (int ca, int cb)
    {

        jarraA = new Jarra (ca);
        jarraB = new Jarra (cb);

    }

    public Jarra getJarraA ()
    {

        return jarraA;

    }

    public Jarra getJarraB ()
    {

        return jarraB;

    }

    public void llenaA ()
    {

        jarraA.llena();

    }

    public void llenaB ()
    {

        jarraB.llena();

    }

    public void vaciaA ()
    {

        jarraA.vacia();

    }

    public void vaciaB ()
    {

        jarraB.vacia();

    }

    public void vuelcaAsobreB ()
    {

        jarraB.llenaDesde (jarraA);

    }

    public void vuelcaBsobreA ()
    {

        jarraA.llenaDesde (jarraB);

    }

    public int getContenidoA ()
    {

        return jarraA.getContenido();

    }

    public int getContenidoB ()
    {

        return jarraB.getContenido();

    }

    public int getCapacidadA ()
    {

        return jarraA.getCapacidad();

    }

    public int getCapacidadB ()
    {

        return jarraB.getCapacidad();

    }

    public int getContenido ()
    {

        return jarraA.getContenido() + jarraB.getContenido();

    }

    @Override
    public String toString()
    {

        return "M(" + jarraA + "," + jarraB + ")";      // no hace falta poner jarraA.toString() ni jarraB.toString()

    }

}










