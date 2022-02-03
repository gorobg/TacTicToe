import java.util.Scanner;

public class TacTicToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String newGame = "Y";
        while (newGame.equalsIgnoreCase("Y")){
            String table = "         ";     //Enter empty board
            Engine.printBoard(table);              //print the board
            char player = 'X';              //assign starting player
            boolean gameFinished = false;   //assign a flag for game status-finished or ongoing
            while(!gameFinished) {                      //enter game loop
                table=Engine.secondaryInput(table, player);    //input coordinates of assigned player
                Engine.printBoard(table);
                String status = Engine.getStatus(table);       //board if there is a winner or the game is ongoing or a draw and save it to a string
                switch (status) {                       //switch statement to determine if the game should continue and print appropriate message
                    case "X wins" :
                        System.out.println(status);
                        gameFinished = true;
                        break;
                    case "O wins" :
                        System.out.println(status);
                        gameFinished = true;
                        break;
                    case "Draw" :
                        System.out.println(status);
                        gameFinished = true;
                        break;
                    default:
                        player = player == 'X' ? 'O' : 'X';    //change player if game is not finished and enter loop again for next move
                }
            }
            System.out.println("Do you want to start a new game? Enter Y for yes or any input to exit the game");
            newGame = scanner.nextLine();
        }
    }
}
