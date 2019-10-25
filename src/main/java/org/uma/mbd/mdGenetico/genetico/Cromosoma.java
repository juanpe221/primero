package org.uma.mbd.mdGenetico.genetico;
import java.util.Arrays;
import java.util.Random;

public class Cromosoma
{

	/**
	 * Datos de un cromosoma, cada posición del array representa un gen del
	 * cromosoma.
	 */
	protected int [] datos;

	/**
	 * Variable de clase de tipo Random.
	 */
	protected static Random gna = new Random();

	/**
	 * Valor por defecto 0 para los genes.
	 */
	protected static int GEN_POR_DEFECTO = 0;



	/**
	 * Constructor de la clase Cromosoma
	 * 
	 * @param longitud
	 *            Número de genes que tiene el cromosoma.
	 * @param aleatorio
	 *            Valor booleano que indica si debe asignar de forma aleatoria
	 *            un valor 0 o 1 a cada gen, o inicializarlos con el valor por
	 *            defecto. Si true se asigna aleatoriamente.
	 * @throws RuntimeException
	 *             si longitud no positiva.
	 */
	public Cromosoma (int longitud, boolean aleatorio)
	{

		if (longitud <= 0)
			throw new IllegalArgumentException ("Longitud no positiva");

		this.datos = new int[longitud];

		/* int aleaODefecto;

		   for (int i = 0; i < getLongitud(); i++)
			{

				aleaODefecto = aleatorio ? gna.nextInt(2) : GEN_POR_DEFECTO;
				datos[i] = aleaODefecto;

			}

		*/

		if (aleatorio)
		{

			for (int i = 0; i < longitud; i++)
			{

				datos[i] = gna.nextInt(2);

			}

		}
		else
		{

			for (int i = 0; i < longitud; i++)
			{

				datos[i] = GEN_POR_DEFECTO;

			}

		}

	}



	/**
	 * Consulta el gen en la posición indicada.
	 * 
	 * @param i
	 *            índice del gen que se consulta.
	 * @return Valor del gen en la posición indicada.
	 * @throws RuntimeException
	 *             si el índice está fuera del rango de valores válidos.
	 */
	public int getGen (int i)
	{

		if (i < 0 || i >= getLongitud())
			throw new IllegalArgumentException ("El indice del gen no es valido");

		return datos[i];

	}

	/**
	 * Modifica el i-ésimo gen del cromosoma.
	 * 
	 * @param i
	 *            índice del gen a modificar.
	 * @param val
	 *            Nuevo valor para el gen.
	 * @throws RuntimeException
	 *             si i está fuera del rango de valores válidos o si val no es
	 *             un valor válido.
	 */
	public void setGen (int i, int val)
	{

		if (i < 0 || i >= getLongitud() || (val != 0 && val != 1))
			throw new IllegalArgumentException ("El indice del gen o el valor no es valido");

		datos[i] = val;

	}

	/**
	 * Invierte los valores de los genes aleatoriamente.
	 * 
	 * @param probMutacion
	 *            Probabilidad de mutacion de cada gen.
	 * @throws RuntimeException
	 *             si la probabilidad indicada no es un valor válido.
	 */
	public void mutar (double probMutacion)
	{

		if (probMutacion < 0 || probMutacion > 1)
			throw new IllegalArgumentException ("Probabilidad de mutacion incorrecta");

		double alea;
		int datoMutado;

		for (int i = 0; i < getLongitud(); i++)
		{

			alea = gna.nextDouble();

			if (alea < probMutacion)
			{

				datoMutado = (datos[i] == 0) ? 1 : 0;  // muy útil en este caso el operador ternario
				datos[i] = datoMutado;

			}

		}

	}

	/**
	 * Longitud del cromosoma.
	 * 
	 * @return int Longitud del cromosoma.
	 */
	public int getLongitud()
	{

		return datos.length;

	}

	/**
	 * Realiza una copia en profundidad del cromosoma.
	 * 
	 * @return Un objeto Cromosoma copia del objeto que recibe el mensaje.
	 */
	public Cromosoma copia ()
	{

		// Creamos un cromosoma igual.
		// los arrays de datos deben ser iguales pero no el mismo!

		Cromosoma cr = new Cromosoma (getLongitud(), false);

		for (int i = 0; i < getLongitud(); i++)
		{

			cr.setGen(i, getGen(i));

		}

		return cr;

	}

	@Override
	public String toString()
	{

		StringBuilder s = new StringBuilder();

		for (int i = 0; i < datos.length - 1; i++)
		{

			s.append(datos[i]).append(", ");

		}

		return "Cromosoma(" + s + datos[datos.length - 1] + ")";

	}

}
