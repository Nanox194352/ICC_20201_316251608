package chess.items;
/**
* Clase Position que representa en términos de x e y la posición de una pieza en un tablero de ajedrez.
* @author Juan Carlos Zenteno Pompa
*/
public class Position{
    private int x;
    private int y;

    /**
    * Constructor de una posición.
    * @param x Posición en x
    * @param y Posición en y
    */

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * @return posición en x.
     */
    public int getX() {
        return x;
    }

    public boolean isLegal(){
        return (this.x < 8 && this.x > -1 && this.y < 8 && this.y > -1 )? true: false;
    }
    /**
     * @return posición en y.
     */
    public int getY() {
        return y;
    }

    /**
    * Compara el tablero con un objeto de cualquier caso.
    * @return true si son iguales, false si son distintos.
    */

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Position))return false;
        Position p = (Position)obj;
        return (p.getX()==this.getX() && p.getY()== this.getY())? true: false;
    }

    /**
    * @return String que representa una posición de la forma ||x:- y:-||
    */

    @Override
    public String toString() {
        return "  ||x:"+this.getX()+" y:"+this.getY()+"||";
    }

    /**
    * Revisa si la posición se encuentra dentro del tablero.
    * @return true o false.
    */

    public boolean isOutOfBoard(int board_size){
        if(this.y >= board_size)return false;
        if(this.x >= board_size)return false;
        if(this.y < 0)return false;
        if(this.x < 0)return false;
        return true;
    }
}
