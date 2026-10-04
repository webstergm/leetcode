package graph;

public class SurroundedRegions {

  int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
//  char[][] board = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
//  char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'}, {'X','O','X','X'}};
  char[][] board = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
  int rows;
  int cols;

  void main() {
    solve(board);
    for (char[] chars : board) {
      IO.print('\n');
      for (char aChar : chars) {
        IO.print(aChar + ",");
      }
    }
  }

  public void solve(char[][] board) {
    rows = board.length;
    cols = board[0].length;

    for (int i = 0; i < cols; i++) {
      formBorderRegion(board, 0, i);
      formBorderRegion(board, rows - 1, i);
    }

    for (int j = 0; j < rows; j++) {
      formBorderRegion(board, j, 0);
      formBorderRegion(board, j, cols - 1);
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        switch (board[i][j]) {
          case '.':
            board[i][j] = 'O';
            break;
          case 'O':
            board[i][j] = 'X';
            break;
        }
      }
    }
  }

  private void formBorderRegion(char[][] board, int currRow, int currCol) {
    if (currRow < 0 || currRow >= rows ||
      currCol < 0 || currCol >= cols ||
      board[currRow][currCol] != 'O') {
      return;
    }
    board[currRow][currCol] = '.';

    for (int[] direction : directions) {
      formBorderRegion(board, currRow + direction[0], currCol + direction[1]);
    }
  }

}
