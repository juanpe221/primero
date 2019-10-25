package org.uma.mbd.mdGenetico.genetico;

public class CeroMax implements Problema
{

    /**
     * El fitness de un individuo es el número de ceros que tiene el cromosoma.
     * @see Problema#evalua(Cromosoma)
     */

    public double evalua (Cromosoma cromosoma)
    {

        int cont = 0;         // un contador

        for (int i = 0; i < cromosoma.getLongitud(); i++)
            if (cromosoma.datos[i] == 0)
                cont++;

        return cont;

    }

}
