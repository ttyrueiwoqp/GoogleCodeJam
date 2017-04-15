package Y2017.R0.Q2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q2 {

    public static long solve(long n) {
        String str = String.valueOf(n);
        char[] cs = str.toCharArray();

        int idx = 0;
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] < cs[i - 1]) {
                idx = i;
                break;
            }
        }
        if (idx == 0) {
            return n;
        }

        for (int i = idx; i > 0; i--) {
            if (cs[i] < cs[i - 1]) {
                cs[i] = '9';
                cs[i - 1]--;
            }
        }

        for (int i = idx + 1; i < cs.length; i++) {
            cs[i] = '9';
        }

        return Long.parseLong(String.valueOf(cs));
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            long n = in.nextLong();
            System.out.println("Case #" + i + ": " + solve(n));
        }
    }
}
