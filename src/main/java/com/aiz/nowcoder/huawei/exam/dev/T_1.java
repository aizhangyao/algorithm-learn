package com.aiz.nowcoder.huawei.exam.dev;

import java.util.Scanner;

public class T_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //n代表空瓶子数量
            int n = sc.nextInt();
            if(n<1||n>100) return;
            int result = 0;//喝了多少瓶
            while (n>=3){
                result += n/3;//可以换汽水的瓶数
                n = n/3 + n%3;//剩下的空瓶子数目
            }
            if(n==2){
                result++;
            }
            System.out.println(result);
        }
    }

}
