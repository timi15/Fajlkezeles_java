package teszteles;

import java.io.IOException;
import java.io.RandomAccessFile;

public class fajliras {
    public static void main(String[] args) {

        RandomAccessFile raf;
        String[] nevek = { "Bela","Geza","Eva","Adam","Orsi" };


        try
        {
            raf = new RandomAccessFile("nevek2.txt","rw");


            for( String s: nevek )
            {
                raf.writeBytes(s+"\n");
            }
            raf.close();
        }
        catch( IOException e ) {
            System.out.println("Hiba "+e.getMessage());
        }
    }
}
