package org.uma.mbd.mdAlturas;

import org.uma.mbd.mdAlturas.alturas.EnContinente;
import org.uma.mbd.mdAlturas.alturas.Mundo;
import org.uma.mbd.mdAlturas.alturas.Pais;
import org.uma.mbd.mdInterfaces.caso2.MenoresQue;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;

public class Main
{

    public static void main(String[] args) throws FileNotFoundException
    {

        Mundo paises = new Mundo();
        paises.leePaises("recursos/mdAlturas/alturas.txt");

        for (Pais pais : paises.selecciona(new MenoresQue(1.70)))
            System.out.println(pais);

        Comparator<Pais> comCon = (p1, p2) -> p1.getContinente().compareTo(p2.getContinente());
        Comparator<Pais> comNom = (p1, p2) -> p1.getNombre().compareTo(p2.getNombre());
        Comparator<Pais> comAlt = (p1, p2) -> Double.compare(p1.getAltura(),p2.getAltura());

        Comparator<Pais> comcpn = comCon.thenComparing(comAlt).thenComparing(comNom);

        System.out.println("Ahora ordenado");
        Set<Pais> set1 = new TreeSet<>(comcpn);
        set1.addAll(paises.selecciona(new MenoresQue(1.70)));
        set1.forEach(System.out::println);

        System.out.println();
        for (Pais pais : paises.selecciona(new EnContinente(Europe))){
            System.out.println(pais);
        }

        System.out.println("Ahora ordenado");
        Comparator<Pais> compadn = comAlt.reversed().thenComparing((comNom));
        Set<Pais> set2 = new TreeSet<>(compadn);
        set2.addAll(paises.selecciona(new EnContinente(Europe)));
        set2.forEach(System.out::println);

        System.out.println();
        paises.selecciona(p -> p.getAltura() < 1.65).forEach(System.out::println);
        System.out.println("Ahora ordenado");
        Set<Pais> set3 = new TreeSet<>(paises.selecciona(p -> p.getAltura() < 1.65));
        set3.forEach(System.out::println);

        paises.numPaisesPorContinente().forEach((k,v) -> System.out.println(k + "->" + v));

        Map<String, Set<Pais>> map = paises.paisesPorContinente();

        for (String k : map.keySet()) {
            System.out.println (k);
            Set<Pais> set = map.get(k);

        }

    }

}
