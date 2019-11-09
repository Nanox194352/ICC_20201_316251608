package chess.pieces;
import java.util.List;
import chess.items.Board;
import chess.items.Position;
public abstract class Piece{
    protected Position position;
    protected List<Position> legalMoves = null;
    protected PiecesTypeEnum type;
    protected ColorEnum color;
    //protected Board board;// = Board.getInstance();

    public Piece(Position p, ColorEnum color) {
        this.position = p;
        this.color = color;
    }

    public Position getPosition(){
        return this.position;
    }
    public ColorEnum getColor(){
        return this.color;
    }

    public void moveTo(Position p) {
        if (isLegalMove(p)) {
            this.position = p;
            this.legalMoves = null;
            return;
        } else
            return;
    }
    public abstract List<Position> getLegalMoves();
   
    public boolean isLegalMove(Position p) {
        List<Position> moves = this.getLegalMoves();
        return (moves.contains(p)) ? true : false;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }

    @Override
    public abstract boolean equals(Object obj);

}