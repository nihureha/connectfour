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

    int slotNum, selectedRow, selectedCol, findRow;
    int array[];
    int turn, win, numRC;
    turn = 1;
    win = 0;
    numRC = numCols * numRows;
    array = new int[numRC];

    int checkIfValid[];
    checkIfValid = new int[numRC];     

    while (win == 0) {

      int rowCheck;

      System.out.println("What column do you want to place at?");
      selectedCol = scanner.nextInt();
      System.out.println("you chose " + selectedCol);
      selectedRow = numRows - 1;
      rowCheck = numRows * numCols - numCols + selectedCol;
      while ((rowCheck >= 0) && (checkIfValid.length > rowCheck) && (rowCheck - numCols >= 0) && ((checkIfValid[rowCheck] == 1) || (checkIfValid[rowCheck] == -1))) {
        rowCheck = rowCheck - numCols;
        selectedRow = selectedRow - 1;
      }
      while (selectedCol >= numCols || (0 > rowCheck) || (selectedCol < 0) || (selectedCol > checkIfValid.length) ||  (rowCheck >= checkIfValid.length) || (checkIfValid[rowCheck] == 1) || (checkIfValid[rowCheck] == -1)) {
        System.out.println("Please choose a different number.");
        selectedCol = scanner.nextInt();
        System.out.println("you chose " + selectedCol);
        selectedRow = numRows - 1;
        rowCheck = numRows * numCols - numCols + selectedCol;
        while ((rowCheck >= 0) && (checkIfValid.length > rowCheck) && (rowCheck - numCols > 0) && ((checkIfValid[rowCheck] == 1) || (checkIfValid[rowCheck] == -1))) {
          rowCheck = rowCheck - numCols;
          selectedRow = selectedRow - 1;
        }
      }

      if (turn == 1) {
        checkIfValid[rowCheck] = 1;
      } else {
        checkIfValid[rowCheck] = -1;
      }

      selectedRow = selectedRow + 1;

      slotNum = numCols * (selectedRow - 1) + selectedCol;

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

      int helpNum;

      helpNum = -1;

      System.out.print(" ");

      while (helpNum < numCols - 1) {
        helpNum = helpNum + 1;
        System.out.print(helpNum + " ");
      }

      System.out.println("");

      helpNum = -1;

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
      // Find a way to win, and also use using selectedCol, and selectedRow. Also, make a plylist in Spotify so that I can listen to all the album mixes.

      int loop, across, stopAcross, downwards, stopDownwards, numColsf, diagonalRight, stopDiagonalRight;
      across = 0;
      stopAcross = numCols - 4;
      downwards = 0;
      numColsf = 0;
      stopDownwards = numRows * 5;
      diagonalRight = 0;
      stopDiagonalRight = numRows * 5;
      loop= 0;
      while (numRows > loop) {
        while (stopAcross >= across) {
          if ((array[across] == 1) && (array[across + 1] == 1) && (array[across + 2] == 1) && (array[across + 3] == 1)) {
            win = 1;
          }
          if ((array[across] == -1) && (array[across + 1] == -1) && (array[across + 2] == -1) && (array[across + 3] == -1)) {
            win = -1;
          }
          across = across + 1;
        }
        stopAcross = stopAcross + numCols;
        loop = loop + 1;
      }
      loop = 0;

      while (numCols > loop) {
        while (stopDownwards >= downwards) {
          if ((array[downwards] == 1) && (array[downwards + numCols] == 1) && (array[downwards + numCols + numCols] == 1) && (array[downwards + numCols + numCols + numCols] == 1)) {
            win = 1;
          }
          if ((array[downwards] == -1) && (array[downwards + numCols] == -1) && (array[downwards + numCols + numCols] == -1) && (array[downwards + numCols + numCols + numCols] == -1)) {
            win = -1;
          }
          downwards = downwards + numCols;
        }
        stopDownwards = stopDownwards + 1;
        numColsf = numColsf + 1;
        downwards = numColsf;
        loop = loop + 1;
      }
      loop = 0;
      numColsf = 0;
      while (numCols - 4 > loop) {
        while (stopDiagonalRight >= diagonalRight) {
          if ((array[diagonalRight] == 1) && (array[diagonalRight + numCols + 1] == 1) && (array[diagonalRight + numCols + numCols + 2] == 1) && (array[diagonalRight + numCols + numCols + numCols + 3] == 1)) {
            win = 1;
          }
          if ((array[diagonalRight] == -1) && (array[diagonalRight + numCols + 1] == -1) && (array[diagonalRight + numCols + numCols + 2] == -1) && (array[diagonalRight + numCols + numCols + numCols + 3] == -1)) {
            win = -1;
          }
          diagonalRight = diagonalRight + numCols;
        }
        stopDiagonalRight = stopDiagonalRight + 1;
        numColsf = numColsf + 1;
        diagonalRight = numColsf;
        loop = loop + 1;
      }
      if (win == 1) {
        System.out.println("X wins!");
      }
      if (win == -1) {
        System.out.println("O wins!");
      }
      /*
      Across: if selectedRow is the same all the time, and selectedCol is increasing and reaches 4, then a win.
      Down: if selectedCol is the same all the time, and selectedRow is increasing and reaches 4, then a win. 
      Diagonal: If num in (numCols - num) is increasing, then it is a win.                              
      */
    }
    System.out.println("");
    System.out.println("Completed");
  }
}
