package Y2016.R0.Q4;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q4Simple {

    public static String fractiles(int k, int c, int s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(i + 1).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int k = in.nextInt();
            int c = in.nextInt();
            int s = in.nextInt();
            System.out.println("Case #" + i + ": " + fractiles(k, c, s));
        }
    }

    @Test
    public void test() {
        System.out.println(fractiles(2,3,2));
        System.out.println(fractiles(1,1,1));
        System.out.println(fractiles(2,1,1));
        System.out.println(fractiles(2,1,2));
        System.out.println(fractiles(3,2,3));
        System.out.println(fractiles(95,9,27));
    }

}
