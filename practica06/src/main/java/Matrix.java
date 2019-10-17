import java.util.Arrays;
public class Matrix{
  private double[][] matrix;
  private int row;
  private int column;
  //Construye una matriz vacia de n por m
  public Matrix(int n, int m){
    this.matrix=new double[n][m];
    this.row=m;
    this.column=n;
  }
  //Construye una matriz dado un arreglo
  public Matrix(double[][] array){
    boolean correct=true;
    for (int i=1; ((i<array.length)||(correct==false)); i++) {  //this for cycle checks if the number of elements per column is consistent.
      correct=((array[0].length)==(array[i].length));
    }
    if (correct) {
      this.matrix=array;
      this.column=array.length;
      this.row=array[0].length;
    } else {
      System.out.println("Invalid Matrix, inconsistent number of rows on received array");
    }
  }
  public double[][] getMatrix() {
    return this.matrix;
  }
  public void setMatrix(double[][] aux) {
    boolean correct=true;
    for (int i=1; ((i<aux.length)||(correct==false)); i++) {
      correct=((aux[0].length)==(aux[i].length));
    }
    if (correct) {
      this.matrix = aux;
    } else {
      System.out.println("Invalid Matrix, inconsistent number of rows on received array.");
    }
  }
  //Función que calcula producto escalar
  public void scalarProduct(double scalar){
    for (int i=0; i<column; i++) {
      for (int ii=0; ii<row; ii++) {
        matrix[i][ii]=(matrix[i][ii])*scalar;
      }
    }
  }
  //Función que calcula suma de matrices
  public void add(Matrix m){
    if (((this.column)==(m.column))&&((this.row)==(m.row))) {
      for (int i=0; i<column; i++) {
        for (int ii=0; ii<row; ii++) {
          this.setElement(i, ii, (this.getElement(i, ii)+m.getElement(i, ii)));
        }
      }
    }
  }
  //Función que calcula producto de matrices
  public void matrixProduct(Matrix m){}
  //Función que obtiene el elemento i j
  public double getElement(int i, int j){
    double[][] aux = this.getMatrix();
    return aux[i][j];
  }
  //function set element
  public void setElement(int i, int j,double e){
    double[][] aux = this.getMatrix();
    aux[i][j]=e;
    this.setMatrix(aux);
  }
  //Función que calcula el determinante si es nxn
  public double determinant(){
    return 0;
  }
  //Función que te dice si 2 matrices son iguales
  @Override
  public boolean equals(Object o){
    if (o instanceof Matrix) {
      Matrix q = (Matrix)o;
      double[][] first = this.getMatrix();
      double[][] second = q.getMatrix();
      return Arrays.equals(first, second);
    } else {
      return false;
    }
  }
}
