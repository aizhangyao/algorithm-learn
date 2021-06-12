package com.aiz.nowcoder.huawei.exam.dev;

import java.util.Scanner;
import java.util.TreeSet;

public class T_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            TreeSet set = new TreeSet();
            for (int i = 0; i < n; i++) {
                Integer key = sc.nextInt();
                set.add(key);
            }
            for (Object o : set) {
                System.out.println(o);
            }
        }
    }

}
