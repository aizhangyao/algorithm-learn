package com.aiz.lc.offer.day17;

import java.util.PriorityQueue;

/**
 * @author ZhangYao
 * @version 1.0
 * @className MedianFinder
 * @description Offer 41. 数据流中的中位数
 * https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 * @date Create in 16:25 2023/4/21
 */
public class MedianFinder {
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        queMin = new PriorityQueue<Integer>((a, b) -> (b - a));
        queMax = new PriorityQueue<Integer>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMax.size() + 1 < queMin.size()) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        return (queMin.peek() + queMax.peek()) / 2.0;
    }

    /**
     * answer1 : 优先队列 大顶堆 + 小顶堆
     * queMin 大顶堆存放小于中位数的值
     * queMax 小顶堆存放大于中位数的值
     * 为奇数个，queMin比queMax多一个，直接取queMin堆顶
     * 为偶数个，queMin和queMax数量一样，取queMin堆顶和queMax堆顶的平均值。
     */

}
