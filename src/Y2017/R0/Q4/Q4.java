package Y2017.R0.Q4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q4 {

    public static int solve(int n, char[][] a, Set<Addon> res) {

        int[] maxVal = new int[2];

        // >0 if there is already x or o in row / col
        int[] vRow = new int[n];
        int[] vCol = new int[n];

        // >0 if there is already + or o in diagonal
        int[] vD1 = new int[2 * n];
        int[] vD2 = new int[2 * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int pos = 1 + i * n + j;
                switch (a[i][j]) {
                    case '+':
                        vD1[n + i - j] = pos;
                        vD2[i + j] = pos;
                        maxVal[1]++;
                        break;

                    case 'x':
                        vRow[i] = pos;
                        vCol[j] = pos;
                        maxVal[1]++;
                        break;

                    case 'o':
                        vRow[i] = pos;
                        vCol[j] = pos;
                        vD1[n + i - j] = pos;
                        vD2[i + j] = pos;
                        maxVal[1] += 2;
                        break;

                    default:
                        break;
                }
            }
        }

        int[][] resources = new int[n][n];
        int prev = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int curr = 0;
                if (a[i][j] == '+') {
                    if (vRow[i] == 0 && vCol[j] == 0) {
                        curr++;
                    }
                } else if (a[i][j] == 'x') {
                    if (vD1[n + i - j] == 0 && vD2[i + j] == 0) {
                        curr++;
                    }
                } else if (a[i][j] == '\0') {
                    if (vRow[i] == 0 && vCol[j] == 0) {
                        curr++;
                    }
                    if (vD1[n + i - j] == 0 && vD2[i + j] == 0) {
                        curr++;
                    }
                }
                resources[i][j] = prev + curr;
                prev = resources[i][j];
            }
        }


        Set<Addon> addons = new HashSet<>();
        maxVal[0] = maxVal[1];
        helper(n, a, 0, 0, vRow, vCol, vD1, vD2, addons, res, maxVal, resources);

        return maxVal[1];
    }

    private static void helper(int n, char[][] a, int i, int j, int[] vRow, int[] vCol, int[] vD1, int[] vD2, Set<Addon> addons, Set<Addon> res, int[] maxVal, int[][] resources) {

        if (maxVal[0] > maxVal[1]) {
            maxVal[1] = maxVal[0];
            res.clear();
            res.addAll(addons);
        }

        if (i * n + j >= n * n
                || maxVal[0] + resources[i][j] < maxVal[1]) {
            return;
        }

        while (a[i][j] == 'o'
                || (a[i][j] == '+' && (vRow[i] != 0 || vCol[j] != 0))
                || (a[i][j] == 'x' && (vD1[n + i - j] != 0 || vD2[i + j] != 0))
                || (a[i][j] == '\0' && (vRow[i] != 0 || vCol[j] != 0) && (vD1[n + i - j] != 0 || vD2[i + j] != 0))) {

            j++;
            if (j >= n) {
                i++;
                j = 0;
            }
            if (i * n + j >= n * n
                    || maxVal[0] + resources[i][j] < maxVal[1]) {
                return;
            }
        }

        int nextI = i;
        int nextJ = j + 1;
        if (nextJ >= n) {
            nextI++;
            nextJ = 0;
        }
        int pos = 1 + i * n + j;

        if ((a[i][j] == '+' && vRow[i] == 0 && vCol[j] == 0)
                || (a[i][j] == 'x' && vD1[n + i - j] == 0 && vD2[i + j] == 0)
                || (a[i][j] == '\0' && vRow[i] == 0 && vCol[j] == 0 && vD1[n + i - j] == 0 && vD2[i + j] == 0)) {

            char t = a[i][j];
            int[] ts = new int[4];
            ts[0] = vRow[i];
            ts[1] = vCol[j];
            ts[2] = vD1[n + i - j];
            ts[3] = vD2[i + j];

            Addon addon = new Addon('o', i, j);
            addons.add(addon);
            maxVal[0] += a[i][j] == '\0' ? 2 : 1;

            a[i][j] = 'o';
            vRow[i] = vCol[j] = vD1[n + i - j] = vD2[i + j] = pos;

            helper(n, a, nextI, nextJ, vRow, vCol, vD1, vD2, addons, res, maxVal, resources);

            a[i][j] = t;
            vRow[i] = ts[0];
            vCol[j] = ts[1];
            vD1[n + i - j] = ts[2];
            vD2[i + j] = ts[3];
            addons.remove(addon);
            maxVal[0] -= a[i][j] == '\0' ? 2 : 1;
        }

        if (a[i][j] == '\0' && vRow[i] == 0 && vCol[j] == 0) {
            Addon addon = new Addon('x', i, j);
            a[i][j] = 'x';
            vRow[i] = pos;
            vCol[j] = pos;
            addons.add(addon);
            maxVal[0]++;

            helper(n, a, nextI, nextJ, vRow, vCol, vD1, vD2, addons, res, maxVal, resources);

            a[i][j] = '\0';
            vRow[i] = 0;
            vCol[j] = 0;
            addons.remove(addon);
            maxVal[0]--;
        }

        if (a[i][j] == '\0' && vD1[n + i - j] == 0 && vD2[i + j] == 0) {
            Addon addon = new Addon('+', i, j);

            a[i][j] = '+';
            vD1[n + i - j] = pos;
            vD2[i + j] = pos;
            addons.add(addon);
            maxVal[0]++;

            helper(n, a, nextI, nextJ, vRow, vCol, vD1, vD2, addons, res, maxVal, resources);

            a[i][j] = '\0';
            vD1[n + i - j] = 0;
            vD2[i + j] = 0;
            addons.remove(addon);
            maxVal[0]--;
        }

        helper(n, a, nextI, nextJ, vRow, vCol, vD1, vD2, addons, res, maxVal, resources);
    }

    private static class Addon {
        char val;
        int i;
        int j;

        Addon(char val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }

//    @Test
//    public void test() {
////        int n = 8;
////        char[][] a = new char[n][n];
////        a[0][6] = '+';
////        a[0][25] = 'o';
//
//        int n = 100;
//        char[][] a = new char[n][n];
////        a[1][0] = '+';
////        a[1][1] = '+';
////        a[1][2] = '+';
////        a[2][0] = 'x';
//
//        Set<Addon> res = new HashSet<>();
//        System.out.println("Case #" + ": " + solve(n, a, res) + " " + res.size());
//        for (Addon addon : res) {
//            System.out.println(addon.val + " " + (addon.i + 1) + " " + (addon.j + 1));
//        }
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            char[][] a = new char[n][n];

            int m = in.nextInt();
            for (int j = 1; j <= m; j++) {
                String s = in.next();
                int r = in.nextInt() - 1;
                int c = in.nextInt() - 1;
                a[r][c] = s.charAt(0);
            }

            Set<Addon> res = new HashSet<>();
            System.out.println("Case #" + i + ": " + solve(n, a, res) + " " + res.size());
            for (Addon addon : res) {
                System.out.println(addon.val + " " + (addon.i + 1) + " " + (addon.j + 1));
            }
        }
    }

}
