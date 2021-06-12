package com.aiz.nowcoder.print;

import java.util.Arrays;
import java.util.Scanner;

public class StringSort_2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String[] strs = sc.nextLine().split(" ");
            Arrays.sort(strs);
            for(int i =0;i<strs.length;i++){
                if(i==strs.length-1){
                    System.out.println(strs[i]);
                }else{
                    System.out.print(strs[i]+" ");
                }
            }
        }

    }

}
