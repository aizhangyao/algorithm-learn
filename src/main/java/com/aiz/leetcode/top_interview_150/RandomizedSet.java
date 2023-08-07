package com.aiz.leetcode.top_interview_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author ZhangYao
 * @version 1.0
 * @className O1时间插入删除和获取随机元素
 * @description https://leetcode.cn/problems/insert-delete-getrandom-o1/
 * @date Create in 17:55 2023/8/7
 */
public class RandomizedSet {
    /**
     * 变长数组 + 哈希表
     * <p>
     * 哈希表存放 (key,value) -> (val,数组的下标)
     */

    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> list;
    private Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        int index = list.size();
        list.add(val);
        map.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        Integer index = map.get(val);
        Integer last = list.get(list.size() - 1);
        list.set(index, last);
        map.put(last, index);

        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        Integer randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

}
