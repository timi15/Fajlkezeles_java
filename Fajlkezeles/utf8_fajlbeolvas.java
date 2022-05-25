package teszteles;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class utf8_fajlbeolvas {
    public static void main(String[] args) {
        RandomAccessFile raf;
        String sor;
        String sor_utf8;
        List<String> animals = new ArrayList<>();

        try {
            raf = new RandomAccessFile("animals.txt", "r");

            sor = raf.readLine();
            sor_utf8 = new String(sor.getBytes("ISO-8859-1"), "UTF-8");

            while (sor != null) {
                sor_utf8 = new String(sor.getBytes("ISO-8859-1"), "UTF-8");
                animals.add(sor_utf8);
                sor = raf.readLine();
            }

            raf.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Tömb túlindexelés történt!");
        } catch (IOException e) {
            System.err.println("HIBA");
        }

        for (String animal : animals) {
            System.out.println(animal);
        }

    }
}
