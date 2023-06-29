import javax.swing.*;

import static java.lang.Integer.parseInt;

public class Primitivos {
    public static void main(String[] args) {
        Byte numeroByte = 25;
        System.out.println("numeroByte = " + numeroByte);
        System.out.println("Bytes asignados a los tipos de variables" + Long.BYTES);
        System.out.println("Bits asignados a los tipos de variables" + Long.SIZE);
        System.out.println("Valor maximo de un tipo de dato" + Long.MAX_VALUE);
        System.out.println("Valor minimo de un tipo de dato" + Long.MIN_VALUE);

        float masaAtomica = (float)1.0e-4 ;
        System.out.println("masaAtomica = " + masaAtomica);


        System.out.println("Nueva linea" + System.lineSeparator());
        System.out.println("otra linea \r");
        System.out.println("another line");

        System.out.println(numeroByte > masaAtomica);
        int numeroAEvaluar = parseInt( JOptionPane.showInputDialog(null ,"Numero"));

        String telefono = "Huawei";
        String televisor = "Huawei";
        System.out.println("obj1 == obj2? : " + (televisor == telefono)); //true

    }
}
