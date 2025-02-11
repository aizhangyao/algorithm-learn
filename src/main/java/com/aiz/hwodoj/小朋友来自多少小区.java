package com.aiz.hwodoj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ZhangYao
 * @className 小朋友来自多少小区
 * @description 小朋友来自多少小区
 * @date Create in 01:36 2025/2/9
 */
public class 小朋友来自多少小区 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nums = in.nextLine().split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int m = Integer.parseInt(entry.getKey());
            Integer n = entry.getValue();
            // 每个小区实际小朋友数量
            int districtSize = m + 1;
            int group = n / districtSize;
            if (n % districtSize != 0) {
                group++;
            }
            count += districtSize * group;
        }
        System.out.println(count);
    }

}
