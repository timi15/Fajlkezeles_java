package teszteles;

public class kivetelkezeles {

    public static void main(String[] args) {


        try {

            int osztas = 9 / 0;
            System.out.println(osztas);


        } catch (ArithmeticException ex) {

            System.out.println("hiba: " + ex.getMessage());

        }finally { //bármi történik ez lefog futni

            System.out.println("Ez tuti mindig lefut (hiba esetén): ");


        }

    }  //main vége
}
