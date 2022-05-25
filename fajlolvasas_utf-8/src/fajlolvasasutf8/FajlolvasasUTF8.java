
package fajlolvasasutf8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class FajlolvasasUTF8 {


     public static void main(String[] args) {
        final String  FORRAS_FILE ="diakok.txt"; // final el?l mert módosító
        
        
        List<String> fileSorok= null;
          try {
               fileSorok= Files.readAllLines(Paths.get(FORRAS_FILE), Charset.forName("utf-8")); 
          } catch (IOException e) {
               System.out.println("Hiba "+e.getMessage());
          }
          
          for (String string : fileSorok) {
               System.out.println(string);
               
          }
          
          final String CEL_FILE_UTF8 = "mentesutf8.txt";
          final String CEL_FILE_WIN1250 = "mentesw1250.txt"; // mert ez a default magyar
          try {
               Files.write(Paths.get(CEL_FILE_UTF8),fileSorok,Charset.forName("utf-8"));
               Files.write(Paths.get(CEL_FILE_WIN1250),fileSorok,Charset.defaultCharset());
               
               /*
               4. parameterrel lehet APPEND (hozzáf?zés) m?veletet is csinálni
               StandaardOpenOption.APPEND
               A default a  RESET, azaz el?ször töröl mindent és utána ír
               */
          } catch (Exception e) {
               System.out.println("Hiba "+e.getMessage());
          }
        
     }
     
}
