package teszteles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class fajlkezeles {
    public static void main(String[] args) {
        {
            RandomAccessFile raf;
            String sor;
            String[] nevek = new String[6];
            try {
                raf = new RandomAccessFile("nevek.txt", "r");
                int db = 0;
                sor = raf.readLine();


                while (sor != null) {
                    nevek[db] = sor;
                    db++;
                    sor = raf.readLine();

                }

                raf.close();

            }


            catch (FileNotFoundException ex){
                System.out.println("Hiba "+ ex.getMessage());
            }


            catch (IOException e) {
                System.out.println("HIBA" +e.getMessage());
            }

            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Hiba: "+e.getMessage());
            }

            for (String str : nevek) {

                System.out.println(str);
            }
        }
    }
}




