package main.com.sumit.coding.companies.google.recursion;

/*
 * Problem URL : https://leetcode.com/problems/android-unlock-patterns/
 * */
public class AndroidUnlockPatternProblem {

    public static void main(String[] args) {
        int m = 1, n = 2;
        System.out.println(new AndroidUnlockPatternProblem().numberOfPatterns(m, n));
    }

    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        boolean[] visited = new boolean[10];
        int res = dfs(1, 1, m, n, skip, visited) * 4;
        res += dfs(2, 1, m, n, skip, visited) * 4;
        res += dfs(5, 1, m, n, skip, visited);
        return res;
    }

    private int dfs(int num, int level, int min, int max, int[][] skip, boolean[] visited) {
        if (level > max) return 0;
        else {
            visited[num] = true;
            int res = 0;
            for (int i = 1; i <= 9; ++i) {
                if (visited[i] || (skip[num][i] != 0 && !visited[skip[num][i]]))
                    continue;

                res += dfs(i, level + 1, min, max, skip, visited);
            }
            visited[num] = false;
            if (level >= min) res++;

            return res;
        }
    }
}
