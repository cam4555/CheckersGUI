public class Tile {
    
    int[] location;
    Piece piece;

    public Tile(int[] location, Piece piece){
        this.location = location;
        this.piece = piece;
    } 

    public boolean hasPiece(){
        if (piece != null){
            return true;
        }
        return false;
    }

    public Piece getPiece(){
        return piece;
    }

    public void removePiece(){
        piece = null;
    }

    public void addPiece(Piece piece){
        this.piece = piece;
    }

    @Override
    public String toString() {
        if (piece == null){
            return "X";
        }
        return piece.toString();
    }
}