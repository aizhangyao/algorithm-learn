package com.aiz.hwodoj;

import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author ZhangYao
 * @className 找朋友
 * @description https://hydro.ac/d/HWODOJ/p/47
 * @date Create in 17:34 2025/2/8
 */
public class 找朋友 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = in.nextInt();
        }
        int[] friends = findFriend(heights);
        for (int i = 0; i < friends.length; i++) {
            if (i == N) {
                System.out.print(friends[i]);
            } else {
                System.out.print(friends[i] + " ");
            }
        }
    }

    private static int[] findFriend(int[] heights) {
        int[] friends = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[i] < heights[j]) {
                    friends[i] = j;
                    break;
                }
            }
        }
        return friends;
    }

    @Test
    public void test() {
        int[] heights = {100, 95};
        int[] friends = findFriend(heights);
        int[] expectedFriends = {0, 0};
        BaseTool.equals(friends, expectedFriends);
    }


    @Test
    public void test2() {
        int[] heights = {123, 124, 125, 121, 119, 122, 126, 123};
        int[] friends = findFriend(heights);
        int[] expectedFriends = {1, 2, 6, 5, 5, 6, 0, 0};
        BaseTool.equals(friends, expectedFriends);
    }
}
