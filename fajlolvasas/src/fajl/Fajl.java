package fajl;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fajl {

     public static void main(String[] args) {
          List<Osztaly> osztalyok = feltolt("diakok.txt");
          System.out.println("Az osztályok száma: " + osztalyok.size());

          Collections.sort(osztalyok); //rendezés

          for (Osztaly osztaly : osztalyok) {
               System.out.println(osztaly);

          }

     }

     private static List<Osztaly> feltolt(String fileNev) {
          List<Osztaly> result = new ArrayList<>();

          try {
               RandomAccessFile bemenet = new RandomAccessFile(fileNev, "r");
               while (bemenet.getFilePointer() < bemenet.length()) {
                    String sor = bemenet.readLine();
                    String[] darabok = sor.split(";");  //nem string, hanem regex
                    String osztaly = darabok[3];
                    Osztaly teszt = new Osztaly(osztaly);
                    if (!result.contains(teszt)) {
                         //Ez az osztály még nincs adminisztrálva fel kell venni
                         result.add(teszt);
                    }
                    //Itt már biztosan van ilyen jelű osztály 
                    Tanulo ujTanulo = new Tanulo(darabok[2], darabok[1], darabok[3]);
                    result.get(result.indexOf(teszt)).tanulok.add(ujTanulo);

                    // az osztályok közul egy osztályt a get metódussal veszek ki
               }

               bemenet.close();

          } catch (IOException ex) {
               System.out.println("Hiba van: " + ex.getMessage());
          }

          return result;
     }

}
