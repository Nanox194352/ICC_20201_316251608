import java.util.Iterator;
/**
* Código de clase Matriz de la práctica 6
* @author Juan Carlos Zenteno Pompa
*/
import java.util.Arrays;
public class Matrix implements Iterable<Double>{
  private double[][] matrix;
  private int row;
  private int column;

public Iterator<Double> iterator(){
  return new MatrixIterator();
}
private class MatrixIterator<Double> implements Iterator<Double> {
  private int i=0;
  private int ii=0;
    // Checks if the next element exists
    public boolean hasNext() {
      return ((i==row)&&(ii==column));
    }

    // moves the cursor/iterator to next element

      public Double next(){
        if(ii<Matrix.this.matrix[0].length) ii++;
        if(ii == Matrix.this.matrix[0].length){
          ii = 0;
          i++;
        }
        return Matrix.this.matrix[this.i][this.ii];
      }
  }
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
      double[][] matriz = array;
      this.matrix=matriz;
      this.column=array.length;
      this.row=array[0].length;
    } else {
      System.out.println("Invalid Matrix, inconsistent number of rows on received array");
    }
  }

  /**
  * @param getMatrix Returns the bidimensional array that represents the Matrix.
  */
  public double[][] getMatrix() {
    return this.matrix;
  }

  /**
  * @param setMatrix Lets the user change the bidimensional array that represents the Matrix. It checks if the number of rows and columns is consistent.
  */

  public void setMatrix(double[][] aux) {
    boolean correct=true;
    for (int i=1; ((i<aux.length)||(correct==false)); i++) {
      correct=((aux[0].length)==(aux[i].length));
    }
    if (correct) {
      double[][] matrix = aux;
      this.matrix = matrix;
    } else {
      System.out.println("Invalid Matrix, inconsistent number of rows on received array.");
    }
  }
  /**
  * @param scalarProduct Makes the scalar product of the matrix and any real number it receives.
  */
  //Función que calcula producto escalar
  public void scalarProduct(double scalar){
    for (int i=0; i<column; i++) {
      for (int ii=0; ii<row; ii++) {
        matrix[i][ii]=(matrix[i][ii])*scalar;
      }
    }
  }
  /**
  * @param add Makes the addition between two Matrixes. The result is saved on the Matrix that was applied the method.
  */
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
  /**
  * @param matrixProduct Makes the product between two matrixes. The result is saved on the Matrix that was applied the method.
  */
  //Función que calcula producto de matrices
  public void matrixProduct(Matrix m){
    if (this.row==m.column) {
      Matrix product = new Matrix(this.column, m.row);
      for (int i=0; i<this.column; i++) {
        for (int ii=0; ii<this.row; ii++) {
          for (int iii=0; iii<m.row; iii++) {
            product.matrix[ii][i]+=(this.getElement(iii, i)*m.getElement(ii, iii));
          }
        }
      }
      this.setMatrix(product.matrix);
    } else {
      System.out.println("Impossible to make the Matrix Product with given matrixes.");
    }
  }
  /**
  * @param getElement Returns any element on the matrix as long as it is provided with its column and row number.
  */
  //Función que obtiene el elemento i j
  public double getElement(int i, int j){
    double[][] aux = this.getMatrix();
    return aux[i][j];
  }
  /**
  * @param setElement Changes any element in the Matrix  for any real number as long as is provided with its column and row number.
  */
  //function set element
  public void setElement(int i, int j,double e){
    double[][] aux = this.getMatrix();
    aux[i][j]=e;
    this.setMatrix(aux);
  }
  /**
  * @param determinar Calculates the determinant of a Matrix.
  */
  //Función que calcula el determinante si es nxn
  public double determinant(){
    double ans=0;
    int s;
    if(matrix.length==1){
      return(matrix[0][0]);
    }
    for(int i=0;i<matrix.length;i++){
      double[][]smaller= new double[matrix.length-1][matrix.length-1];
      for(int ii=1;ii<matrix.length;ii++){
        for(int iii=0;iii<matrix.length;iii++){
          if(iii<i){
            smaller[ii-1][iii]=matrix[ii][iii];
          }
          else if(iii>i){
            smaller[ii-1][iii-1]=matrix[ii][iii];
          }
        }
      }
      if(i%2==0){
        s=1;
      }
      else{
        s=-1;
      }
      Matrix submatrix = new Matrix(smaller);
      ans+=s*matrix[0][i]*(submatrix.determinant());
    }
    return(ans);
  }
  /**
  * @param equals returns true or false if any two given matrixes have the same characteristics.
  */
  //Función que te dice si 2 matrices son iguales
  public boolean equals(Matrix o){
    if (((this.row)==(o.row))&&((this.column)==(this.column))) {
      boolean ans=true;
      for (int i=0; i<column; i++) {
        for (int ii=0; ii<row; ii++) {
          if ((this.getElement(i, ii))!=(o.getElement(i, ii))) {
            return false;
          }
        }
      }
      return true;
    } else {
      return false;
    }
  }
  /**
  * @param toString returns a String that represents the Matrix as it is usually depicted.
  */
  public String toString(){
    String estring="";
    for (int i=0; i<row; i++) {
      estring+="| ";
      for (int ii=0; ii<column; ii++) {
      estring+=(this.getElement(ii, i)+" ");
      }
      estring+="|\n";
    }
    return estring;
  }
}
