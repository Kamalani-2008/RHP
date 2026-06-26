import java.util.Scanner;

public class LongestSubstringWithEqual0sAnd1s {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int start = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            int zeros = 0;
            int ones = 0;

            for (int j = i; j < s.length(); j++) {

                if (s.charAt(j) == '0') {
                    zeros++;
                } else {
                    ones++;
                }

                if (zeros == ones) {

                    int length = j - i + 1;

                    if (length > maxLength) {
                        maxLength = length;
                        start = i;
                    }
                }
            }
        }

        if (maxLength > 0) {
            System.out.println("The longest substring is " +
                    s.substring(start, start + maxLength));
        } else {
            System.out.println("Not found");
        }

        sc.close();
    }
}