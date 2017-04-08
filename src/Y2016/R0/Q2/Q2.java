package Y2016.R0.Q2;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q2 {

    public static int flip(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int res = 0, len = s.length();
        char[] cs = s.toCharArray();
        for (int i = 1; i < len; i++) {
            if (cs[i] != cs[i - 1]) {
                res++;
            }
        }
        return cs[len - 1] == '+' ? res : res + 1;
    }

    @Test
    public void test() {

        System.out.println(flip("-"));
        System.out.println(flip("-+"));
        System.out.println(flip("+-"));
        System.out.println(flip("+++"));
        System.out.println(flip("--+-"));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            System.out.println("Case #" + i + ": " + flip(s));
        }
    }
}
