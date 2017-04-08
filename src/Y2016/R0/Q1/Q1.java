package Y2016.R0.Q1;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by lvfan on 4/9/2016.
 */
public class Q1 {

    public String sleepCount(final int n) {
        if (n == 0) {
            return "INSOMNIA";
        }

        int[] a = new int[10];
        int j = 0, cnt = 10;
        while (cnt != 0) {
            j++;
            int t = j * n;
            while (t > 0) {
                int r = t % 10;
                if (a[r] == 0) {
                    a[r] = 1;
                    cnt--;
                }
                t /= 10;
            }
        }

        return String.valueOf(j * n);
    }

    public int sleepCount2(final int n) {
        if (n == 0) {
            return -1;
        }

        int[] a = new int[10];
        int j = 0, cnt = 10;
        while (cnt != 0) {
            j++;
            char[] ts = String.valueOf(j * n).toCharArray();
            for (char t : ts) {
                int r = t - '0';
                if (a[r] == 0) {
                    a[r] = 1;
                    cnt--;
                }
            }
        }

        return j * n;
    }

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            System.out.println(sleepCount(i));
        }
        long t1 = 0, t2 = 0, t3 = 0;
        for (int i = 0; i < 1000000; i++) {
//            int j = (int) (Math.random() * 1000000);
//            System.out.println(j + ": " + sleepCount2(j));
            long st = System.nanoTime();
            sleepCount(i);
            long e = System.nanoTime();
            sleepCount2(i);
            long f = System.nanoTime();
            t1 += e - st > f - e ? 1 : 0;
            t2 += f - e > e - st ? 1 : 0;
            t3 += f - e == e - st ? 1 : 0;
        }
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

        int cnt = 0;
        for (int i = 0; i < 1000000; i++) {
//            int j = (int) (Math.random()*1000000);
//            System.out.println(j + ": " + sleepCount2(j));
            long st = System.nanoTime();
            sleepCount(i);
            long e = System.nanoTime();
            sleepCount2(i);
            long f = System.nanoTime();
            if (f - e < e - st) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        Q1 q = new Q1();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            System.out.println("Case #" + i + ": " + q.sleepCount(n));
        }
    }
}