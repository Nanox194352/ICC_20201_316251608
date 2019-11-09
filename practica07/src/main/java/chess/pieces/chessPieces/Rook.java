package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;

public class Rook extends Piece {
    public Rook(Position p, ColorEnum color) {
        super(p,color);
        this.type = PiecesTypeEnum.ROOK;

    }


    public List<Position> getLegalMoves() {
        Board board = Board.getInstance();
        if (this.legalMoves == null) {
            this.legalMoves = new LinkedList<Position>();
            for(int i = this.position.getX()+1;i < 8; i++){
                Position nextLegalPosition = new Position(i, this.position.getY());
                Piece piece = board.getPiece(nextLegalPosition);
                if(piece.getColor() == this.getColor())break;
                if(piece.getColor() != ColorEnum.NONE){
                    this.legalMoves.add(nextLegalPosition);
                    break;
                }
                this.legalMoves.add(nextLegalPosition);

            }

            for(int i = this.position.getX()-1;i >= 0; i--){
                Position nextLegalPosition = new Position(i, this.position.getY());
                Piece piece = board.getPiece(nextLegalPosition);
                if(piece.getColor() == this.getColor())break;
                if(piece.getColor() != ColorEnum.NONE){
                    this.legalMoves.add(nextLegalPosition);
                    break;
                }
                this.legalMoves.add(nextLegalPosition);

            }

            for(int i = this.position.getY()+1;i < 8; i++){
                Position nextLegalPosition = new Position(this.position.getX(),i);
                Piece piece = board.getPiece(nextLegalPosition);
                if(piece.getColor() == this.getColor())break;
                if(piece.getColor() != ColorEnum.NONE){
                    this.legalMoves.add(nextLegalPosition);
                    break;
                }
                this.legalMoves.add(nextLegalPosition);

            }


            for(int i = this.position.getY()-1;i >= 0; i--){
                Position nextLegalPosition = new Position(this.position.getX(),i);
                Piece piece = board.getPiece(nextLegalPosition);
                if(piece.getColor() == this.getColor())break;
                if(piece.getColor() != ColorEnum.NONE){
                    this.legalMoves.add(nextLegalPosition);
                    break;
                }
                this.legalMoves.add(nextLegalPosition);

            }
        }
        return this.legalMoves;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Rook))
            return false;

        Rook t = (Rook) obj;
        return (t.getColor() == this.getColor()
                && this.getPosition().equals(t.getPosition())) ? true : false;

    }

}
