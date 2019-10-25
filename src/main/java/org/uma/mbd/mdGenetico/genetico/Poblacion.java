package org.uma.mbd.mdGenetico.genetico;

public class Poblacion
{

	private Individuo [] individuos;

	/**
	 * 
	 * @param tamano
	 *            Número de individuos de la población.
	 * @param longitud
	 *            tamano de los cromosomas de los individuos de la población.
	 * @param problema
	 *            Problema a resolver.
	 * @throws RuntimeException
	 *             si el tamano de la población o la longitud de los cromosomas
	 *             indicados no son válidos.
	 */

	public Poblacion (int tamano, int longitud, Problema problema)
	{

		if (tamano <= 0 || longitud <= 0)
			throw new IllegalArgumentException ("Tamano de la poblacion o longitud de cromosomas no valido");

		individuos = new Individuo [tamano];
		
		for (int i = 0; i < tamano; i++)
		{
			
			individuos[i] = new Individuo (longitud, problema);
			
		}

	}

	/**
	 * Devuelve el número de individuos.
	 * 
	 * @return Número de individuos en la población.
	 */

	public int getNumIndividuos ()
	{

		return individuos.length;

	}

	/**
	 * Devuelve el individuo con fitness mayor de la población.
	 * 
	 * @return Individuo con mejor fitness.
	 */

	public Individuo mejorIndividuo ()
	{

		double fit = 0;
		int j = 0;      // voy guardando la posición cada vez que encuentro un fitness superior

		for (int i = 0; i < getNumIndividuos(); i++)
		{

			if (individuos[i].getFitness() > fit)
			{

				fit = individuos[i].getFitness();
				j = i;

			}

		}

		return individuos[j];

	}

	/**
	 * Devuelve el individuo con fitness menor de la población.
	 *
	 * @return Individuo con peor fitness.
	 */

	public Individuo peorIndividuo ()
	{

		double fit = mejorIndividuo().getFitness();
		int j = 0;      // voy guardando la posición cada vez que encuentro un fitness inferior

		for (int i = 0; i < getNumIndividuos(); i++)
		{

			if (individuos[i].getFitness() < fit)
			{

				fit = individuos[i].getFitness();
				j = i;

			}

		}

		return individuos[j];

	}

	/**
	 * Devuelve el i-ésimo individuo de la población.
	 * 
	 * @param i
	 *            Posición del individuo a devolver.
	 * @return Individuo en la posición i.
	 * @throws RuntimeException
	 *             si el índice está fuera del rango de valores válidos.
	 */

	public Individuo individuo (int i)
	{

		if (i < 0 || i >= getNumIndividuos())
			throw new IllegalArgumentException ("El indice no es valido");

		return individuos[i];

	}

	/**
	 * Si el individuo que se pasa como argumento tienen mejor fitness que el
	 * peor de los individuos de la población, entonces el peor es sustituido
	 * por el que se pasa.
	 * 
	 * @param ind
	 *            Individuo con el que se sustituye el peor de los individuos si
	 *            este es mejor.
	 */

	public void reemplaza (Individuo ind)
	{

		if (ind.getFitness() > peorIndividuo().getFitness())
		{

			for (int i = 0; i < getNumIndividuos(); i++)
			{

				if (individuos[i].getFitness() == peorIndividuo().getFitness())
				{

					individuos[i] = ind;
					break;

				}

			}

		}

	}

}
