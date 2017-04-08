package Y2016.R1B.Q2;

import org.junit.Test;

public class Q2 {

    class Result {
        Long min = Long.MAX_VALUE;
        String a = "", b = "";
    }

    public String solve(String C, String J) {

        Result result = new Result();

        int len = C.length();

        char[] cs = C.toCharArray();
        char[] js = J.toCharArray();

        for (int i = 0; i < len; i++) {

            if (cs[i] == '?' && js[i] == '?') {
                cs[i] = '1';
                js[i] = '0';
                helper(cs, js, result, true);

                cs[i] = '0';
                js[i] = '1';
                helper(cs, js, result, false);

                cs[i] = '0';
                js[i] = '0';

            } else if (cs[i] == '?') {
                if (js[i] != '9') {
                    cs[i] = (char) (js[i] + 1);
                    helper(cs, js, result, true);
                }
                if (js[i] != '0') {
                    cs[i] = (char) (js[i] - 1);
                    helper(cs, js, result, false);
                }
                cs[i] = js[i];

            } else if (js[i] == '?') {
                if (cs[i] != '9') {
                    js[i] = (char) (cs[i] + 1);
                    helper(cs, js, result, false);
                }
                if (cs[i] != '0') {
                    js[i] = (char) (cs[i] - 1);
                    helper(cs, js, result, true);
                }
                js[i] = cs[i];

            } else if (cs[i] != js[i]) {
                helper(cs, js, result, cs[i] > js[i]);
                break;
            }

            if (i == len - 1) {
                helper(cs, js, result, true);
            }
        }

        return result.a + " " + result.b;
    }

    private void helper(char[] cs, char[] js, Result result, boolean isGreater) {
        String a = String.valueOf(cs).replace('?', isGreater ? '0' : '9');
        String b = String.valueOf(js).replace('?', isGreater ? '9' : '0');
        Long diff = Math.abs(Long.valueOf(a) - Long.valueOf(b));
        if (diff < result.min ||
                (diff.equals(result.min)
                        && (Long.valueOf(a) < Long.valueOf(result.a) || Long.valueOf(b) < Long.valueOf(result.b)))) {
            result.min = diff;
            result.a = a;
            result.b = b;
        }
    }

    @Test
    public void test() {
        System.out.println(solve("1?", "2?"));
        System.out.println(solve("?2?", "??3"));
        System.out.println(solve("?", "?"));
        System.out.println(solve("?5", "?0"));
        System.out.println(solve("??7", "5?0"));
        System.out.println(solve("??5??", "??0??"));
        Integer d1 = new Integer(5);
        int d2 = 5;
        System.out.println(d1 == d2);
    }
}
