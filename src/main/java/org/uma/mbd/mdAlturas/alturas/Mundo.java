package org.uma.mbd.mdAlturas.alturas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Mundo
{

    List<Pais> paises;

    public Mundo ()
    {

        paises = new ArrayList<> ();

    }

    public List<Pais> getPaises ()
    {

        return paises;

    }

    public void leePaises(String file) throws FileNotFoundException
    {

        try (Scanner sc = new Scanner(new File(file)))
        {

            leePaises (sc);

        }

    }

    public void leePaises(Scanner sc)
    {

        while (sc.hasNextLine())
        {

            String datoPais = sc.nextLine();

            try (Scanner scLinea = new Scanner (datoPais))
            {

                scLinea.useDelimiter(",");
                scLinea.useLocale(Locale.ENGLISH);
                String n = scLinea.next();
                String c = scLinea.next();
                double alt = scLinea.nextDouble();
                Pais pais = new Pais(n, c, alt);
                paises.add(pais);

            }

        }

    }

    public List<Pais> selecciona (Seleccion sel)
    {

        List<Pais> res = new ArrayList<>();

        for (Pais pais : paises){
            if (sel.test(pais)){
                res.add(pais);
            }
        }

        return res;

    }

    public Map<String,Integer> numPaisesPorContinente ()    // ejemplo de correspondencia
    {

        Map<String,Integer> map = new HashMap<>();

        for (Pais pais : paises){
            int veces = map.getOrDefault(pais.getContinente(), 0);
            map.put(pais.getContinente(), veces+1);
        }

        return map;

    }

    public Map<String, Set<Pais>> paisesPorContinente ()
    {

        Map<String, Set<Pais>> map = new HashMap<>();

        Comparator<Pais> compA = (p1, p2) -> Double.compare(p1.getAltura(), p2.getAltura());  // árbitro es altura
        // Comparator<Pais> compA = Comparator.comparingDouble (p -> p.getAltura()); (lo mismo de arriba)
        // si quito Double en la línea de arriba tb funciona
        Comparator<Pais> compN = (p1, p2) -> p1.getNombre().compareTo(p2.getNombre());  // árbitro es nombre
        // Comparator<Pais> compN = Comparator.comparing (p -> p.getNombre());   (es lo mismo que lo de arriba)
        // Comparator<Pais> compN = Comparator.comparing (Pais :: getNombre()); (es lo mismo tb)
        Comparator<Pais> comp = compA.thenComparing(compN);

        for (Pais pais : paises) {
            String continente = pais.getContinente();
            Set<Pais> set = map.computeIfAbsent(continente, c -> new TreeSet<> (comp));
            set.add(pais);
        }

        return map;



    }

}
