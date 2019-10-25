package org.uma.mbd.mdAlturas.alturas;

public class Pais implements Comparable<Pais>
{

    String nombre;
    String continente;
    double altura;

    public Pais (String nombre, String continente, double altura)
    {

        this.nombre = nombre;
        this.continente = continente;
        this.altura = altura;

    }

    public String getNombre()
    {

        return nombre;

    }

    public String getContinente()
    {

        return continente;

    }

    public double getAltura()
    {

        return altura;

    }

    @Override
    public boolean equals (Object o)
    {

        boolean b = o instanceof Pais;

        Pais pais = b ? (Pais) o : null;

        return b && nombre.equals(pais.nombre);

    }

    @Override
    public int hashCode()
    {

        return nombre.hashCode();

    }

    @Override
    public String toString()
    {

        return "Pais(" + nombre + ", " + continente + ", " + altura + ")";

    }

    public int compareTo (Pais pais)
    {

        int res = continente.compareTo((pais.continente));

        if (res == 0){
            res = nombre.compareTo(pais.getNombre());
        }

        return res;

    }

}
