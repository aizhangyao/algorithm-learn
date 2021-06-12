package com.aiz.nowcoder.huawei.exam.dev;

import java.util.Scanner;

public class T_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String hex = sc.next().substring(2);
            int num = Integer.parseInt(hex,16);
            System.out.println(num);
        }
    }

}
