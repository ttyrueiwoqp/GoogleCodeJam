package Y2016.R1B.Q1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1 {

    public static String solve(String s) {

        List<Integer> res = new ArrayList<>();

        Map<Character, Integer> m = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer i = m.get(c);
            if (i == null) {
                m.put(c, 1);
            } else {
                m.put(c, i + 1);
            }
        }

        int[] seq = {0, 4, 8, 6, 5, 3, 2, 1, 7, 9};
        String[] digits = {"ZERO", "FOUR", "EIGHT", "SIX", "FIVE", "THREE", "TWO", "ONE", "SEVEN", "NINE"};
        for (int i = 0; i < digits.length; i++) {
            String digit = digits[i];
            boolean hasMore = true;
            for (char c : digit.toCharArray()) {
                if (m.get(c) == null || m.get(c) == 0) {
                    hasMore = false;
                }
                if ((digit.equals("THREE") || digit.equals("SEVEN"))
                        && c == 'E' && (m.get(c) == null || m.get(c) <= 1)) {
                    hasMore = false;
                }
                if ((digit.equals("NINE"))
                        && c == 'N' && (m.get(c) == null || m.get(c) <= 1)) {
                    hasMore = false;
                }
            }
            if (hasMore) {
                res.add(seq[i]);
                for (char c : digit.toCharArray()) {
                    m.put(c, m.get(c) - 1);
                    if (m.get(c) == 0) {
                        m.remove(c);
                    }
                }
                i--;
            }
        }

        System.out.println(m.isEmpty());

        StringBuilder sb = new StringBuilder();
        for (Integer i : res) {
            sb.append(i);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(solve("OZONETOWER"));
        System.out.println(solve("WEIGHFOXTOURIST"));
        System.out.println(solve("OURNEONFOE"));
        System.out.println(solve("ETHER"));
        System.out.println(solve("VSINXRUEOSEF"));
    }
}
