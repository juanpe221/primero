package org.uma.mbd.mdInterfaces.caso4;

import java.util.Objects;

public class Persona implements Comparable<Persona>
{

	private String nombre;
	private int edad;
	
	public Persona(String n, int e) {
		nombre = n;
		edad = e;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	@Override
	public String toString() {
		return nombre + ":" + edad;
	}

	@Override
	public boolean equals(Object o) {
		boolean b = o instanceof Persona;

		Persona p =  b ? (Persona) o : null;

		return b && edad == p.edad &&
				nombre.equals(p.nombre);
	}

	@Override
	public int hashCode()
	{
		return Integer.hashCode(edad) + nombre.hashCode();
	}

	@Override
	public int compareTo(Persona per)
	{

		int res = Integer.compare(edad, per.edad);

		if (res == 0)
		{

			res = nombre.compareTo(per.nombre);

		}

		return res;

	}
}









