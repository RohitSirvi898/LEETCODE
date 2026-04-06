class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word, visited, i, j, 0)) return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, boolean[][] visited, int i, int j, int k) {
        if (k == word.length()) return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || 
            visited[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }

        if (k == word.length() - 1) return true;

        visited[i][j] = true;

        boolean found = helper(board, word, visited, i + 1, j, k + 1) ||
                        helper(board, word, visited, i - 1, j, k + 1) ||
                        helper(board, word, visited, i, j + 1, k + 1) ||                        
                        helper(board, word, visited, i, j - 1, k + 1);

        visited[i][j] = false;

        return found;
    }
}