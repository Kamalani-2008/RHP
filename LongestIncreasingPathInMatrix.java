import java.util.Scanner;
public class LongestIncreasingPathInMatrix {
    static int[][] diff = {
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
    };
    public static int dfs(int[][] matrix, int[][] dp, int rows, int cols, int row, int col) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        int adjacentMax = 0;
        for (int i = 0; i < 4; i++) {
            int newRow = row + diff[i][0];
            int newCol = col + diff[i][1];
            if (newRow >= 0 && newCol >= 0 &&
                    newRow < rows && newCol < cols &&
                    matrix[newRow][newCol] > matrix[row][col]) {
                adjacentMax = Math.max(adjacentMax,
                        dfs(matrix, dp, rows, cols, newRow, newCol));
            }
        }
        dp[row][col] = 1 + adjacentMax;
        return dp[row][col];
    }
    public static int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int maxLength = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dp[i][j] == 0) {
                    maxLength = Math.max(maxLength,
                            dfs(matrix, dp, rows, cols, i, j));
                }
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Longest Increasing Path = "
                + longestIncreasingPath(matrix));
        sc.close();
    }
}
