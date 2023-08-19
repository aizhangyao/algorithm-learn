package com.aiz.nowcoder.huawei.exam20230818;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        s1.replace("[","");
        String[] split1 = s1.split(",");
        int[] cake = new int[split1.length];
        for (int i = 0; i < cake.length; i++) {
            cake[i] = Integer.parseInt(split1[i]);
        }
        String s2 = in.nextLine();
        String[] split2 = s2.split(",");
        int[] gift = new int[split2.length];
        for (int i = 0; i < gift.length; i++) {
            gift[i] =Integer.parseInt(split2[i]);
        }
        int x = in.nextInt();

        long num = 0;
        for (int i = 0; i < cake.length; i++) {
            for (int j = 0; j < gift.length; j++) {
                if(cake[i] + gift[j] <=x){
                    num++;
                }
            }
        }
        System.out.println(num);
    }
}
