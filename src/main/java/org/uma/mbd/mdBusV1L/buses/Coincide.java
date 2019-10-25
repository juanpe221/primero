package org.uma.mbd.mdBusV1L.buses;

public class Coincide implements Criterio
{

    private Bus bus;

    public Coincide (Bus bus)
    {

        this.bus = bus;

    }

    @Override
    public boolean esSeleccionable (Bus bus)
    {

        return this.bus.equals(bus);

    }

    public String toString ()
    {

        return "Bus " + bus;

    }

}
