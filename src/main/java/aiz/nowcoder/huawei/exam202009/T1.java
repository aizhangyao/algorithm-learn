package com.aiz.nowcoder.huawei.exam202009;

import java.util.Scanner;
//A 65
//Z 90
//a 97
//z 122

//abababbdsvbgnjrmkttjrnhebwghnjrmkttmjrnehbgwvgbhnjmkkmjnhggbnhtjymkujynhtbrgvegbnmjuntbrtev
public class T1 {
    public static void main(String[] args) {
        //字典表
        int[][] ds = new int[52][2];
        for (int i = 0,a = 97; i < 26; i++,a++) {
            ds[i][0] = a;
            ds[i][1] = 0;
        }
        for (int i = 26,A =65; i < 52; i++,A++) {
            ds[i][0] = A;
            ds[i][1] = 0;
        }
        Scanner sc = new Scanner(System.in);
        char[] chs = sc.nextLine().toCharArray();
        for (char ch : chs) {
            int index = findIndex(ds,ch);
            ds[index][1] ++;
        }

        sort(ds,52);

        for (int i = 0; i < ds.length; i++) {
            if(ds[i][1] != 0){
                System.out.print((char)ds[i][0]+":"+ds[i][1]+";");
            }
        }
    }

    public static int[][] sort(int[][] arr,int len){
        int[] temp = new int[2];
        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-1;j++){
                if(arr[j][1]<arr[j+1][1]){
                    temp[0] = arr[j+1][0];
                    arr[j+1][0] = arr[j][0];
                    arr[j][0] = temp[0];

                    temp[1] = arr[j+1][1];
                    arr[j+1][1] = arr[j][1];
                    arr[j][1] = temp[1];
                }
            }
        }
        return arr;
    }

    public static int findIndex(int[][] ints,char c){
        for (int i = 0; i < ints.length; i++) {
            if(ints[i][0] == c){
                return i;
            }
        }
        return 0;
    }

}
