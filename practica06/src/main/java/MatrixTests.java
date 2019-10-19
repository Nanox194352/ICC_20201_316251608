import java.util.Arrays;
public class MatrixTests{
    public static void scalarProduct_test(){
      double[][] aux = {{1.0, 1.0}, {1.0, 2.0}};
      Matrix auxiliar = new Matrix(aux);
      auxiliar.scalarProduct(2.0);
      double[][] two = {{2.0, 2.0}, {2.0, 4.0}};
      if (Arrays.equals(aux, auxiliar.getMatrix())) {
        System.out.println("scalar product succeded");
      } else {
        System.out.println("scalar product failed");
      }
    }
    public static void add_test(){
      double[][] iwannasleep = {{3, 2, 1}, {3, 2, 1}, {3, 2, 1}};
      double[][] help = {{1,2,3}, {1,2,3}, {1,2,3}};
      double[][] iranoutofnames = {{4, 4, 4}, {4, 4, 4}, {4, 4, 4}};
      Matrix auxiliar = new Matrix(iwannasleep);
      Matrix added = new Matrix(help);
      Matrix expected = new Matrix(iranoutofnames);
      auxiliar.add(added);
      if (auxiliar.equals(expected)) {
        System.out.println("addition succeded");
      } else {
        System.out.println("addition failed");
      }

    }
    public static void matrixProduct_test(){
      double[][] iwannasleep = {{3, 2, 1}, {3, 2, 1}, {3, 2, 1}};
      double[][] help = {{1,2,3}, {1,2,3}, {1,2,3}};
      double[][] pr = {{18, 12, 6},{18, 12, 6},{18, 12, 6}};
      Matrix auxiliar = new Matrix(iwannasleep);
      Matrix added = new Matrix(help);
      Matrix expected = new Matrix(pr);
      auxiliar.matrixProduct(added);
      if (auxiliar.equals(expected)) {
        System.out.println("matrix product succeded");
      } else {
        System.out.println("matrix product failed");
      }
    }
    public static void setElement_test(){
      double[][] aux = {{1, 2}, {3, 4}};
      Matrix o = new Matrix(aux);
      double a = 3.14159265358979;
      o.setElement(1, 0, a);
      if ((o.getElement(1, 0))!=a) {
        System.out.println("Set element failed");
      } else {
        System.out.println("Set element succeded");
      }
    }
    public static void getElement_test(){
      double[][] aux = {{1, 2}, {3, 4}};
      Matrix o = new Matrix(aux);
      if ((o.getElement(1, 0))==(aux[1][0])) {
        System.out.println("Get element succeded");
      } else {
        System.out.println("Get element failed");
      }
    }
    public static void determinant_test(){
      double[][] array = {{2}};
      Matrix example = new Matrix(array);
      if (example.determinant()==2) {
          System.out.println("Determinant succeded");
      } else {
        System.out.println("Determinant failed");
      }
    }
    public static void equals_test(){
      double[][] aux = {{43,234,354},{134,364,342546},{123,213,321}};
      Matrix first = new Matrix(aux);
      Matrix second = new Matrix(aux);
      if (first.equals(second)) {
        System.out.println("equals succeded");
      } else {
        System.out.println("equals failed");
      }
    }

    public static void main(String[] args) {
        scalarProduct_test();
        add_test();
        matrixProduct_test();
        setElement_test();
        getElement_test();
        determinant_test();
        equals_test();

    }
}
