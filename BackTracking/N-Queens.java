class Solution {

    List<List<String>> ans = new ArrayList<>();
    boolean[] col, diag1, diag2;

    public List<List<String>> solveNQueens(int n) {

        col = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];

        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '.');

        backtrack(0, board, n);
        return ans;
    }

    private void backtrack(int row, char[][] board, int n) {

        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (char[] r : board)
                temp.add(new String(r));
            ans.add(temp);
            return;
        }

        for (int c = 0; c < n; c++) {

            if (col[c] || diag1[row + c] || diag2[row - c + n])
                continue;

            board[row][c] = 'Q';
            col[c] = diag1[row + c] = diag2[row - c + n] = true;

            backtrack(row + 1, board, n);

            board[row][c] = '.';
            col[c] = diag1[row + c] = diag2[row - c + n] = false;
        }
    }
}
