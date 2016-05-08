package R1C;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q2 {

    public String solve(int B, int M) {

        int max = 1;
        List<Integer> pow2 = new ArrayList<>();
        for (int i = 0; i < B - 2; i++) {
            int p = (int) Math.pow(2, i);
            max += p;
            pow2.add(p);
        }
        if (max < M) {
            return "IMPOSSIBLE";
        }

        int[][] m = new int[B][B];
        for (int j = 1; j < B - 1; j++) {
            for (int v = j + 1; v <= B - 1; v++) {
                m[j][v] = 1;
            }
        }

        int i = pow2.size() - 1;
        while (i >= 0 && M >= 1) {
            if (M < pow2.get(i)) {
                i--;
                continue;
            }

            m[0][B - 2 - i] = 1;
            M -= pow2.get(i);
            i--;
        }

        if (M == 1) {
            m[0][B - 1] = 1;
            M--;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("POSSIBLE\n");
        for (int k = 0; k < m.length; k++) {
            for (int j = 0; j < m[k].length; j++) {
                sb.append(m[k][j]);
            }
            if (k != m.length - 1) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    @Test
    public void test() {
        for (int i = 0; i < 8; i++) {
            System.out.println(solve(5, i + 1));
        }
        System.out.println(solve(2, 1));
        System.out.println(solve(4, 20));
    }
}
