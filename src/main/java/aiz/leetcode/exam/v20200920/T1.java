package com.aiz.leetcode.exam.v20200920;

import java.util.ArrayList;
import java.util.List;

public class T1 {

    public static void main(String[] args) {

        System.out.println(reorderSpaces("  this   is  a sentence "));
        System.out.println(reorderSpaces(" practice   makes   perfect"));
        System.out.println(reorderSpaces("hello   world"));
        System.out.println(reorderSpaces("  walks  udp package   into  bar a"));
        System.out.println(reorderSpaces("a"));
        System.out.println(reorderSpaces("a  "));
    }


    public static String reorderSpaces(String text){
        String result = "";
        int spaceCount = 0;//空格个数
        int wordCount = 0;
        char[] chs = text.toCharArray();
        List wordList = new ArrayList();
        int i = 0;
        while (i < chs.length){
            if(chs[i] != ' '){
                String subStr = chs[i]+"";
                i++;
                wordCount++;
                while (i < chs.length && chs[i] != ' '){
                    subStr += chs[i];
                    i++;
                }
                wordList.add(subStr);
            }else {
                spaceCount++;
                i++;
            }
        }
        int preSpaceCount = 0;
        int lastSpaceCount = 0;
        if(spaceCount != 0){
            if(wordCount != 1){
                preSpaceCount = spaceCount/(wordCount - 1);
                lastSpaceCount = spaceCount%(wordCount - 1);
            }else{
                lastSpaceCount = spaceCount;
            }
        }

        String preStr = "";
        for (int q = 0; q < preSpaceCount; q++) {
            preStr += " ";
        }
        String lastStr = "";
        for (int q = 0; q < lastSpaceCount; q++) {
            lastStr += " ";
        }
        for (int j = 0; j < wordList.size(); j++) {
            if(j == wordList.size() -1){
                result += wordList.get(j)+lastStr;
                break;
            }
            result += wordList.get(j)+preStr;
        }

        return result;
    }

}
