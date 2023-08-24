package com.aiz.leetcode.top_interview_150;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ZhangYao
 * @className LRU缓存
 * @description https://leetcode.cn/problems/lru-cache/
 * @date Create in 18:39 2023/8/24
 */
class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    /**
     * Least Recently Used 最近最少使用
     * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
     */
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}