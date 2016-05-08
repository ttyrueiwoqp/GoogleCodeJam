package R1C;

import org.junit.Test;

import java.util.*;

public class Q1 {

    class Party {
        int num;
        char c;

        public Party(int num, char c) {
            this.num = num;
            this.c = c;
        }
    }

    public String solve(int n, int[] nums) {

        PriorityQueue<Party> parties = new PriorityQueue<>((o1, o2) -> (o2.num - o1.num));

        for (int i = 0; i < n; i++) {
            parties.offer(new Party(nums[i], (char) ('A' + i)));
        }

        StringBuilder sb = new StringBuilder();
        while (!parties.isEmpty()) {
            Party t1 = parties.poll();
            t1.num--;
            sb.append(t1.c);
            if (t1.num > 0) {
                parties.offer(t1);
            }

            if (!parties.isEmpty()) {
                Party t2 = parties.poll();
                if (parties.size() == 1 && t2.num == 1) {
                    parties.offer(t2);
                } else {
                    t2.num--;
                    sb.append(t2.c);
                    if (t2.num > 0) {
                        parties.offer(t2);
                    }
                }
            }

            sb.append(" ");
        }

        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(solve(2, new int[]{2, 2}));
        System.out.println(solve(3, new int[]{3, 2, 2}));
        System.out.println(solve(3, new int[]{1, 1, 2}));
        System.out.println(solve(3, new int[]{2, 3, 1}));


    }
}
