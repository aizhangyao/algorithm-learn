package com.aiz.nowcoder.huawei.exam202009;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//手机数目
        int[] types = new int[101];//存放每种类型有几台
        for (int i = 0; i < n; i++) {
            int nums = sc.nextInt();//手机类型编号
            types[nums]++;//该类型的手机加1台
        }
        sort(types,types.length);

        int typeNum = 0;//有几种手机
        for (int i = 0; i < types.length; i++) {
            if(types[i]!=0){
                //System.out.println(types[i]);
                typeNum++;
            }
        }
        int k = sc.nextInt();//需要减少的配额

        int r = 0;
        for (int i = 0; i < typeNum; i++) {
            if(types[i]>1){
                r += types[i]-1;
            }
        }
        if(k<=r){
            System.out.println(typeNum);
        }else{
            System.out.println(r-typeNum);
        }

    }

    public static int[] sort(int[] arr,int len){
        int temp;
        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-1;j++){
                if(arr[j]<arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1]= arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

}
