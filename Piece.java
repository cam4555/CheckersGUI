public class Piece {
    
    //black and false is AI
    enum color{
        RED,
        BLACK
    }

    color pieceColor;
    boolean king;

    public Piece(Piece.color pieceColor){
        this.pieceColor = pieceColor;
        this.king = false;
    }        

    public void makeKing(){
        this.king = true;
    }

    public boolean isKing(){
        return this.king;
    }
    public Piece.color getColor(){
        return pieceColor;
    }

    @Override
    public String toString() {
        if (pieceColor == color.RED){
            return "R";
        }
        return "B";
    }
}