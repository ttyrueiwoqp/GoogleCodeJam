package R1A;

import org.junit.Test;

import java.util.*;

/**
 * Created by lvfan on 4/16/2016.
 */
public class Q2 {

    public static String solve(List<List<Integer>> inputs) {

        Set<Integer> set = new TreeSet<>();
        for (List<Integer> input : inputs) {
            for (Integer i : input) {
                if (set.contains(i)) {
                    set.remove(i);
                } else {
                    set.add(i);
                }
            }
        }
        String res = "";
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            res += it.next() + " ";
        }

        return res;
    }

    @Test
    public void test() {


    }
}
