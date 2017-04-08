package Y2016.R0.Q4;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q4 {

    public static String fractiles(int k, int c, int s) {

        if (c > k) {
            c = k;
        }
        int sMin = (k + c - 1) / c;
        if (s < sMin) {
            return "IMPOSSIBLE";
        }
        if (k == 1) {
            return "1";
        }

        long[] ks = new long[c + 1];
        ks[0] = 1;
        for (int i = 1; i < ks.length; i++) {
            ks[i] = ks[i - 1] * k;
        }

        long[] arr = new long[sMin];
        int p = 0;
        while (p < sMin) {
            for (int i = 0; i < c; i++) {
                arr[p] += (p * c + i) * ks[c - i - 1];
            }
            arr[p] = Math.min(arr[p], ks[c] - 1);
            arr[p]++;
            p++;
        }

        StringBuilder sb = new StringBuilder();
        for (long a : arr) {
            sb.append(a).append(" ");
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
//        System.out.println(fractiles(2,3,2));
//        System.out.println(fractiles(1,1,1));
//        System.out.println(fractiles(2,1,1));
//        System.out.println(fractiles(2,1,2));
        System.out.println(fractiles(3,2,3));
    }

    private void build(int k, int c) {
        int[][] a = new int[k][c];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < c; j++) {

            }
        }
    }

}
