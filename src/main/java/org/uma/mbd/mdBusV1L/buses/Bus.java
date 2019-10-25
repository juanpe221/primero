package org.uma.mbd.mdBusV1L.buses;

import java.util.Objects;

public class Bus
{

    private int codBus;
    private String matricula;
    private int codLinea;

    public Bus (int codBus, String matricula)
    {

        this.codBus = codBus;
        this.matricula = matricula;

    }

    public int getCodBus ()
    {

        return codBus;

    }

    public String getMatricula ()
    {

        return matricula;

    }

    public int getCodLinea ()
    {

        return codLinea;

    }

    public void setCodLinea (int codLinea)
    {

        this.codLinea = codLinea;

    }

    @Override
    public boolean equals (Object o)
    {

        boolean b = o instanceof Bus;

        Bus bus = b ? (Bus) o : null;

        return b && codBus == bus.codBus && matricula.equalsIgnoreCase (bus.matricula);

    }

    @Override
    public int hashCode ()
    {

        return Integer.hashCode (codBus) + matricula.toLowerCase().hashCode();

    }

    @Override
    public String toString()
    {

        return "Bus(" + codBus + ", " + matricula + ", " + codLinea + ")";

    }

}
