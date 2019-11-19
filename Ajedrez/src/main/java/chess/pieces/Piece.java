package chess.pieces;
import java.util.List;
import chess.items.Board;
import chess.items.Position;

/**
* Clase abstracte Piece que contiene los métodos comunes a todas las piezas del ajedrez.
* @author Juan Carlos Zenteno Pompa
*/

public abstract class Piece{
    protected Position position;
    protected List<Position> legalMoves = null;
    protected PiecesTypeEnum type;
    protected ColorEnum color;
    protected Board board;

    /**
    * Constructor de la clase piece.
    */

    public Piece(Position p, ColorEnum color) {
        this.position = p;
        this.color = color;
    }

    /**
    * Convierte el color de una pieza a un entero entre -1 y 1.
    */

    public int isAppendable(Position p){
        Board board = Board.getInstance();
        Piece piece = board.getPiece(p);
        if(piece.getColor() == this.getColor())return -1;
        if(piece.getColor() != ColorEnum.NONE)return 0;
        return 1;
    }

    /**
    * Regresa la posición en la que se encuentra una pieza.
    * @return la posición en el tablero que ocupa la pieza.
    */

    public Position getPosition(){
        return this.position;
    }

    /**
    * Regresa el color que tiene la pieza.
    * @return el color que tiene la pieza.
    */
    public ColorEnum getColor(){
        return this.color;
    }

    /**
    * Regresa el tipo de pieza que es la pieza a la que se le aplica el método.
    * @return el tipo de pieza que es esta pieza.
    */

    public PiecesTypeEnum getType(){
        return this.type;
    }

    /**
    * Cambia la posición que tiene la pieza si y solo si pertenece a la lista de movimientos legales.
    */

    public void moveTo(Position p) {
        if (isLegalMove(p)) {
            this.position = p;
            this.legalMoves = null;
            return;
        } else
            return;
    }

    /**
    * Calcula los movimientos que puede realizar la pieza.
    */

    public abstract List<Position> getLegalMoves();

    /**
    * @return True o false dependiendo de si la posición dada es parte de los movimientos legales o no.
    */
    public boolean isLegalMove(Position p) {
        List<Position> moves = this.getLegalMoves();
        return (moves.contains(p)) ? true : false;
    }

    /**
    * Anula la lista de movimientos legales. Usese para eliminar una lista.
    */

    public void nullify(){
      this.legalMoves=null;
    }

    /**
    * @return Un string que representa a la pieza.
    */

    @Override
    public String toString() {
        return this.type.toString();
    }

    /**
    * Compara una pieza con cualquier objeto. Regresa true si son iguales, false en caso contrario.
    */

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Piece))return false;
        Piece p = (Piece)obj;
        if(p.getType().equals(this.type) && p.getColor().equals(this.getColor()) && p.getPosition().equals(this.position))
        return true;
        return false;
    }
}
