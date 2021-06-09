package com.aiz.leetcode.exam.v20200913;

public class T1 {

    public int numSpecial(int[][] mat) {
        int result = 0;
        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[i].length; j++) {
                int sum = 0;
                if(mat[i][j]==1){
                    for(int q = 0;q < mat.length;q++){
                        sum += mat[q][j];
                    }
                    for (int p = 0; p < mat[i].length; p++) {
                        sum += mat[i][p];
                    }
                    if(sum==2){
                        result++;
                    }
                }

            }
        }
        return result;
    }

    /**
     * 计算下标a和b的两个人之间亲密度的分数
     * @param preferences
     * @param a
     * @param b
     * @return
     */
    public int f(int[][] preferences,int a,int b){
        int fenshu = 0;
        for (int i = 0; i < preferences[a].length; i++) {
            if(a==b){
                break;
            }
            fenshu++;
        }
        return fenshu;
    }

    public static void main(String[] args) {
        //第一组
        int n1 = 4;
        int[][] preferences1 = {{1, 2, 3}, {3, 2, 0},{3, 1, 0}, {1, 2, 0}};
        int[][] pairs1 = {{0, 1}, {2, 3}};
        int count1 = new T1().unhappyFriends(n1,preferences1,pairs1);
        System.out.println(count1);
    }

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        if(n==2){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < pairs.length/2; i++) {
            for(int j = i+1; i<pairs.length/2-1; j++){
                //(x,y)
                int x = pairs[i][0];//第一个人下标
                int y = pairs[i][1];//第二个人下标
                //(u,v)
                int u = pairs[j][0];//第一个人下标
                int v = pairs[j][1];//第二个人下标
                //x与u之间分分数
                int fxu = f(preferences,x,u);
                //x与y之间分分数
                int fxy = f(preferences,x,y);
                //u与x之间分分数
                int fux = f(preferences,u,x);
                //u与v之间分分数
                int fuv = f(preferences,u,v);
                if(fxu<fxy && fux<fux){
                    count++;
                }
            }
        }
        return count;
    }

//    @Test
//    public void testUnhappyFriends(){
//        //第一组
//        int n1 = 4;
//        int[][] preferences1 = {{1, 2, 3}, {3, 2, 0},{3, 1, 0}, {1, 2, 0}};
//        int[][] pairs1 = {{0, 1}, {2, 3}};
//        int count1 = unhappyFriends(n1,preferences1,pairs1);
//        System.out.println(count1);
//
//        //第二组
//        int n2 = 2;
//        int[][] preferences2 = {{1}, {0}};
//        int[][] pairs2 = {{1, 0}};
//        int count2 = unhappyFriends(n2,preferences2,pairs2);
//        System.out.println(count2);
//
//    }

}
