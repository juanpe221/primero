package org.uma.mbd.mdGenetico.genetico;

public class OneMax implements Problema
{

	/**
	 * El fitness de un individuo es el número de unos que tiene el cromosoma.
	 * @see Problema#evalua(Cromosoma)
	 */

	public double evalua (Cromosoma cromosoma)
	{

		int cont = 0;         // un contador

		for (int i = 0; i < cromosoma.getLongitud(); i++)
			if (cromosoma.datos[i] == 1)
				cont++;

		return cont;

	}

}
