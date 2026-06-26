import java.util.Scanner;
public class AdjacentCellsSum {
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
        int r = sc.nextInt();
        int c = sc.nextInt();
        int sum = 0;
        int[][] adj = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1},  {1, 0},  {1, 1}
        };
        for (int i = 0; i < 8; i++) {
            int row = r + adj[i][0];
            int col = c + adj[i][1];
            if (row >= 0 && row < rows && col >= 0 && col < cols) {
                sum += matrix[row][col];
            }
        }

        System.out.println("Adjacent Cells Sum = " + sum);

        sc.close();
    }
}
