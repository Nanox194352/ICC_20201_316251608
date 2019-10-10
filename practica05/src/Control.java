/**
* Código de la práctica 5
* @author Juan Carlos Zenteno Pompa
*/
import java.util.ArrayList;
import java.util.Arrays;

public class Control{


    public static boolean problema1(String palabra){
      char[] estring = palabra.toCharArray();
      char[] arbalap = new char[estring.length];
      for (int i=0; i<estring.length; i++) {   //crea un aray de la palabra que se le pase pero invertida.
        arbalap[i]=(palabra.charAt(estring.length-(i+1)));
      }
      if (Arrays.equals(arbalap, estring)) { //compara el aray con su array inverso
        return true;
      } else {
        return false;
      }
    }
/**
* @param problema1 Recibe un String y regresa si es un palíndromo o no.
* @return true o false
*/

    public static boolean problema2(int[] arreglo, int k){
      int n=arreglo.length;
      for (int i=0; i<((n*(n-1))/2); i++) { //Se usa este número porque representa el número de sumas no repetidas y que no incuyen un mismo elemento consigo mismo.
        for (int ii=i+1; ii<n; ii++) {
          if ((arreglo[i]+arreglo[ii])==k) {
            return true;
          }
        }
      }
      return false;
    }
/**
* @param problema2 recibe un array y un entero. Verifica si en el array existen dos números que sumados den el entero.
* @return true o false
*/
    public static void problema3(int[] arreglo){
      for (int i=0; i<arreglo.length; i++) { //Este for es el que realiza el ordenamiento.
      int minimo=arreglo[i];
      int aux=i; //esta variable va a guardar la posición en el array de el elemento minimo.
        for (int ii=i; ii<arreglo.length; ii++) {  //determinar el mínimo elemento del array.
          if (arreglo[ii]<minimo) {
            minimo=arreglo[ii];
            aux=ii;
          }
        }
        //intercambiar minimo con el elemento i en el array.
        int biaux=arreglo[i];
        arreglo[i]=minimo;
        arreglo[aux]=biaux;
      }

        return;
    }
/**
* @param problema3 Recibe un array de enteros y lo ordena poniendo sus elementos de menor a mayor.
* @return Un array cuyos elementos están ordenados de menor a mayor.
*/

    public static boolean problema4(int[] arreglo, int buscando){
      for (int i=0; i<arreglo.length; i++) {
        if (arreglo[i]==buscando) {
          return true;
          }
        }
        return false;
    }
/**
* @param problema4 Recibe un entero y un array. Regresa true si el entero es elemento del arreglo.
* @return true o false.
*/
    public static boolean problema5(int n){
      if (n==1) {
        return false;
      }
      for (int i=2; i<=Math.sqrt(n); i++) {
        if ((n%i)==0) {
          return false;
        }
      }
      return true;
    }

/**
* @param problema5 Recibe un entero.Regresa true si es un número primo. False en caso contrario.
* @return true o false.
*/
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
/**
* @param problema6 Recibe un entero y regresa un array cuyos elementos son todos los números primos antes de ese número.
* @return Un array cuyos elementos son números primos.
*/

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
