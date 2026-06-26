import java.util.Scanner;

public class KaranAndCoffee {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();

        final int MAX = 200000;

        int[] diff = new int[MAX + 2];

        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            diff[l]++;
            diff[r + 1]--;
        }

        int[] temp = new int[MAX + 1];

        for (int i = 1; i <= MAX; i++) {
            temp[i] = temp[i - 1] + diff[i];
        }

        int[] prefix = new int[MAX + 1];

        for (int i = 1; i <= MAX; i++) {

            if (temp[i] >= k) {
                prefix[i] = prefix[i - 1] + 1;
            } else {
                prefix[i] = prefix[i - 1];
            }
        }

        StringBuilder result = new StringBuilder();

        while (q-- > 0) {

            int a = sc.nextInt();
            int b = sc.nextInt();

            result.append(prefix[b] - prefix[a - 1]).append("\n");
        }

        System.out.print(result);

        sc.close();
    }
}