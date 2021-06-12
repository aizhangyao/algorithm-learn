package com.aiz.nowcoder.huawei.exam.school2016;

import java.util.Scanner;

public class T_2016_1 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        do{
            //System.out.println("分别输入学生的数目N和操作的数目M");
            int N = sc.nextInt();
            if(!(N>0 && N<=30000)){
                return;
            }
            int M = sc.nextInt();
            if(!(M>0 && M<5000)){
                return;
            }
            //System.out.println("依次输入学生的成绩");
            int[] grades = new int[N+1];
            for (int i = 1; i <= N; i++) {
                grades[i] = sc.nextInt();
            }
            //System.out.println("请输入操作命令 ex:（Q，1，2）:");
            for (int i = 0; i < M; i++) {
                char ch = sc.next().charAt(0);
                int A = sc.nextInt();
                int B = sc.nextInt();
                if(ch == 'Q'){
                    if(A > B){
                        int temp = A;
                        A = B;
                        B = temp;
                    }
                    int max = grades[A];
                    for (int j = A+1; j <= B; j++) {
                        if(grades[j] > max){
                            max = grades[j];
                        }
                    }
                    System.out.println(max);
                }else if(ch == 'U'){
                    grades[A] = B;
                }
            }
        }while (sc.hasNext());
        sc.close();
    }

}
