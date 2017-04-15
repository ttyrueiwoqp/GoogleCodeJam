package Y2017.R0.Q3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q3 {

    public static long[] solve(long n, long k) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (b[1] - b[0] == a[1] - a[0]) {
                        if (a[0] - b[0] == 0) {
                            return 0;
                        } else if (a[0] - b[0] > 0) {
                            return 1;
                        } else {
                            return -1;
                        }
                    } else if ((b[1] - b[0]) > (a[1] - a[0])) {
                        return 1;
                    } else {
                        return -1;
                    }
                });

        pq.offer(new long[]{1, n});
        long ls = 0, rs = 0;
        for (long i = 0; i < k; i++) {
            long[] curr = pq.poll();
            long mid = (curr[0] + curr[1]) / 2;
            ls = mid - curr[0];
            rs = curr[1] - mid;
            if (ls > 0) {
                pq.offer(new long[]{curr[0], mid - 1});
            }
            if (rs > 0) {
                pq.offer(new long[]{mid + 1, curr[1]});
            }
        }

        return new long[]{Math.max(ls, rs), Math.min(ls, rs)};
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            long n = in.nextLong();
            long k = in.nextLong();
            long[] res = solve(n, k);
            System.out.println("Case #" + i + ": " + res[0] + " " + res[1]);
        }
    }
}
