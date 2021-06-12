package com.aiz.nowcoder.huawei.exam202009;


import java.util.Scanner;
import java.util.TreeMap;

/**
01202021,75;01201033,95;01202008,80;01203006,90;01203088,100
01202008,70;01203088,85;01202111,80;01202021,75;01201100,88
 */
public class T3 {
    //找出同时选修两门课程
    //先按照班级进行划分 班级编号小的先输出
    //每个班级按照两门选修课成绩降序排序
    //成绩相同按照学号升序

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String,Student> map = new TreeMap();

        //初始化
        for (int i = 0; i < 2; i++) {
            String[] firsts = sc.nextLine().split(";");
            for (String first : firsts) {
                String[] str = first.split(",");
                String stuNo = str[0];
                int grades = Integer.parseInt(str[1]);
                if(!map.containsKey(stuNo)){
                    Student stu = new Student(stuNo,grades);
                    stu.addGrades(grades);
                    map.put(stuNo,stu);
                }else{
                    Student stu = map.get(stuNo);
                    stu.addNum();
                    stu.addGrades(grades);
                    map.put(stuNo,stu);
                }
            }
        }

        int renshu = 0;
        int i = 0;
        String banjiNo = "";
        for (String s : map.keySet()) {
            String key = s;
            Student stu = map.get(s);
            if(stu.getGrades()==2){
                if(i==0){
                    banjiNo = stu.getBanjiNo();i=1;
                    System.out.println(stu.getBanjiNo());
                    System.out.println(stu.getStuNo());
                }else if(banjiNo.equals(stu.getBanjiNo())){
                    System.out.println(";"+stu.getStuNo());
                }
                renshu++;
            }
        }
        if(renshu==0){
            System.out.println("NULL");
        }
    }

    public static class Student implements Comparable<Student>{
        private String stuNo;//学生8位学号
        private String stuNoT;//学生3位学号
        private String banjiNo;//班级编号(学号前五位)
        private Integer num = 0;//选课数量
        private Integer grades = 1;//所选修课的分数

        public Student(String stuNo,Integer grades){
            this.stuNo = stuNo;
            this.stuNo = stuNo;
            this.grades = grades;
            this.stuNoT = stuNo.substring(0,3);
            this.banjiNo = stuNo.substring(3,8);
        }

        public void addNum(){
            this.num = this.num +1;
        }

        public void addGrades(int grades){
            this.grades = grades +1;
        }

        public String getStuNo() {
            return stuNo;
        }

        public void setStuNo(String stuNo) {
            this.stuNo = stuNo;
        }

        public String getStuNoT() {
            return stuNoT;
        }

        public void setStuNoT(String stuNoT) {
            this.stuNoT = stuNoT;
        }

        public String getBanjiNo() {
            return banjiNo;
        }

        public void setBanjiNo(String banjiNo) {
            this.banjiNo = banjiNo;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }

        public Integer getGrades() {
            return grades;
        }

        public void setGrades(Integer grades) {
            this.grades = grades;
        }

        @Override
        public int compareTo(Student o) {
            if(this.banjiNo.compareTo(o.banjiNo)!=0){
                if(this.grades.compareTo(o.grades)!=0){
                    if(this.stuNoT.compareTo(o.stuNoT)!=0){
                        return 0;
                    }else{
                        return this.stuNoT.compareTo(o.stuNoT);
                    }
                }else{
                    return this.grades.compareTo(o.grades);
                }
            }else{
                return this.banjiNo.compareTo(o.banjiNo);
            }
        }

        @Override
        public String toString() {
            return "Student{" +
                    "stuNo='" + stuNo + '\'' +
                    ", stuNoT='" + stuNoT + '\'' +
                    ", banjiNo='" + banjiNo + '\'' +
                    ", num=" + num +
                    ", grades=" + grades +
                    '}';
        }
    }
}
