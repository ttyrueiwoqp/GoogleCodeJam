package Y2016.R0.Q3;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by lvfan on 4/9/2016.
 */
public class Q3 {

    public static List<String> jamcoin(int n, int j) {

        List<String> res = new ArrayList<>();
        Deque<List<Integer>> queue = new ArrayDeque<>();
        int cnt = 0;
        for (int i = 1; i < n - 1 - i; i++) {
            List<Integer> newList = new ArrayList<>();
            newList.add(i);
            queue.addLast(newList);
        }

        while (!queue.isEmpty() && cnt < j) {
            List<Integer> list = queue.poll();
            process(res, list, n);
            cnt++;
            if (cnt >= j) {
                break;
            }

            int last = list.get(list.size() - 1);
            for (int i = 1; i < last; i++) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(list);
                newList.add(i);
                queue.addLast(newList);
            }
        }

        return res;
    }

    private static void process(List<String> res, List<Integer> list, int n) {
        StringBuilder sb = new StringBuilder();
        int[] cs = new int[n];
        cs[0] = 1;
        cs[n - 1] = 1;
        int idx1 = list.get(0);
        int idx2 = n - 1 - idx1;
        cs[idx1] = 1;
        cs[idx2] = 1;

        for (int i = 1; i < list.size(); i++) {
            int idx = list.get(i);
            cs[idx] = 1;
            cs[idx2 + idx] = 1;
        }
        for (int i = cs.length - 1; i >= 0; i--) {
            sb.append(cs[i]);
        }
        sb.append(" ");

        for (int b = 2; b <= 10; b++) {
            long d = 1L;
            for (Integer p : list) {
                d += (long) Math.pow(b, p);
            }
            sb.append(d).append(" ");
        }
        res.add(sb.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int j = in.nextInt();
            System.out.println("Case #" + i + ":");
            List<String> res = jamcoin(n, j);
            for (String s : res) {
                System.out.println(s);
            }
        }
    }


    @Test
    public void test() {
        List<String> a = jamcoin(19, 500);
        System.out.println(a.size());
        for (String s : a) {
//            System.out.println(s);
            test3(s);
        }
    }

    //
    private void test3(String s) {
        Set<Long> set = new HashSet<>();
        String[] ss = s.split(" ");
        for (int i = 2; i <= 10; i++) {
            Long a = Long.parseLong(ss[0], i);
            Long d = Long.parseLong(ss[i - 1]);
            if (a % d != 0) {
                System.out.print("ERROR");
            }
            if (set.contains(a)) {
                System.out.print("ERROR");
            }
            set.add(a);
        }
//        System.out.println();
    }

}
