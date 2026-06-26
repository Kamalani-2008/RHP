import java.util.Arrays;
import java.util.Scanner;

public class SushiProblem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] A = new long[N];
        long[] B = new long[M];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }

        for (int i = 0; i < M; i++) {
            B[i] = sc.nextLong();
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0;
        int j = 0;
        int sushiCount = 0;

        while (i < N && j < M) {

            if (B[j] <= 2 * A[i]) {
                sushiCount++;
                i++;
                j++;
            } else {
                i++;
            }
        }

        System.out.println(sushiCount);

        sc.close();
    }
}
