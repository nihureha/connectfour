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
    while(numRows < 4 || numRows > 9 ||
      numCols < 4 || numCols > 9) {
      System.out.println("Min dimension is 4 and max is 9. Invalid dimensions.");
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
    int turn, win;
    win = 0;
    turn = 1;
    // placeDetector will be used to find out what piece will be in each place.
    // Subtract the proudct of numRows and numCols, then subtract that number with numRows.
    // This way, you just need to add by numRows until the number is filled, if filled, keep on going up.
    // If nothing works, just say choose a different column.
    int placePiece[];
    int input, numRC;
    int input1;
    input1 = 0;
    String placed = "";
    numRC = numRows * numCols;
    placePiece = new int[numRC];
    /*
    System.out.println("Choose a row.");
    input1 = scanner.nextInt();
    */
    int leftOver, inputKeeper;
    int input1Keeper;
    leftOver = 0;
      // Try to create the board by printing "|", then print the value. 
      /*
      while ((input > numRows) || (input < 1)) {
        System.out.println("Choose a different row.");
        input1 = scanner.nextInt();
        System.out.println("you chose " + input1);
      }
      */
      /*
      input1Keeper = input1;
      */
      /*
      while (input > 0) {
        if (input == 1) {
          System.out.print("|");
        } else {
          System.out.print("| ");
        }
        if (input == 1) {
          if (turn == 1) {
            pieceDetector = "X";
            System.out.print(pieceDetector + "| ");
          } else {
            pieceDetector = "O";
            System.out.print(pieceDetector + "| ");
          }
        }
        leftOver = leftOver + 1;
        input = input - 1;
      }
      leftOver = numRows - leftOver;
      while (leftOver > 0) {
        if (leftOver == 0) {
          System.out.println("|");
        } else {
          System.out.print("| ");
        }
        leftOver = leftOver - 1;
      }
      if (turn == 1) {
        turn = -1;
      } else {
        turn = 1;
      }
      win = 1;
      System.out.println("");
    }*/
    
    int cols[];
    int min;
    min = 0;
    int input11, input12;
    cols = new int[numCols];
    int i;
    i = 0;
    int rows[];
    rows = new int[numRows];

    // First, find the place of the designated row, then find the place of the designated column.

    System.out.println("numCols: " + cols.length);
    System.out.println("numRows: " + rows.length);

    System.out.println("Choose a column.");
    input = scanner.nextInt();
    System.out.println("you chose " + input);
    input = input - 1;
    while ((input >= numCols) || (input < 0) || (cols[input] == 1)) {
      System.out.println("Choose a different column.");
      input = scanner.nextInt();
      System.out.println("you chose " + input);
      input = input - 1;
    }
    System.out.println("Choose a row.");
    input11 = scanner.nextInt();
    System.out.println("you chose " + input11);
    input11 = input11 - 1;
    while ((input11 >= numRows) || (input11 < 0) || (rows[input11] == 1)) {
      System.out.println("Choose a different row.");
      input11 = scanner.nextInt();
      System.out.println("you chose " + input11);
      input11 = input11 - 1;
    }

    int temporary, extra, inputCounter, input11Counter;

    temporary = 0;
    extra = 0;
    inputCounter = input;
    input11Counter = input11;

    leftOver = numCols - input;

    String hello = "";

    while (input >= 0) {
      if(input == 0){
        hello = hello + "|X";
      } else {
        hello = hello + "| ";
      }
      input = input - 1;
    }
    while (leftOver > 1) {
      leftOver = leftOver - 1;
      hello = hello + "| ";
    }
    // How to find the place of the piece: extra = c * r * 1;

    hello = hello + "|";

    int friend;

    String hello1 = "";

    i = 0;

    while (numCols >= i) {
      hello1 = hello1 + "| ";
      i = i + 1;
    }

    friend = 0;

    while (friend < numRows) {
      if (friend == input11) {
        System.out.println(hello);
      } else {
        System.out.println(hello1);
      }
      friend = friend + 1;
    }
    // After this is just testing for the next time I need to do the coding next time.

    System.out.println("The split between both.");

    int slotNum, selectedRow, selectedCol, findRow;
    int array[];
    array = new int[numRC];
    int whileThing, whileThing1;

    whileThing = 0;
    whileThing1 = 0;

    int checkIfValid[];
    checkIfValid = new int[numRC];     

    while (win == 0) {
      
      /*
      System.out.println("What slot number do you want to place at?");
      slotNum = scanner.nextInt();
      System.out.println("you chose " + slotNum);
      while ((slotNum >= checkIfValid.length) || (slotNum < 0) || (checkIfValid[slotNum] == 1)) {
        System.out.println("Please choose a different slot number.");
        slotNum = scanner.nextInt();
        System.out.println("you chose " + slotNum);
      }
      */

      int rowCheck;

      /*
      slotNum = numCols * selectedRow + selectedCol
      bottomLeft = 
      */

      System.out.println("What column do you want to place at?");
      selectedCol = scanner.nextInt();
      System.out.println("you chose " + selectedCol);
      // Here, find selectedRow. 
      int stf;
      boolean blc;
      blc = false;
      stf = 0;
      int whatev;
      selectedRow = numRows - 1;
      rowCheck = numRows * numCols - numCols + selectedCol;
      System.out.println("rowCheck: " + rowCheck);
      System.out.println("checkIfValid.length: " + checkIfValid.length);
      System.out.println("numRows: " + numRows);
      System.out.println("numCols: " + numCols);
      if (rowCheck > checkIfValid.length) {
        if ((rowCheck > checkIfValid.length) || (turn == 1)) {
          checkIfValid[rowCheck] = 1;
        } else {
          checkIfValid[rowCheck] = -1;
        }
      }
      System.out.println("rowCheck: " + rowCheck);
      System.out.println("rowCheck: " + checkIfValid[rowCheck]);
      // Between here, there is something that is always true so that it keeps the loop going when it should not be going.
      while ((0 >= rowCheck) || (rowCheck >= checkIfValid.length) || (checkIfValid[rowCheck] == 1) || (checkIfValid[rowCheck] == -1)) {
        rowCheck = rowCheck - numCols;
        selectedRow = selectedRow - 1;
        stf = stf + 1;
      }
      // Between here, there is something that is always true so that it keeps the loop going when it should not be going.
      if (rowCheck - numCols < numCols) {
        blc = true;
      } else {
        blc = false;
      }
      if (blc == true) {
        System.out.println("blc = true");
      } else {
        System.out.println("blc = false");
      }
      System.out.println("rowCheck: " + rowCheck);
      System.out.println("checkIfValid[rowCheck]: " + checkIfValid[rowCheck]);
      System.out.println("numCols: " + numCols);
      System.out.println("numRows: " + numRows);
      System.out.println("selectedRow: " + selectedRow);
      System.out.println("rowCheck: " + rowCheck);
      System.out.println("selectedCol: " + selectedCol);
      while (selectedCol >= numCols || (0 >= rowCheck) || (selectedCol < 0) || (selectedCol > checkIfValid.length) || (checkIfValid[rowCheck] == 1) || (checkIfValid[rowCheck] == -1)) {
        System.out.println("Please choose a different number.");
        selectedCol = scanner.nextInt();
        System.out.println("you chose " + selectedCol);
        selectedRow = numRows - 1;
        rowCheck = numRows * numCols - numCols + selectedCol;
        while ((0 >= rowCheck) || (rowCheck >= checkIfValid.length) || (checkIfValid[rowCheck] == 1) || (checkIfValid[rowCheck] == -1)) {
          rowCheck = rowCheck - numCols;
          selectedRow = selectedRow - 1;
          stf = stf + 1;
        }
        System.out.println("selectedRow: " + selectedRow);
        System.out.println("rowCheck: " + rowCheck);
        System.out.println("selectedCol: " + selectedCol);
        System.out.println("numCols: " + numCols);
        System.out.println("numRows: " + numRows);
      }

      if (turn == 1) {
        checkIfValid[rowCheck] = 1;
      } else {
        checkIfValid[rowCheck] = -1;
      }

      selectedRow = selectedRow + 1;

      // Note: Use % sign. Might be useful.

      System.out.println("numCols: " + numCols);
      System.out.println("selectedRow: " + selectedRow);
      System.out.println("selectedCol: " + selectedCol);
      System.out.println("stf: " + stf);
      System.out.println("slotNum = num1 * selectedRow + selectedCol - stf");

      if (numRows > numCols) {
        slotNum = (numCols - 1) * selectedRow + selectedCol + 1 - stf;
      } else if (numCols > numRows) {
        slotNum = (numCols - 1) * selectedRow + selectedCol - 1 - stf;
      } else {
        slotNum = (numCols - 1) * selectedRow + selectedCol - stf;
      }
      /*
      slotNum = (numCols - 1) * selectedRow + selectedCol - stf;
      */
      System.out.println("The slot number: " + slotNum);

      checkIfValid[slotNum] = 1;
      if (array[slotNum] == 0) {
        if (turn == 1) {
          array[slotNum] = 1;
        } else {
          array[slotNum] = -1;
        }
      }

      int rowNum, colNum, savedNumCols;

      rowNum = 0;

      colNum = 0;

      savedNumCols = numCols;

      while (rowNum < numRows) {
        while (colNum < savedNumCols) {
          if (array[colNum] == 1) {
            System.out.print("|X");
          } else if (array[colNum] == -1) {
            System.out.print("|O");
          } else {
            System.out.print("| ");
          }
          colNum = colNum + 1;
        }
        savedNumCols = savedNumCols + numCols;
        System.out.print("|");
        System.out.println();
        rowNum = rowNum + 1;
      }
      if (turn == 1) {
        turn = -1;
      } else {
        turn = 1;
      }
      int keepOnGoing;

      keepOnGoing = 0;

      keepOnGoing = keepOnGoing + 1;
      if (keepOnGoing == 3) {
        win = 1;
      }
    }

    /*
    while (numCols > input1) {
      min = 0;
      System.out.println("Choose a column.");
      input = scanner.nextInt();
      System.out.println("you chose " + input);
      input = input - 1;
      while ((input >= numCols) || (input < 0) || (cols[input] == 1)) {
        System.out.println("Choose a different column.");
        input = scanner.nextInt();
        System.out.println("you chose " + input);
        input = input - 1;
      }
      System.out.println("Choose a row.");
      input11 = scanner.nextInt();
      System.out.println("you chose " + input1);
      input11 = input11 - 1;
      while ((input11 >= numRows) || (input11 < 0) || (rows[input11] == 1)) {
        System.out.println("Choose a different row.");
        input11 = scanner.nextInt();
        System.out.println("you chose " + input1);
        input11 = input11 - 1;
      }
      cols[input] = 1;
      rows[input11] = 1;
      // Find the desginated row first, then find the desginated column.
      while (numCols > min) {
        if (cols[min] == 1) {
          pieceDetector = "X";
        } else {
          pieceDetector = " ";
        }
        System.out.print("|" + pieceDetector);
        min = min + 1;
      }
      input1 = input1 + 1;
      System.out.println("|");
    }
    */
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
    System.out.println("");
    System.out.println("Completed");
  }
}
