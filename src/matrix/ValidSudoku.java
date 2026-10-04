package matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

  void main() {
//    char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//      {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//      {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//      {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//      {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//      {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//      {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//      {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//      {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    
    char[][] board = {
      {'.','.','.','.','5','.','.','1','.'},
      {'.','4','.','3','.','.','.','.','.'},
      {'.','.','.','.','.','3','.','.','1'},
      {'8','.','.','.','.','.','.','2','.'},
      {'.','.','2','.','7','.','.','.','.'},
      {'.','1','5','.','.','.','.','.','.'},
      {'.','.','.','.','.','2','.','.','.'},
      {'.','2','.','9','.','.','.','.','.'},
      {'.','.','4','.','.','.','.','.','.'}
    };

    IO.println(isValidSudokuSinglePass(board));
  }

  public boolean isValidSudoku(char[][] board) {
    // check rows
    for (int row = 0; row < 9; row++) {
      Set<Character> seen = new HashSet<>();
      for (int col = 0; col < 9; col++) {
        if (board[row][col] == '.') continue;

        if (seen.contains(board[row][col])) {
          return false;
        } else {
          seen.add(board[row][col]);
        }
      }
    }

    // check columns
    for (int col = 0; col < 9; col++) {
      Set<Character> seen = new HashSet<>();
      for (int row = 0; row < 9; row++) {
        if (board[row][col] == '.') continue;

        if (seen.contains(board[row][col])) {
          return false;
        } else {
          seen.add(board[row][col]);
        }
      }
    }

    // check squares
    for (int square = 0; square < 9; square++) {
      Set<Character> seen = new HashSet<>();
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          int row = (square / 3) * 3 + i;
          int col = (square % 3) * 3 + j;

          if (board[row][col] == '.') continue;

          if (seen.contains(board[row][col])) {
            return false;
          } else {
            seen.add(board[row][col]);
          }
        }
      }
    }

    return true;
  }

  public boolean isValidSudokuSinglePass(char[][] board) {
    Map<Integer, Set<Character>> rows = new HashMap<>();
    Map<Integer, Set<Character>> cols = new HashMap<>();
    Map<String, Set<Character>> squares = new HashMap<>();

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') continue;

        //check rows
        rows.computeIfAbsent(i, k -> new HashSet<>());
        if(rows.get(i).contains(board[i][j])) {
          return false;
        } else {
          rows.get(i).add(board[i][j]);
        }

        //check cols
        cols.computeIfAbsent(j, k -> new HashSet<>());
        if(cols.get(j).contains(board[i][j])) {
          return false;
        } else {
          cols.get(j).add(board[i][j]);
        }

        // check squares
        String squareKey = (i / 3) + "." + (j / 3);
        squares.computeIfAbsent(squareKey, k -> new HashSet<>());
        if (squares.get(squareKey).contains(board[i][j])) {
          return false;
        } else {
          squares.get(squareKey).add(board[i][j]);
        }
      }
    }

    return true;
  }

}
