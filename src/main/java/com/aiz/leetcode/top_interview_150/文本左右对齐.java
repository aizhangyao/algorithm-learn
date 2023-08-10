package com.aiz.leetcode.top_interview_150;

import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ZhangYao
 * @className 文本左右对齐
 * @description https://leetcode.cn/problems/text-justification/
 * @date Create in 23:17 2023/8/8
 */
public class 文本左右对齐 {

    /**
     * 贪心算法：也就是说，尽可能多地往每行中放置单词。必要时可用空格' '填充，使得每行恰好有maxWidth个字符。
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        // 行 单词个数
        int wordCount = 0;
        // 行 单词的总长度
        int wordSize = 0;
        int index = 0;
        while (index <= words.length - 1) {
            int length = words[index].length();
            // length 当前单词长度
            // wordSize 当前行单词总长度
            // wordCount 需要空格的长度
            if (length + wordSize + wordCount <= maxWidth) {
                // 当前单词还能放下
                wordSize += length;
                wordCount++;
                index++;
            }
            // 当前单词放不下了
            else {
                StringBuilder sb = new StringBuilder();
                // 单词之间的间隔
                int allInterval = maxWidth - wordSize;
                // 基础间隔 & 额外间隔
                int interval = wordCount == 1 ? allInterval : allInterval / (wordCount - 1);
                int extraInterval = wordCount == 1 ? 0 : allInterval % (wordCount - 1);
                for (int i = 0; i < wordCount; i++) {
                    sb.append(words[index - wordCount + i]);
                    // 行最后一个单词
                    if (i == wordCount - 1) {
                        // 行最后一个单词，且这行只有一个单词需要填充最后的空格
                        if (wordCount == 1) {
                            for (int j = 0; j < maxWidth - wordSize; j++) {
                                sb.append(' ');
                            }
                        }
                    }else {
                        for (int j = 0; j < interval; j++) {
                            sb.append(' ');
                        }
                        if (extraInterval > i) {
                            sb.append(' ');
                        }
                    }
                }
                System.out.println(sb);
                result.add(sb.toString());
                wordCount = 0;
                wordSize = 0;
            }
        }

        //最后一行
        StringBuilder sb = new StringBuilder();
        // 最后需要补齐的长度
        int needFilledSize = maxWidth - wordSize - wordCount + 1;
        while (wordCount >= 1) {
            // 最后一个单词
            if (wordCount == 1) {
                sb.append(words[words.length - 1]);
                // 补齐空格
                for (int i = 0; i < needFilledSize; i++) {
                    sb.append(' ');
                }
            }
            // 非第一个单词
            else {
                sb.append(words[words.length - wordCount]);
                sb.append(' ');
            }
            wordCount--;
        }
        if (sb.length() > 0) {
            result.add(sb.toString());
        }
        System.out.println(sb);
        return result;
    }

    @Test
    public void test() {
        文本左右对齐 clazz = new 文本左右对齐();
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        List<String> strings = clazz.fullJustify(words, 16);
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("This    is    an");
        expectedResult.add("example  of text");
        expectedResult.add("justification.  ");
        BaseTool.equals(strings, expectedResult);
    }

    @Test
    public void test2() {
        文本左右对齐 clazz = new 文本左右对齐();
        String[] words = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};
        List<String> strings = clazz.fullJustify(words, 16);
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("What   must   be");
        expectedResult.add("acknowledgment  ");
        expectedResult.add("shall be        ");
        BaseTool.equals(strings, expectedResult);
    }

    @Test
    public void test3() {
        文本左右对齐 clazz = new 文本左右对齐();
        String[] words = new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        List<String> strings = clazz.fullJustify(words, 20);
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("Science  is  what we");
        expectedResult.add("understand      well");
        expectedResult.add("enough to explain to");
        expectedResult.add("a  computer.  Art is");
        expectedResult.add("everything  else  we");
        expectedResult.add("do                  ");
        BaseTool.equals(strings, expectedResult);
    }
}
