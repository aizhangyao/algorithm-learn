package com.aiz.nowcoder.huawei.exam.dev2016;

import java.util.*;

/**
 * 这道题使用ArrayList能够很轻松的解决，每隔两个数删除，就是删除顺序表中i=i+2的数，又由于循环所以要%顺序表的长度。
 * 然后利用顺序表的特性，达到目的。
 */
public class T_2016_1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if (n > 1000) {
                n = 999;
            }
            List<Integer> list=new ArrayList<>();
            int i=0;
            for( i=0;i<n;i++){
                list.add(i);
            }
            while(list.size()>1){
                i=(i+2)%list.size();
                list.remove(i);
            }
            System.out.println(list.get(0));
        }

    }

}
