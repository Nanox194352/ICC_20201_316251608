package chess.items;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.chessPieces.Empty;
import chess.pieces.chessPieces.Rook;
import chess.pieces.chessPieces.*;

/**
* Clase Board que modela un tablero de ajedrez usando una matriz cuadrada.
* @author Juan Carlos Zenteno Pompa
*/

public class Board{
    public int SIZE = 8;
    public Piece[][] matrix;
    private static Board instance = null;

    /**
    * Constructor del tablero. No recibe ningún parámetro porque el tamaño del tablero será siempre de 8x8.
    * Usa un ciclo for para llenar todos los espacios del tablero con espacios vacíos y luego se colocan las piezas.
    */
    private Board(){
        this.matrix = new Piece[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.matrix[i][j] = new Empty(new Position(i, j), ColorEnum.NONE);
            }
        }

        this.matrix[7][0] = new Rook(new Position(7, 0), ColorEnum.BLACK);
        this.matrix[0][0] = new Rook(new Position(0, 0), ColorEnum.BLACK);
        this.matrix[6][0] = new Knight(new Position(6,0), ColorEnum.BLACK);
        this.matrix[1][0] = new Knight(new Position(1,0), ColorEnum.BLACK);
        this.matrix[5][0] = new Bishop(new Position(5,0), ColorEnum.BLACK);
        this.matrix[2][0] = new Bishop(new Position(2,0), ColorEnum.BLACK);
        this.matrix[4][0] = new Queen(new Position(4,0), ColorEnum.BLACK);
        this.matrix[3][0] = new King(new Position(3,0), ColorEnum.BLACK);
        for (int i=0; i<8; i++) {
          this.matrix[i][1] = new Pawn(new Position(i, 1), ColorEnum.BLACK);
        }

        this.matrix[7][7] = new Rook(new Position(7, 7), ColorEnum.WHITE);
        this.matrix[0][7] = new Rook(new Position(0, 7), ColorEnum.WHITE);
        this.matrix[6][7] = new Knight(new Position(6,7), ColorEnum.WHITE);
        this.matrix[1][7] = new Knight(new Position(1,7), ColorEnum.WHITE);
        this.matrix[5][7] = new Bishop(new Position(5,7), ColorEnum.WHITE);
        this.matrix[2][7] = new Bishop(new Position(2,7), ColorEnum.WHITE);
        this.matrix[4][7] = new Queen(new Position(4,7), ColorEnum.WHITE);
        this.matrix[3][7] = new King(new Position(3,7), ColorEnum.WHITE);
        for (int i=0; i<8; i++) {
          this.matrix[i][6] = new Pawn(new Position(i, 6), ColorEnum.WHITE);
        }
    }

    /**
    * Método que regresa el tablero. Si no hay un tablero invoca el constructor.
    * @return el tablero.
    */

    public static Board getInstance(){
        if(instance == null){
            instance = new Board();
        }
        return instance;
    }

    /**
    * @return 8
    */

    public int getSize(){
        return this.SIZE;
    }

    /**
    * Método que regresa la pieza que se encuentre en la posición p.
    * @param p posición de la pieza.
    * @return Pieza en la posición p.
    */

    public Piece getPiece(Position p){
        //if(p.isOutOfBoard(SIZE))return null;
        return this.matrix[p.getX()][p.getY()];
    }

    /**
    * Método que recibe una posición p y una posición q. Revisa trasladar una pieza en p a la posición q es un movimiento legal,
    * y hace el cambio de posición si es así.
    * @param p Posición inicial de la pieza que se quiere mover.
    * @param q Posición a la que se prente desplazar la pieza en p.
    */

    public void move(Position p, Position q){
        if(!p.isLegal() || !q.isLegal())return;
        Piece piece = this.getPiece(p);
        if(!piece.isLegalMove(q))return;
        piece.moveTo(q);
        this.matrix[p.getX()][p.getY()] = new Empty(p,ColorEnum.NONE);
        this.matrix[q.getX()][q.getY()] = piece;
    }

    /**
    * Convierte a un String que representa al tablero, que imprime cada casilla y cada pieza en ellas (usando nombres).
    * @return un String que representa al tablero.
    */

    @Override
    public String toString(){
        var result = "";
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result = " "+ this.matrix[i][j]+" "+result;
            }
            result += '\n';
        }
        return result;
    }

}
