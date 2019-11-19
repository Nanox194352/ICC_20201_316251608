package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;



public class Knight extends Piece {

  /**
  * Constructor de la clase Knight, que representa un caballo en el juego de ajedrez.
  * @param p posición de la pieza.
  * @param color Color de la pieza.
  */

  public Knight(Position p, ColorEnum c) {
    super(p, c);
    this.type=PiecesTypeEnum.KNIGHT;
  }

  public List<Position> getLegalMoves() {
    Board board = Board.getInstance();
    if (this.legalMoves==null) {
      this.legalMoves = new LinkedList<Position>();
      if (this.position.getX()>1) {
        if (this.position.getY()>0) {
          Position nextLegalPosition = new Position(this.position.getX()-2,this.position.getY()-1);
          Piece piece = board.getPiece(nextLegalPosition);
          if (this.getColor()!=piece.getColor()) {
            this.legalMoves.add(nextLegalPosition);
          }
        }
        if (this.position.getY()<7) {
          Position nextLegalPosition = new Position(this.position.getX()-2, this.position.getY()+1);
          Piece piece = board.getPiece(nextLegalPosition);
          if (this.getColor()!=piece.getColor()) {
            this.legalMoves.add(nextLegalPosition);
          }
        }
      }
      if (this.position.getX()>0) {
        if (this.position.getY()>1) {
          Position nextLegalPosition = new Position(this.position.getX()-1, this.position.getY()-2);
          Piece piece = board.getPiece(nextLegalPosition);
          if (this.getColor()!=piece.getColor()) {
            this.legalMoves.add(nextLegalPosition);
          }
        }
        if (this.position.getY()<6) {
          Position nextLegalPosition = new Position(this.position.getX()-1, this.position.getY()+2);
          Piece piece = board.getPiece(nextLegalPosition);
          if (this.getColor()!=piece.getColor()) {
            this.legalMoves.add(nextLegalPosition);
          }
        }
      }
      if (this.position.getX()<6) {
        if (this.position.getY()>0) {
          Position nextLegalPosition = new Position(this.position.getX()+2,this.position.getY()-1);
          Piece piece = board.getPiece(nextLegalPosition);
          if (this.getColor()!=piece.getColor()) {
            this.legalMoves.add(nextLegalPosition);
          }
        }
        if (this.position.getY()<7) {
          Position nextLegalPosition = new Position(this.position.getX()+2, this.position.getY()+1);
          Piece piece = board.getPiece(nextLegalPosition);
          if (this.getColor()!=piece.getColor()) {
            this.legalMoves.add(nextLegalPosition);
          }
        }
      }
      if (this.position.getX()<7) {
        if (this.position.getY()>1) {
          Position nextLegalPosition = new Position(this.position.getX()+1, this.position.getY()-2);
          Piece piece = board.getPiece(nextLegalPosition);
          if (this.getColor()!=piece.getColor()) {
            this.legalMoves.add(nextLegalPosition);
          }
        }
        if (this.position.getY()<6) {
          Position nextLegalPosition = new Position(this.position.getX()+1, this.position.getY()+2);
          Piece piece = board.getPiece(nextLegalPosition);
          if (this.getColor()!=piece.getColor()) {
            this.legalMoves.add(nextLegalPosition);
          }
        }
      }
    }
    return this.legalMoves;
  }
  @Override
  public boolean equals(Object obj) {
      if (!(obj instanceof Queen))
          return false;

      Queen t = (Queen) obj;
      return (t.getColor() == this.getColor()
              && this.getPosition().equals(t.getPosition())) ? true : false;

  }
}
