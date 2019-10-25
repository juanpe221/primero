package org.uma.mbd.mdAlturas.alturas;

public class MayoresQue implements Seleccion
{

    private double alturaMinima;

    public MayoresQue (double alturaMinima)
    {

        this.alturaMinima = alturaMinima;

    }

    @Override
    public boolean test (Pais pais)
    {

        return pais.getAltura() >= alturaMinima;

    }

}
