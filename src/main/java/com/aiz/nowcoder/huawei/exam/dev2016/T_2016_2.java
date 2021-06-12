package com.aiz.nowcoder.huawei.exam.dev2016;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 */
public class T_2016_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            char[] chs = sc.nextLine().toCharArray();
            if(chs.length>100 || chs.length == 0){
                return;
            }
            LinkedHashMap map = new LinkedHashMap();
            for (int i = 0; i < chs.length; i++) {
                map.put(chs[i],null);
            }
            for (Object o : map.keySet()) {
                System.out.print(o);
            }
            System.out.println();
        }
    }

}
