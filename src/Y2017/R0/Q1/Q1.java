package Y2017.R0.Q1;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q1 {

    public static String solve(String line, int n) {
        int res = 0;
        int len = line.length();
        char[] cs = line.toCharArray();

        for (int i = 0; i < len; i++) {
            if (cs[i] == '-') {
                if (i + n > len) {
                    return "IMPOSSIBLE";
                }
                for (int j = i; j < i + n; j++) {
                     cs[j] = cs[j] == '-' ? '+' : '-';
                }
                res++;
            }
        }

        return String.valueOf(res);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String line = in.next();
            int n = in.nextInt();
            System.out.println("Case #" + i + ": " + solve(line, n));
        }
    }

}
