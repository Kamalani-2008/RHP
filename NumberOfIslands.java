import java.util.Scanner;

public class NumberOfIslands {

    // Directions: Left, Right, Up, Down
    static int[][] diff = {
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
    };

    // DFS function
    public static void dfs(char[][] grid, int i, int j, int rows, int cols) {

        grid[i][j] = '0'; // Mark as visited

        for (int k = 0; k < 4; k++) {

            int newRow = i + diff[k][0];
            int newCol = j + diff[k][1];

            if (newRow >= 0 && newCol >= 0 &&
                    newRow < rows && newCol < cols &&
                    grid[newRow][newCol] == '1') {

                dfs(grid, newRow, newCol, rows, cols);
            }
        }
    }

    public static int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == '1') {

                    islands++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }

        return islands;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        char[][] grid = new char[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                grid[i][j] = sc.next().charAt(0);
            }
        }

        System.out.println("Number of Islands = " + numIslands(grid));

        sc.close();
    }
}