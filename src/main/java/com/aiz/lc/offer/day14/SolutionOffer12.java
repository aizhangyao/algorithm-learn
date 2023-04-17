package com.aiz.lc.offer.day14;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer12
 * @description 剑指 Offer 12. 矩阵中的路径
 * https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * @date Create in 12:35 2023/4/17
 */
public class SolutionOffer12 {

    public boolean exist(char[][] board, String word) {
        int row = board.length, colum = board[0].length;
        boolean[][] visited = new boolean[row][colum];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                if (dfs(board, visited, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 深度优先搜索算法（DFS，Depth First Search）
     * 以board[i][j]为起点，是否能搜索到单词word[wordIndex...]。
     *
     * @param board     原数组
     * @param visited   记录是否被访问过的数组
     * @param word      字符串
     * @param wordIndex word[wordIndex...]
     * @param i         board[i,j]起点
     * @param j
     * @return 是否有
     */
    public boolean dfs(char[][] board, boolean[][] visited, String word, int wordIndex, int i, int j) {
        if (board[i][j] != word.charAt(wordIndex)) {
            return false;
        }
        if (wordIndex == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] direction : directions) {
            int newI = i + direction[0], newJ = j + direction[1];
            if (newI >= 0 && newI <= board.length - 1 && newJ >= 0 && newJ <= board[0].length - 1) {
                if (!visited[newI][newJ]) {
                    if (dfs(board, visited, word, wordIndex + 1, newI, newJ)) {
                        return true;
                    }
                }
            }
        }
        visited[i][j] = false;
        return false;
    }

    public static void main2(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";

        SolutionOffer12 solutionOffer12 = new SolutionOffer12();

        System.out.println(solutionOffer12.exist(board, word));
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };
        String word = "AAB";

        SolutionOffer12 solutionOffer12 = new SolutionOffer12();
        System.out.println(solutionOffer12.exist(board, word));
    }

    /**
     * answer1 : 回溯 搜索
     * 时间复杂度：O(MN*3^L)
     * 在每次调用函数 dfs 时，除了第一次可以进入 4 个分支以外，其余时间我们最多会进入 3 个分支（因为每个位置只能使用一次，所以走过来的分支没法走回去）。
     * 由于单词长为 L，故dfs(i,j,0)的时间复杂度为 O(3^L)
     *
     * 空间复杂度：O(MN) visited数组,可以使用改变原数组内容代替".",把时间复杂度优化为O(1)
     */
}
