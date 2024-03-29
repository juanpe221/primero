package org.uma.mbd.mdGenetico.genetico;

import java.util.Objects;

public class Individuo
{

	private Cromosoma cromosoma;

	private double fitness;

	/**
	 * Crea un cromosoma aleatoriamente y lo evalúa para obtener su fitness.
	 * 
	 * @param longitud
	 *            Longitud del cromosoma.
	 * @param problema
	 *            Problema a resolver.
	 */

	public Individuo (int longitud, Problema problema)
	{

		if (longitud <= 0)
			throw new IllegalArgumentException ("Longitud no positiva");

		Cromosoma cr = new Cromosoma (longitud, true);
		this.cromosoma = cr;
		fitness = problema.evalua(this.cromosoma);

	}

	/**
	 * Hace una copia en profundidad del cromosoma recibido y lo eval�a para
	 * obtener su fitness.
	 * 
	 * @param cromosoma
	 *            Cromosoma que debe asociarse al individuo.
	 * @param problema
	 *            Problema a resolver.
	 */
	public Individuo (Cromosoma cromosoma, Problema problema)
	{
		this.cromosoma = cromosoma;

		fitness = problema.evalua(this.cromosoma);

	}

	/**
	 * Devuelve una copia (en profundidad) del cromosoma asociado al individuo.
	 *
	 * @return Cromosoma copia del asociado al individuo.
	 */

	public Cromosoma cromosoma ()
	{

		return cromosoma.copia();

	}

	/**
	 * Devuelve el valor de fitness del individuo.
	 * 
	 * @return Fitness del individuo.
	 */
	public double getFitness ()
	{

		return fitness;

	}



	public String toString()
	{

		return "Individuo(" + cromosoma + ", " + fitness + ")";

	}

}
