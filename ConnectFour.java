import java.util.Scanner;

public class ConnectFour {
  public static void main(String[] args) {
    /* ------ DO NOT CHANGE START ------ */

    Scanner scanner;
    scanner = new Scanner(System.in);

    int numRows, numCols;
    
    System.out.println("Welcome to Connect Four!");
    System.out.println("Enter board dimensions: ");
    System.out.print("  Number of rows: "); // NOTE: different from println
    numRows = scanner.nextInt();
    System.out.print("  Number of columns: ");
    numCols = scanner.nextInt();
    // minimum is 4, maximum is 4
    while(numRows < 4 || numRows > 12 ||
      numCols < 4 || numRows > 12) {
      System.out.println("Min dimension is 4 and max is 12. Invalid dimensions.");
      System.out.println("Enter board dimensions: ");
      System.out.print("  Number of rows: ");
      numRows = scanner.nextInt();
      System.out.print("  Number of columns: ");
      numCols = scanner.nextInt();
    }

    /* ------ DO NOT CHANGE END ------ */

    /*
    Notes:

    Start with printing board.
    Find a way to make the board with system.out.print
    */
    // First start off of printing board.
    int rowCounter, colCounter;
    rowCounter = numRows;
    colCounter = numCols;
    String pieceDetector = "";
    String colMaker = "";
    int turn;
    turn = 1;
    // placeDetector will be used to find out what piece will be in each place.
    // Subtract the proudct of numRows and numCols, then subtract that number with numRows.
    // This way, you just need to add by numRows until the number is filled, if filled, keep on going up.
    // If nothing works, just say choose a different column.
    int placePiece[];
    int input, numRC;
    String placed = "";
    numRC = numRows * numCols;
    placePiece = new int[numRC];
    System.out.println("Choose a column.");
    input = scanner.nextInt();
    System.out.println("you just entered " + input);
    input = input - 1;
    if (input > rowCounter) {
      while (input > numRC) {
        System.out.println("Please choose a different column");
        input = scanner.nextInt();
        System.out.println("you just entered " + input);
        input = input - 1;
      }
    }
    rowCounter = numRows;
    while (rowCounter > 0) {
      placed = "| " + pieceDetector;
      colMaker = colMaker + placed;
      System.out.print(placed);
      rowCounter = rowCounter - 1;
      input = input + 1;
      if (rowCounter == 0) {
        System.out.println("|");
      }
    }
    colCounter = numCols;
    colMaker = colMaker + placed;
    while (colCounter > 0) {
      System.out.println(colMaker);
      colCounter = colCounter - 1;
      if (colCounter == 0) {
        System.out.print("|");
      }
    }
 
    /*
    int rowsCol[] = new int[numRows * numCols];
    int turn;

    System.out.println("Array length: " + rowsCol.length);
    String rows;
    rowCounter = rowsCol.length - numRows;
    while (win == 0) {
      if (turn == 1) {
        while (colCounter == 1) {
          // To find out which column it will be placed at.
          // Keep on adding the value of numRows till it subtracts to a negative number.
          // Once that happens, if all the tiles from that are filled, say choose a different column.
          // No one will see this message. At all. 
          rowCols[rowCounter] = rowCols[rowCounter - numRows];
          if ()
          if (rowCols[rowCounter] =< 0) {
            System.out.println("Please choose a different column.");
            input = scanner.nextInt();
            System.out.println("you just entered ");
          }
        }
        rowCols[rowCounter] = 1;
      } else {
        while (colCounter == -1) {
          rowCols[rowCounter] = rowCols[rowCounter - numRows];
          if (rowCols[rowCounter] =< 0) {
            System.out.println("Please choose a different column");
            input = scanner.nextInt();
            System.out.println("you just entered ");
          }
        }
        rowCols[rowCounter] = -1;
      }
      if (turn == 1) {
        turn = -1;
      } else {
        turn = 1;
      }
    }*/
    /*
    New way to print board:
    Make an array the amount of: numRows * numCols.
    To find where to place the stuff.
    First, ask for the column number, then add the numCols to the number of the top row.
    Should reach the bottom, and if filled, keep on subtracting the same number till not filled.
    If filled, say choose a different column
    1. Make a while loop that keeps on placing each row. 
    - Make a while loop for the number of rows, and print "| " + "int[0]".
    - If the value is 0, make it blank. If it is 1, put "X", otherwise, if -1, put "O".
    - 
    */
    System.out.println("Final number of rows is " + numRows);
    System.out.println("Final number of columns is " + numCols);
    
  }
}
