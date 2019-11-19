package chess.pieces.chessPieces;

import java.util.LinkedList;
import java.util.List;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;

/**
* Clase Rook que representa una torre en el juego de ajedrez.
* @author Juan Carlos Zenteno Pompa
*/

public class Rook extends Piece {

  /**
  * Constructor de la clase torre
  * @param p posición de la pieza.
  * @param color Color de la pieza.
  */

    public Rook(Position p, ColorEnum color) {
        super(p, color);
        this.type = PiecesTypeEnum.ROOK;
    }

    public List<Position> getLegalMoves() {
        Board board = Board.getInstance();
        this.legalMoves = new LinkedList<Position>();
        for (int i = this.position.getX() + 1; i < 8; i++) {
            Position nextLegalPosition = new Position(i, this.position.getY());
            if (this.isAppendable(nextLegalPosition) == -1)
                break;
            if (this.isAppendable(nextLegalPosition) == 0) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);
        }

        for (int i = this.position.getX() - 1; i >= 0; i--) {
            Position nextLegalPosition = new Position(i, this.position.getY());
            Piece piece = board.getPiece(nextLegalPosition);
            if (piece.getColor() == this.getColor())
                break;
            if (piece.getColor() != ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);

        }

        for (int i = this.position.getY() + 1; i < 8; i++) {
            Position nextLegalPosition = new Position(this.position.getX(), i);
            Piece piece = board.getPiece(nextLegalPosition);
            if (piece.getColor() == this.getColor())
                break;
            if (piece.getColor() != ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);

        }

        for (int i = this.position.getY() - 1; i >= 0; i--) {
            Position nextLegalPosition = new Position(this.position.getX(), i);
            Piece piece = board.getPiece(nextLegalPosition);
            if (piece.getColor() == this.getColor())
                break;
            if (piece.getColor() != ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);

        }

        return this.legalMoves;
    }

}
