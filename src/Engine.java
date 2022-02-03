import java.util.InputMismatchException;
import java.util.Scanner;

public class Engine {
    //check the board (in the form of a string) for a winner or a draw
    public static String getStatus(String tableValues){
        boolean xWins = false;
        boolean oWins = false;
        String result;
        // loop to check all rows for a winner
        for (int i = 0; i < tableValues.length() - 2 ; i += 3) {
            if (tableValues.charAt(i) == tableValues.charAt(i + 1) && tableValues.charAt(i) == tableValues.charAt(i + 2)) {
                if (tableValues.charAt(i) == 'X') {
                    xWins = true;
                } else if (tableValues.charAt(i) == 'O') {
                    oWins = true;
                }
            }
        }
        // loop to find a winner in all columns
        for (int i = 0; i < tableValues.length() / 3; i ++) {
            if (tableValues.charAt(i) == tableValues.charAt(i + 3) && tableValues.charAt(i) == tableValues.charAt(i + 6)) {
                if (tableValues.charAt(i) == 'X') {
                    xWins = true;
                } else if (tableValues.charAt(i) == 'O') {
                    oWins = true;
                }
            }
        }
        // check diagonals for a winner
        for (int i = 0; i < tableValues.length() / 3; i += 1) {
            if (tableValues.charAt(0) == tableValues.charAt(4) && tableValues.charAt(0) == tableValues.charAt(8)||
                    tableValues.charAt(2) == tableValues.charAt(4) && tableValues.charAt(4) == tableValues.charAt(6)) {
                if (tableValues.charAt(4) == 'X') {
                    xWins = true;
                } else if (tableValues.charAt(4) == 'O') {
                    oWins = true;
                }
            }
        }
        result = xWins ? "X wins" : oWins ? "O wins" : tableValues.contains("_") || tableValues.contains(" ") ? "Ongoing" : "Draw";
        return result;
    }
    //input coordinates of a player method with appropriate check and messages
    static String secondaryInput(String table, char player){
        int x;
        int y;
        boolean nextInput = true;
        while (nextInput){
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Enter the coordinates: ");
                x = scanner.nextInt();
                y = scanner.nextInt();
            }catch (InputMismatchException е){
                System.out.println("You should enter numbers!");
                continue;
            }
            if(x > 3 || x <= 0 || y> 3 || y <= 0) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else {
                int index = getIndex(x, y);
                if(isEmptyCell(index, table)) {
                    table = table.substring(0, index) + player + table.substring(index+1);
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                break;
            }
        }
        return table;

    }
    //determine the index of the table string based on the input coordinates
    static int getIndex(int x,int y){
        int index;
        if (x == 1){
            index = Math.abs(x - y);
        } else if (x == 2) {
            index = x + y;
        } else {
            index = x + y + 2;
        }
        return index;
    }

    static boolean isEmptyCell(int index, String table){
        if (table.charAt(index) == '_' || table.charAt(index) == ' ') {
            return true;
        } else {
            return false;
        }
    }

    static void printBoard(String table){
        System.out.println("---------");
        System.out.print("| "+ table.charAt(0) + " " + table.charAt(1) + " " + table.charAt(2) + " |\n");
        System.out.print("| "+ table.charAt(3) + " " + table.charAt(4) + " " + table.charAt(5) + " |\n");
        System.out.print("| "+ table.charAt(6) + " " + table.charAt(7) + " " + table.charAt(8) + " |\n");
        System.out.println("---------");
    }
}
