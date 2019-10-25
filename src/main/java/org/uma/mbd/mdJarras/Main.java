package org.uma.mbd.mdJarras;

import org.uma.mbd.mdJarras.jarras.Jarra;
import org.uma.mbd.mdJarras.jarras.Mesa;

public class Main
{

    public static void main(String[] args)
    {

        Mesa m = new Mesa (7,5);

        m.llenaA();

        m.vuelcaAsobreB();

        System.out.println (m);

    }

}
