import java.util.ArrayList;
import java.util.Arrays;

public class Control{


    public static boolean problema1(String palabra){
      char[] estring = palabra.toCharArray();
      char[] arbalap = new char[estring.length];
      for (int i=0; i<estring.length; i++) {
        arbalap[i]=(palabra.charAt(estring.length-(i+1)));
      }
      if (Arrays.equals(arbalap, estring)) {
        return true;
      } else {
        return false;
      }
    }

    public static boolean problema2(int[] arreglo, int k){
      int n=arreglo.length;
      for (int i=0; i<((n*(n-1))/2); i++) {
        for (int ii=i+1; ii<n; ii++) {
          if ((arreglo[i]+arreglo[ii])==k) {
            return true;
          }
        }
      }
      return false;
    }

    public static void problema3(int[] arreglo){ //aún no se ha hecho.
        Arrays.sort(arreglo);
        return;
    }

    public static boolean problema4(int[] arreglo, int buscando){
      for (int i=0; i<arreglo.length; i++) {
        if (arreglo[i]==buscando) {
          return true;
          }
        }
        return false;
    }

    public static boolean problema5(int n){
      for (int i=2; i<=Math.sqrt(n); i++) {
        if ((n%i)==0) {
          return false;
        }
      }
      return true;
    }

    public static int[] problema6(int n){
      if (n<2) {
        System.out.println("Error, no hay números primos menores a 2");
      }
      int[] aux = new int[n];
      int ii = 0;
      for (int i=2; i<n; i++) {
        if (problema5(i)) {
          aux[ii]=i;
          ii++;
        }
      }
      int[] respuesta= new int[ii];
      for (int i=0; i<ii; i++) {
        respuesta[i]=aux[i];
      }
      return respuesta;
  }


    public static void main(String[] args) {
        String resultado = "";
        int[] desordenado = {9,8,7,6,5,4,3,2,1};
        int[] ordenado    = {1,2,3,4,5,6,7,8,9};
        int[] primos10 = {2,3,5,7};
        if(problema1("oso")==true && problema1("palabra")==false)resultado+="P1 bien\n";else resultado+="P1 mal\n";
        if(problema2(desordenado, 17)==true) resultado+="P2 bien\n";else resultado+="P2 mal\n";
        problema3(desordenado);
        if(Arrays.equals(desordenado,ordenado) == true)resultado+="P3 bien\n";else resultado+="P3 mal\n";
        if(problema4(desordenado,2)== true && problema4(desordenado,18)== false)resultado+="P4 bien\n";else resultado+="P4 mal\n";
        if(problema5(7)==true && problema5(18)==false)resultado+="P5 bien\n";else resultado+="P5 mal\n";
        if(Arrays.equals(problema6(10), primos10) == true)resultado+="P6 bien\n";else resultado+="P6 mal\n";
        System.out.println(resultado);
    }

}
