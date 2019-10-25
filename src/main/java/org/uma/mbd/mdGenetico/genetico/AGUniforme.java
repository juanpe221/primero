package org.uma.mbd.mdGenetico.genetico;

public class AGUniforme extends AlgoritmoGenetico
{

	/**
	 * 
	 * @param tPoblacion
	 *            Tamaño de la población que va a utilizar.
	 * @param longCromosoma
	 *            Longitud de los cromosomas de los individuos de dicha
	 *            población.
	 * @param pasos
	 *            Número de pasos del algoritmo (generaciones).
	 * @param probMutacion
	 *            Probabilidad de mutar un gen en el cromosoma.
	 * @param problema
	 *            Problema que se debe resolver.
	 */

	public AGUniforme (int tPoblacion, int longCromosoma, int pasos, double probMutacion, Problema problema)
	{

		super(tPoblacion, longCromosoma, pasos, probMutacion, problema);

	}

	/**
	 * @see AlgoritmoGenetico#recombinar(Cromosoma, Cromosoma)
	 */

	@Override
	protected Cromosoma recombinar (Cromosoma cromosoma1, Cromosoma cromosoma2)
	{

		int longitud = cromosoma1.getLongitud();
		Cromosoma cr = new Cromosoma (longitud, false);
		int z;

		for (int i = 0; i < longitud; i++)
		{

			z = Cromosoma.gna.nextInt (2);

			if (z == 0)
				cr.setGen (i, cromosoma1.getGen(i));
			else
				cr.setGen (i, cromosoma2.getGen(i));

		}

		return cr;

	}

}
