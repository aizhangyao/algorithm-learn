package com.aiz.lc.offer.day14;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer13
 * @description 剑指 Offer 13. 机器人的运动范围
 * https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/description/
 * @date Create in 14:47 2023/4/17
 */
public class SolutionOffer13 {

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    /**
     * (i,j) = (i-1,j-1) + (i-1,j+1) + (i+1,j-1) + (i+1,j+1) + 1
     */
    public int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        // 越界 或者 位数和大于k 或者 访问过了
        if (i < 0 || j < 0 || i >= m || j >= n || digitSum(i, j) > k || visited[i][j]) {
            return 0;
        }
        // 标记记录访问过
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, k, visited)
                + dfs(i, j + 1, m, n, k, visited);
    }

    public int digitSum(int m) {
        int sum = 0;
        while (m > 0) {
            sum += m % 10;
            m /= 10;
        }
        return sum;
    }

    public int digitSum(int m, int n) {
        return digitSum(m) + digitSum(n);
    }

    public static void main(String[] args) {
        SolutionOffer13 solutionOffer13 = new SolutionOffer13();
        System.out.println("3,1,0 : " + solutionOffer13.movingCount(3, 1, 0));
        System.out.println("=========================================================");
        System.out.println("16,8,4 : " + solutionOffer13.movingCount(16, 8, 4));
        System.out.println("=========================================================");
        System.out.println(solutionOffer13.digitSum(299));
    }
    /**
     * answer1 : 回溯  深度优先 时间复杂度O(MN) 空间复杂度O(OM)
     * answer2 : 广度优先 借助队列
     */
}
