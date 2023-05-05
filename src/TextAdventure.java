import java.util.Scanner;
public class TextAdventure {
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);
        System.out.println("HelloWorld");
        String[][] board = new String[10][10];
        for (int i = 0; i < board.length; i++) {        //makes board
            for (int j = 0; j < board.length; j++) {
                board[i][j] = "-";
            }
        }

        int row = 1;
        int col = 1;

        board = update(board, 5,5);
        refresh(board);//prints board to start

        while(row>=0 && col>=0){
            System.out.print("Choose a direction: (w): up, (a): left, (s): down, (d): right. : ");
            String ans = s.nextLine();
            boolean canMove = CheckMove(ans, row, col);
            if(canMove){
                if(ans.equals("w")||ans.equals("s"))
                    row = SetRow(row, ans);
                if(ans.equals("a")||ans.equals("d"))
                    col = SetCol(col, ans);
            }else {
                System.out.println("Can't move that way. Press any letter and \"enter\" to continue");
            }


            board = update(board, row-1,col-1);
            refresh(board);
            System.out.println();
        }

        s.close();
    }
    public static void refresh(String[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static String[][] update(String[][] board, int pRow, int pCol) {//pRow and pCol must be put in as an index
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "-";
                if (i==pRow && j == pCol) {
                    board[pRow][pCol] = "P";
                }
            }
        }
        return board;
    }
    public static boolean CheckMove(String direction, int row, int col){
        switch(direction.toLowerCase()) {
            case "w": if(row!=1)
                return true;
            break;
            case "a": if(col!=1)
                return true;
            break;
            case "s": if(row!=10)
                return true;
            break;
            case "d": if(col!=10)
                return true;
            break;
            default:
                System.out.println("Not a specified direction");
                break;
        }
        return false;
    }
    public static int SetRow(int currentRow, String direction){
        switch (direction.toLowerCase()){
            case "w":
                currentRow-=1;
                break;
            case "s":
                currentRow+=1;
                break;

        }
        return currentRow;
    }
    public static int SetCol(int currentCol, String direction){
        switch (direction.toLowerCase()){
            case "a":
                currentCol-=1;
                break;
            case "d":
                currentCol+=1;
                break;

        }
        return currentCol;
    }

}
