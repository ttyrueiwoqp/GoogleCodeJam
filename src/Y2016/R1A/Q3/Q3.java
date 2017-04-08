package Y2016.R1A.Q3;

import org.junit.Test;

import java.util.*;

/**
 * Created by lvfan on 4/16/2016.
 */
public class Q3 {

    public static int solve(List<Integer> inputs) {

        int maxCnt = 0;

        inputs = new ArrayList<>(inputs);
        inputs.add(0, 0);

        int[][] graph = new int[inputs.size()][inputs.size()];

        for (int i = 1; i < inputs.size(); i++) {
            graph[i][inputs.get(i)] = 1;
            graph[inputs.get(i)][i] = 2;
        }

        for (int i = 1; i < inputs.size(); i++) {
            int[] visited = new int[inputs.size()];
            System.out.println(dfs(graph, i, visited, 1, 1, true));
//            maxCnt = Math.max(maxCnt, );
        }

        return maxCnt;
    }

    private static int dfs(int[][] graph, int i, int[] visited, int cnt, int dir, boolean isFirst) {

        int res = cnt;
        visited[i] = 1;
        boolean hasMore = false;
        for (int j = 1; j < graph.length; j++) {
            if (isFirst && graph[i][j] == 2) {
                continue;
            }
            if (graph[i][j] >= dir && visited[j] == 0) {
                res = Math.max(res, dfs(graph, j, visited, cnt + 1, graph[i][j], false));
                hasMore = true;
            }
        }
        visited[i] = 0;

        if (!hasMore && dir == 1) {
            return Integer.MIN_VALUE;
        }

        return res;
    }

    @Test
    public void test() {
//        List<Integer> list = Arrays.asList(2,3,4,1);
//        System.out.println(solve(list));

        List<Integer> list = Arrays.asList(3,3,4,1);
        System.out.println(solve(list));

//        list = Arrays.asList(3,3,4,3);
//        System.out.println(solve(list));

//        list = Arrays.asList(7,8,10,10,9,2,9,6,3,3);
//        System.out.println(solve(list));

    }
}
