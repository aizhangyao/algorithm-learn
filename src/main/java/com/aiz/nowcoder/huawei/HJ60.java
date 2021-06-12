package com.aiz.nowcoder.huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.nowcoder.com/practice/f8538f9ae3f1484fb137789dec6eedb9?tpId=37&tags=&title=&diffculty=0&judgeStatus=0&rp=1
 */
public class HJ60 {

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while((str = bf.readLine()) != null){
            int num = Integer.parseInt(str.trim());
            int chaMin = Integer.MAX_VALUE;//最小的差值
            int a = 0;//其中一个素数
            //找出所有小于num的素数
            for (int i = 0; i <= num/2; i++) {
                if(isPrime(i)&&isPrime(num-i)){
                    if(num-2*i < chaMin){
                        a = i;
                    }
                }
            }
            System.out.println(a);
            System.out.println(num-a);
        }
    }


//    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String str = "";
//        while((str = bf.readLine()) != null){
//            int num = Integer.parseInt(str.trim());
//            for(int m = num/2;num >= 2; m--){
//                if(isPrime(m) && isPrime(num - m)){
//                    System.out.println(m);
//                    System.out.println(num - m);
//                    break;
//                }
//            }
//        }
//    }



    static boolean isPrime(int n){
        if(n==1)
            return false;
        for(int i=2;i<n/2;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

}
