import java.util.Scanner;

public class ConnectFour {
  public static void main(String[] args) {
    /* ------ DO NOT CHANGE START ------ */

    Scanner scanner;
    scanner = new Scanner(System.in);

    int numRows, numCols;
    
    System.out.println("Welcome to Connect Four!");
    System.out.println("Enter board width and height: ");
    System.out.print("  Number of rows (4 to 9): "); // NOTE: different from println
    while(!scanner.hasNextInt()) scanner.next();
    numRows = scanner.nextInt();
    System.out.print("  Number of columns (4 to 9): ");
    while(!scanner.hasNextInt()) scanner.next();
    numCols = scanner.nextInt();
    System.out.println("  Requested board width and height: " + numRows + " x " + numCols);
    System.out.println(" -------------------------------------------------------------------------- ");
    // minimum is 4, maximum is 9
    while(numRows < 4 || numRows > 9 ||
      numCols < 4 || numCols > 9) {
      System.out.println("Minimum number of rows/columns is 4 and max is 9.");
      System.out.println("Enter new width and height: ");
      System.out.print("  Number of rows (4 to 9): ");
      while(!scanner.hasNextInt()) scanner.next();
      numRows = scanner.nextInt();
      System.out.print("  Number of columns (4 to 9): ");
      while(!scanner.hasNextInt()) scanner.next();
      numCols = scanner.nextInt();
      System.out.println("  Requested board width and height: " + numRows + " x " + numCols);
      System.out.println(" -------------------------------------------------------------------------- ");
    }

    /* ------ DO NOT CHANGE END ------ */

    int rowNum, colNum, savedNumCols, array[], numRC;

    numRC = numCols * numRows;

    rowNum = 0;

    colNum = 0;

    savedNumCols = numCols;

    int helpNum;

    helpNum = 0;

    System.out.print(" ");

    while (helpNum < numCols) {
      helpNum = helpNum + 1;
      System.out.print(helpNum + " ");
    }

    System.out.println("");

    array = new int[numRC];

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

    int slotNum, selectedRow, selectedCol, findRow;
    int turn, win;
    turn = 1;
    win = 0;
    numRC = numCols * numRows;
    array = new int[numRC];

    int checkIfValid[];
    checkIfValid = new int[numRC];     

    while (win == 0) {

      int rowCheck;

      System.out.println("What column do you want to place at?");
      while(!scanner.hasNextInt()) scanner.next();
      selectedCol = scanner.nextInt();
      System.out.println("you chose " + selectedCol);
      selectedCol = selectedCol - 1;
      selectedRow = numRows - 1;
      rowCheck = numRows * numCols - numCols + selectedCol;
      while ((rowCheck >= 0) && (checkIfValid.length > rowCheck) && (rowCheck - numCols >= 0) && ((checkIfValid[rowCheck] == 1) || (checkIfValid[rowCheck] == -1))) {
        rowCheck = rowCheck - numCols;
        selectedRow = selectedRow - 1;
      }
      while (selectedCol >= numCols || (0 > rowCheck) || (selectedCol < 0) || (selectedCol > checkIfValid.length) ||  (rowCheck >= checkIfValid.length) || (checkIfValid[rowCheck] == 1) || (checkIfValid[rowCheck] == -1)) {
        System.out.println("Please choose a different number.");
        while(!scanner.hasNextInt()) scanner.next();
        selectedCol = scanner.nextInt();
        System.out.println("you chose " + selectedCol);
        selectedCol = selectedCol - 1;
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

      rowNum = 0;

      colNum = 0;

      savedNumCols = numCols;

      helpNum = 0;

      System.out.print(" ");

      while (helpNum < numCols) {
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

      int loop, across, stopAcross, downwards, stopDownwards, numColsf, numRowsf, diagonalRight, stopDiagonalRight, diagonalLeft, stopDiagonalLeft;
      across = 0;
      stopAcross = numCols - 4;
      downwards = 0;
      numColsf = 0;
      stopDownwards = (numRows - 4) * numCols;
      diagonalRight = 0;
      stopDiagonalRight = numCols - 4;
      diagonalLeft = 3;
      stopDiagonalLeft = numCols - 1;
      loop = 0;
      numRowsf = 0;
      // across
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
        numRowsf = numRowsf + numCols;
        across = numRowsf;
        loop = loop + 1;
      }
      // down
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
      
      // (A && B && C && D)
      // diagonalRight = A is inside bounds
      // diagonalRight + numCols + 1 = B is inside bounds
      // diagonalRight + numCols + numCols + 2 = C is out of bounds
      // diagonalRight + numCols + numCols + numCols + 3 = D is out of bounds
      loop = 0;
      numColsf = 0;
      while (numRows - 3 > loop) {
        while (stopDiagonalRight >= diagonalRight) {
          if ((array[diagonalRight] == 1) && (array[diagonalRight + 1 + numCols] == 1) && (array[diagonalRight + 2 + numCols + numCols] == 1) && (array[diagonalRight + 3 + numCols + numCols + numCols] == 1)) {
            win = 1;
          }
          if ((array[diagonalRight] == -1) && (array[diagonalRight + 1 + numCols] == -1) && (array[diagonalRight + 2 + numCols + numCols] == -1) && (array[diagonalRight + 3 + numCols + numCols + numCols] == -1)) {
            win = -1;
          }
          diagonalRight = diagonalRight + 1;
        }
        stopDiagonalRight = stopDiagonalRight + numCols;
        numColsf = numColsf + numCols;
        diagonalRight = numColsf;
        loop = loop + 1;
      }
      // Copy and paste diagonalRight to diagonalLeft.
      loop = 0;
      numColsf = 3;
      while (numRows - 3 > loop) {
        while (stopDiagonalLeft >= diagonalLeft) {
          if ((array[diagonalLeft] == 1) && (array[diagonalLeft - 1 + numCols] == 1) && (array[diagonalLeft - 2 + numCols + numCols] == 1) && (array[diagonalLeft - 3 + numCols + numCols + numCols] == 1)) {
            win = 1;
          }
          if ((array[diagonalLeft] == -1) && (array[diagonalLeft - 1  + numCols] == -1) && (array[diagonalLeft - 2 + numCols + numCols] == -1) && (array[diagonalLeft - 3 + numCols + numCols + numCols] == -1)) {
            win = -1;
          }
          diagonalLeft = diagonalLeft + 1;
        }
        stopDiagonalLeft = stopDiagonalLeft + numCols;
        numColsf = numColsf + numCols;
        diagonalLeft = numColsf;
        loop = loop + 1;
      }
      if (win == 1) {
        System.out.println("X wins!");
      }
      if (win == -1) {
        System.out.println("O wins!");
      }
      int tieDecider;
      tieDecider = 0;
      while ((tieDecider < array.length) && ((array[tieDecider] == 1) || (array[tieDecider] == -1))) {
        tieDecider = tieDecider + 1;
      }
      // win = 2 means tie.
      if ((array.length == tieDecider) && (win == 0)) {
        System.out.println("Tie.");
        win = 2;
      }
      // win = 2 means tie.


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