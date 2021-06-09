package com.aiz.nowcoder.huawei.exam.school2016;

import java.util.Scanner;
import java.util.Map;
import java.util.LinkedHashMap;

public class T_2016_2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> map = new LinkedHashMap<>();
        while(sc.hasNext()){
            String file = sc.next();
            int lineCount = sc.nextInt();
            String fileName = file.substring(file.lastIndexOf("\\")+1,file.length());
            if(fileName.length()>16){
                fileName = fileName.substring(fileName.length()-16);

            }
            String key = fileName+" "+lineCount;
            int value =1;
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,value);
            }
        }
        int count=0;
        for(String filename:map.keySet()){
            count++;
            if(count>map.keySet().size()-8){
                System.out.println(filename+" "+map.get(filename));
            }
        }
    }
}