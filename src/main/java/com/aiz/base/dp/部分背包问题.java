package com.aiz.base.dp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ZhangYao
 * @className 部分背包问题
 * @description
 * @date Create in 11:54 2023/8/22
 */
public class 部分背包问题 {

    /**
     * 贪心算法总是做出当前最好的选择，也就是说，它期望通过局部最优选择从而得到全局最优的解决方案。
     */

    /**
     * 有n个物体，第i的物体的重量为wi，价值为ci，
     * 在背包重量不超过V的情况下让选取的总价尽量的高，每一个物体可以支取一部分，价值和重量按比例计算。
     */
    @Test
    public void test() {
        // 求价值率，然后从下到大排序
        // 体积
        int[] w = {2, 3, 4, 5};
        // 价值
        int[] c = {3, 2, 5, 6};
        // 背包容量
        int V = 10;
        // 物品种类
        int N = w.length;

        // 排序
        List<Good> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Good good = new Good(i, w[i], c[i], (double) c[i] / w[i]);
            list.add(good);
        }
        Collections.sort(list, (o1, o2) -> Double.compare(o2.p, o1.p));

        // 选取物品的总体积
        int sum = 0;
        // 可以装的总价值
        double val = 0;
        for (int i = 0; i < list.size(); i++) {
            Good good = list.get(i);
            // 可以全部装下
            if (sum + good.w < V) {
                sum += good.w;
                val += good.c;
                System.out.println("选第" + good.i + "个,v=" + good.w + "/" + good.w + ",获得价值c=" + good.c);
            } else {
                val += (V - sum) * good.p;
                System.out.println("选第" + good.i + "个,v=" + (V - sum) + "/" + good.w + ",获得价值c=" + ((V - sum) * good.p));
                break;
            }
        }
        System.out.println("获得总价值" + val);
    }

    class Good {
        // 下标
        int i;
        // 体积
        int w;
        // 价值
        int c;
        // c/w 价重比
        double p;

        public Good(int i, int w, int c, double p) {
            this.i = i;
            this.w = w;
            this.c = c;
            this.p = p;
        }
    }

}
