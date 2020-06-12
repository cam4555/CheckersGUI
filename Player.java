import java.util.ArrayList;

public class Player {
    
    Piece.color type;
    int playerNumber;

    int[] UPRIGHT = {1, 1};
    int[] UPLEFT = {1, -1};
    int[] DOWNRIGHT = {-1, 1};
    int[] DOWNLEFT = {-1, -1};


    //player num 0 = ai.
    //player num 1 = red
    //player num 2 = black
    public Player(Piece.color type, int playerNumber){
        this.type = type;
        this.playerNumber = playerNumber;

        if (playerNumber == 2){
            UPRIGHT[0] *= -1;
            UPRIGHT[1] *= -1;
            UPLEFT[0] *= -1;
            UPLEFT[1] *= -1;
            DOWNLEFT[0] *= -1;
            DOWNLEFT[1] *= -1;
            DOWNRIGHT[0] *= -1;
            DOWNRIGHT[1] *= -1;
        }
    }


    public Piece.color getType(){
        return type;
    }

    public boolean moveInBounds(int[] move){
        if (move[0] >= 0 && move[0] < 8 && move[1] >= 0 && move[1] < 8){
            return true;
        }
        return false;

    }





    public boolean validMove(Board board, int[] currentLocation, int[] move){
        ArrayList<int[]> possibleMoves = possibleMoves(board, currentLocation);

        for (int i = 0; i < possibleMoves.size(); i++){
            if (possibleMoves.get(i)[0] == move[0] && possibleMoves.get(i)[1] == move[1]){
                return true;
            }
        }
        return false;
    }


    public ArrayList<int[]> possibleMoves(Board board, int[] coords){
        ArrayList<int[]> moveList = new ArrayList<>();
        //todo
        if (board.tileAtCoord(coords).hasPiece() && moveInBounds(coords) && board.tileAtCoord(coords).getPiece().getColor() == this.type){
            if (moveInBounds(new int[] {coords[0] + UPRIGHT[0], coords[1] + UPRIGHT[1]}) && !board.tileAtCoord(new int[] {coords[0] + UPRIGHT[0], coords[1] + UPRIGHT[1]}).hasPiece()){
                moveList.add(new int[] {coords[0] + UPRIGHT[0], coords[1] + UPRIGHT[1]});
            }
            else if (moveInBounds(new int[] {coords[0] + UPRIGHT[0] * 2, coords[1] + UPRIGHT[1]*2}) && board.tileAtCoord(new int[] {coords[0] + UPRIGHT[0], coords[1] + UPRIGHT[1]}).getPiece().getColor() != this.type){
                moveList.add(new int[] {coords[0] + UPRIGHT[0] * 2, coords[1] + UPRIGHT[1] * 2});
            }
            
            if (moveInBounds(new int[] {coords[0] + UPLEFT[0], coords[1] + UPLEFT[1]}) && !board.tileAtCoord(new int[] {coords[0] + UPLEFT[0], coords[1] + UPLEFT[1]}).hasPiece()){
                moveList.add(new int[] {coords[0] + UPLEFT[0], coords[1] + UPLEFT[1]});
            }
            else if (moveInBounds(new int[] {coords[0] + UPLEFT[0] * 2, coords[1] + UPLEFT[1]*2}) && board.tileAtCoord(new int[] {coords[0] + UPLEFT[0], coords[1] + UPLEFT[1]}).getPiece().getColor() != this.type){
                moveList.add(new int[] {coords[0] + UPLEFT[0] * 2, coords[1] + UPLEFT[1] * 2});
            }
            if (board.tileAtCoord(coords).getPiece().isKing()){
                if (moveInBounds(new int[] {coords[0] + DOWNRIGHT[0], coords[1] + DOWNRIGHT[1]})){
                    moveList.add(new int[] {coords[0] + DOWNRIGHT[0], coords[1] + DOWNRIGHT[1]});
                }
                if (moveInBounds(new int[] {coords[0] + DOWNLEFT[0], coords[1] + DOWNLEFT[1]})){
                    moveList.add(new int[] {coords[0] + DOWNLEFT[0], coords[1] + DOWNLEFT[1]});
                }
            }
        }
        return moveList;
    }

}