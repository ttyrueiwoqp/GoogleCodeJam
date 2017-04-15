package Y2017.R1.Q2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q2 {

    private static int solve(int n, int p, int[] r, int[][] q) {
        int res = 0;

        for (int i = 0; i < p; i++) {
            Map<Integer, Integer> m = new HashMap<>();

            for (int j = 0; j < n; j++) {

                Double s = q[j][i] / 1.1 / r[j];
                Double b = q[j][i] / 0.9 / r[j];

                int k = s.intValue();
                if (k < s) {
                    k++;
                }
                while (k >= s && k <= b) {
                    m.put(k, m.getOrDefault(k, 0) + 1);
                    k++;
                }
            }

            for (Map.Entry<Integer, Integer> e : m.entrySet()) {
                if (e.getValue() == n) {
                    res++;
                    break;
                }
            }
        }

//        System.out.println(n);
//        System.out.println(p);
//        System.out.println(Arrays.toString(r));
//        System.out.println(Arrays.deepToString(q));

        return res;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int p = in.nextInt();
            int[] r = new int[n];
            for (int j = 0; j < n; j++) {
                r[j] = in.nextInt();
            }
            int[][] q = new int[n][p];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < p; k++) {
                    q[j][k] = in.nextInt();
                }

            }
            System.out.println("Case #" + i + ": " + solve(n, p, r, q));
        }
    }


}
