package Y2017.R1.Q1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q1 {

    public static void solve(char[][] m, int r, int c) {
        int res = 0;

        for (int i = 0; i < r; i++) {
            char curr = '?';
            for (int j = 0; j < c; j++) {
                if (m[i][j] != '?') {
                    curr = m[i][j];
                } else {
                    m[i][j] = curr;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            char curr = '?';
            for (int j = c - 1; j >= 0; j--) {
                if (m[i][j] != '?') {
                    curr = m[i][j];
                } else {
                    m[i][j] = curr;
                }
            }
        }

        for (int j = 0; j < c; j++) {
            char curr = '?';
            for (int i = 0; i < r; i++) {
                if (m[i][j] != '?') {
                    curr = m[i][j];
                } else {
                    m[i][j] = curr;
                }
            }
        }

        for (int j = 0; j < c; j++) {
            char curr = '?';
            for (int i = r - 1; i >= 0; i--) {
                if (m[i][j] != '?') {
                    curr = m[i][j];
                } else {
                    m[i][j] = curr;
                }
            }
        }

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int r = in.nextInt();
            int c = in.nextInt();
            char[][] m = new char[r][c];
            for (int j = 0; j < r; j++) {
                m[j] = in.next().toCharArray();
            }
            solve(m, r, c);
            System.out.println("Case #" + i + ": ");
            for (int u = 0; u < r; u++) {
                for (int v = 0; v < c; v++) {
                    System.out.print(m[u][v]);
                }
                System.out.println();
            }
        }
    }
}
