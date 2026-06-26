import java.util.Scanner;

public class LongestSubstring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        int maxLength = 0;
        int end = 0;

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (s2.charAt(i - 1) == s1.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        end = j;
                    }

                } else {
                    dp[i][j] = 0;
                }
            }
        }

        String ans = s1.substring(end - maxLength, end);

        System.out.println("Length = " + maxLength);
        System.out.println("Substring = " + ans);

        sc.close();
    }
}