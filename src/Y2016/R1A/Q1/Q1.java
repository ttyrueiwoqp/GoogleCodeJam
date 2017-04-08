package Y2016.R1A.Q1;

import org.junit.Test;

public class Q1 {

    public static String solve(String s) {

        String res = "" + s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= res.charAt(0)) {
                res = c + res;
            } else {
                res += c;
            }
        }

        return res;
    }

    @Test
    public void test() {
        System.out.println(solve("CAB"));
        System.out.println(solve("JAM"));
        System.out.println(solve("CODE"));
        System.out.println(solve("ABAAB"));
        System.out.println(solve("CABCBBABC"));
        System.out.println(solve("ABCABCABC"));
        System.out.println(solve("ZXCASDQWE"));

    }


}
