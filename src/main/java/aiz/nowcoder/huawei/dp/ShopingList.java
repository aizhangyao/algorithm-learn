package com.aiz.nowcoder.huawei.dp;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/f9c6f980eeec43ef85be20755ddbeaf4?tpId=37&&tqId=21239&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * @author zhangyao
 */
public class ShopingList {

    public static void main(String[] args) {
        //准备数据
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//总钱数
        int m = scanner.nextInt();//个数
        if(N>=32000 || m>=60){
            return;
        }
        int[] v = new int[m];
        int[] w = new int[m];
        int[] r = new int[m];
        for (int i = 0; i < m; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
            r[i] = scanner.nextInt();
        }
//        for (int i = 0; i < m; i++) {
//            System.out.println(v[i]+" "+w[i]+" "+r[i]);
//        }
        //整理数据 附件合并到主件
        int[][] p = new int[m][2];
        for (int j = 0; j < m; j++) {
            if(r[j]==0){
                p[j][0] += v[j];
                p[j][1] += v[j]*w[j];
            }else{
                p[r[j]][0] += v[j];
                p[r[j]][1] += v[j]*w[j];
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(p[i][0]+" "+p[i][1]);
        }

    }

    /**
     * 求p中任意数量的数字的和(不超过N)的最大值
     * @param p
     * @param N
     * @return
     */
    public static int f(int[][] p,int N){

        return N;
    }
}
