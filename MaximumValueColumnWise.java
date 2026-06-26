import java.util.Scanner;

public class MaximumValueColumnWise {

    // Function to find the largest value in a column
    public static int firstLargest(int[][] arr, int col, int m) {
        int max = arr[0][col];

        for (int i = 1; i < m; i++) {
            if (arr[i][col] > max) {
                max = arr[i][col];
            }
        }

        return max;
    }

    // Function to find the second largest value in a column
    public static int secondLargest(int[][] arr, int col, int m) {
        int first = arr[0][col];
        int second = -1;

        for (int i = 1; i < m; i++) {
            if (arr[i][col] > first) {
                second = first;
                first = arr[i][col];
            } else if (arr[i][col] > second) {
                second = arr[i][col];
            }
        }

        return second;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] a = new int[m][n];
        int[][] b = new int[m][n];

        // Input matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();

                // Copy first column
                if (j == 0) {
                    b[i][0] = a[i][j];
                }
            }
        }

        // Dynamic Programming
        for (int j = 1; j < n; j++) {

            int fl = firstLargest(b, j - 1, m);
            int sl = secondLargest(b, j - 1, m);

            for (int i = 0; i < m; i++) {

                if (b[i][j - 1] == fl) {
                    b[i][j] = a[i][j] + sl;
                } else {
                    b[i][j] = a[i][j] + fl;
                }
            }
        }

        // Find maximum value in the last column
        int ans = b[0][n - 1];

        for (int i = 1; i < m; i++) {
            ans = Math.max(ans, b[i][n - 1]);
        }

        System.out.println(ans);

        sc.close();
    }
}