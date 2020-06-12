import java.util.Scanner;
//import java.util.ArrayList;

public class Checkers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board gameboard;
        //create board
        gameboard = new Board();
        System.out.println(gameboard.toString());

        System.out.println("How many players");
        String response = scanner.nextLine();
        int moveCount = 0;
        
        Player player1 = new Player(Piece.color.RED, 1);
        //AI
        Player player2 = new Player(Piece.color.BLACK, 2);

        while (gameboard.getStatus()){
            System.out.println("enter move");
            response = scanner.nextLine();
            
            String[] responseList = response.split(" ");
            while (responseList.length != 4){
                System.out.println("Insert coords to see possible moves");
                response = scanner.nextLine();
            
                responseList = response.split(" ");
            }
            int[] coords = {Integer.parseInt(responseList[0]), Integer.parseInt(responseList[1])};
            int[] move = {Integer.parseInt(responseList[2]), Integer.parseInt(responseList[3])};

                        
            if (moveCount % 2 == 0){
                System.out.println("Player ones turn");
                if(player1.validMove(gameboard, coords, move)){
                    gameboard.movePiece(coords, move);
                    System.out.println(gameboard.toString());
                }
                else{
                        System.out.println("invalid move");
                }
            }
            else{
                System.out.println("Player twos turn");
                if(player2.validMove(gameboard, coords, move)){
                    gameboard.movePiece(coords, move);
                    System.out.println(gameboard.toString());

                    }
                else{
                        System.out.println("invalid move");
                    }
            }

            moveCount++;
        }

        if (gameboard.whoWon() == Piece.color.BLACK){
            System.out.println("Player 1 has won");
        }
        else{
            System.out.println("Player 2 has won");
        }
        
        
        scanner.close();
    }
}