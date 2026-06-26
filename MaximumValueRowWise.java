import java.util.Scanner;
public class MaximumValueRowWise{
    public static int firstLargest(int[][] arr, int row, int n) {
        int max = arr[row][0];
        for (int i = 1; i < n; i++) {
            if (arr[row][i] > max) {
                max = arr[row][i];
            }
        }
        return max;
    }
    public static int secondLargest(int[][] arr, int row, int n) {
        int first = arr[row][0];
        int second = -1;
        for (int i = 1; i < n; i++) {
            if (arr[row][i] > first) {
                second = first;
                first = arr[row][i];
            }
            else if (arr[row][i] > second) {
                second = arr[row][i];
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
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int j = 0; j < n; j++) {
            b[0][j] = a[0][j];
        }
        for (int i = 1; i < m; i++) {
            int fl = firstLargest(b, i - 1, n);
            int sl = secondLargest(b, i - 1, n);
            for (int j = 0; j < n; j++) {
                if (b[i - 1][j] == fl) {
                    b[i][j] = a[i][j] + sl;
                } else {
                    b[i][j] = a[i][j] + fl;
                }
            }
        }
        int answer = b[m - 1][0];
        for (int j = 1; j < n; j++) {
            answer = Math.max(answer, b[m - 1][j]);
        }

        System.out.println(answer);

        sc.close();
    }
}
