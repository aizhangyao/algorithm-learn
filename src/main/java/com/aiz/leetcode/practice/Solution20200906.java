package com.aiz.leetcode.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Solution20200906
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 21:26 2022/9/6
 * @Version 1.0
 */
public class Solution20200906 {
    static class Demo {
        public Demo(String name, int po) {
            this.name = name;
            this.po = po;
        }

        String name;
        int po;

        public int getPo() {
            return po;
        }

        @Override
        public String toString() {
            return "Demo{" +
                    "name='" + name + '\'' +
                    ", po=" + po +
                    '}';
        }
    }

    public static void main1(String[] args) {
        List<Demo> list2 = new ArrayList<>();
        list2.add(new Demo("2E", 1));
        list2.add(new Demo("2F", 2));
        list2.add(new Demo("2G", 3));
        list2.add(new Demo("2H", 4));
        list2.add(new Demo("2I", 5));
        list2.add(new Demo("2J", 6));
        list2.add(new Demo("2K", 7));
        list2.add(new Demo("2L", 8));
        list2.add(new Demo("2M", 9));
        list2.add(new Demo("2N", 10));


        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            for (int i1 = 0; i1 < list2.size(); i1++) {
                list2.get(i1);
            }
        }
        long time = System.currentTimeMillis()- l1;
        System.out.println("total cost time is " + time);

        long l2 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            Iterator<Demo> iterator = list2.iterator();
            while (iterator.hasNext()){
                iterator.next();
            }
        }
        long time2 = System.currentTimeMillis()- l2;
        System.out.println("total cost time is " + time2);

    }

    public static void main(String[] args) {
        // init
        List<Demo> list1 = new ArrayList<>();
        list1.add(new Demo("1A", 1));
        list1.add(new Demo("1B", 5));
        list1.add(new Demo("1C", 7));
        list1.add(new Demo("1D", 8));
        list1.add(new Demo("1F", 9));
        list1.add(new Demo("1G", 700));

        List<Demo> list2 = new ArrayList<>();
        list2.add(new Demo("2E", 1));
        list2.add(new Demo("2F", 2));
        list2.add(new Demo("2G", 3));
        list2.add(new Demo("2H", 4));
        list2.add(new Demo("2I", 5));
        list2.add(new Demo("2J", 6));
        list2.add(new Demo("2K", 7));
        list2.add(new Demo("2L", 8));
        list2.add(new Demo("2M", 9));
        list2.add(new Demo("2N", 10));

        // merge
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 3000000; i++) {
            List<Demo> list = merge(list1, list2);
            // print
//            for (Demo node : list) {
//                System.out.println(node);
//            }
        }
        long time = System.currentTimeMillis()- l1;
        System.out.println("yao total cost time is " + time);


        // merge
        long l2 = System.currentTimeMillis();
        for (int i = 0; i < 3000000; i++) {
            List<Demo> list = merge1(list1, list2);
        }
        long time2 = System.currentTimeMillis()- l2;
        System.out.println("ban total cost time is " + time2);
    }

    public static List<Demo> merge(List<Demo> list1, List<Demo> list2) {
        List<Demo> list = new LinkedList<>();
        Iterator<Demo> iterator1 = list1.iterator();
        Iterator<Demo> iterator2 = list2.iterator();

        // int time = 1;
        while (iterator1.hasNext() || iterator2.hasNext()) {
            // System.out.println("---------" + time + "---------");
            if (!iterator1.hasNext()) {
                // add all list2 remained
                while (iterator2.hasNext()) {
                    list.add(iterator2.next());
                }
                break;
            }
            if (!iterator2.hasNext()) {
                // add all list1 remained
                while (iterator1.hasNext()) {
                    list.add(iterator1.next());
                }
                break;
            }
            // add list2 item to list
            Demo node1 = iterator1.next();
            int num = node1.po - list.size() - 1;
            for (int i = 0; i < num && iterator2.hasNext(); i++) {
                list.add(iterator2.next());
            }
            // add list1 item to list
            list.add(node1);
//            for (Demo node : list) {
//                System.out.println(node);
//            }
            // time++;
        }
        return list;
    }

    public static List<Demo> merge2(List<Demo> list1, List<Demo> list2) {
        List<Demo> list = new LinkedList<>();
        Iterator<Demo> iterator1 = list1.iterator();
        Iterator<Demo> iterator2 = list2.iterator();

        int time = 1;
        while (iterator1.hasNext() || iterator2.hasNext()) {
            System.out.println("---------" + time + "---------");
            if (!iterator1.hasNext()) {
                // add all list2 remained
                while (iterator2.hasNext()) {
                    list.add(iterator2.next());
                }
                break;
            }
            if (!iterator2.hasNext()) {
                // add all list1 remained
                while (iterator1.hasNext()) {
                    list.add(iterator1.next());
                }
                break;
            }
            // add list2 item to list
            Demo node1 = iterator1.next();
            int num = node1.po - list.size() - 1;
            for (int i = 0; i < num && iterator2.hasNext(); i++) {
                list.add(iterator2.next());
            }
            // add list1 item to list
            list.add(node1);
            for (Demo node : list) {
                System.out.println(node);
            }
            time++;
        }
        return list;
    }

    public static List<Demo> merge1(List<Demo> list, List<Demo> list2) {
        int start = 0;
        int end = 0;
        List<Demo> finalList = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            Demo demo = list.get(i);
            if (demo.getPo() == i + 1) {
                finalList.add(demo);
            } else {
                Demo lastDemo = list.get(i - 1);
                int length = demo.getPo() - lastDemo.getPo();
                end = (start + length) - 1;
                end = Math.min(end, list2.size());
                // System.out.println("start : " + start + ", end: " + end);
                List<Demo> subList = list2.subList(start, end);
                finalList.addAll(subList);
//                for (int j = start; j < end; j++) {
//                    finalList.add(list2.get(j));
//                }
                finalList.add(demo);
                start = end;
            }
        }
        Demo lastDemo = list.get(list.size() - 1);
        if (list2.size() >= lastDemo.getPo()) {
            start = end;
            end = list2.size();
            // System.out.println("!!start : " + start + "end: " + end);
//            List<Demo> subList = list2.subList(start, end);
//            finalList.addAll(subList);
            for (int j = start; j < end; j++) {
                finalList.add(list2.get(j));
            }
        }
        return finalList;
    }


}
