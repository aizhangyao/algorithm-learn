package com.aiz.nowcoder.practice;

/**
 * @ClassName NC68
 * @Description 跳台阶
 *              https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=188&&tqId=38622&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 * @Author Yao
 * @Date Create in 11:14 下午 2021/9/19
 * @Version 1.0
 */
public class NC68 {

    /**
     * 递归思想
     * @param target
     * @return
     */
    public static int jumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    /*
    1 1 (1)
    2 2 (1,1),|| (2)
    3 3 (1,1,1),(1,2),|| (2,1)
    4 5 (1,1,1,1),(1,1,2),(1,2,1),||(2,1,1),(2,2)
    5 8 (1,1,1,1,1),(1,1,1,2),(1,1,2,1),(1,2,1,1),|| (2,1,1,1),(2,1,1,2),(2,1,2,1),(2,2,1,1),(2,1,2),(2,2,1)
     */

    public static void main(String[] args) {
        System.out.println(jumpFloor(7));
    }
}