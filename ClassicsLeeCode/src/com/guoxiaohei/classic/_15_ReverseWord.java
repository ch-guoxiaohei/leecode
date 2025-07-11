package com.guoxiaohei.classic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 * <a href="https://leetcode.cn/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * <p>
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * 示例 3：
 * <p>
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 *
 * @author guoxiaohei
 */
public class _15_ReverseWord {

    public static void main(String[] args) {
        System.out.println(reverseWords("abc ba"));
    }

    public static String reverseWords(String s) {
        String trim = s.trim();
        String[] split = trim.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if ("".equals(split[i])) {
                continue;
            }
            if (i != 0) {
                stringBuilder.append(split[i]).append(" ");
            } else {
                stringBuilder.append(split[i]);
            }
        }
        return stringBuilder.toString();
    }


    public static String reverseWords2(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public static String reverseWords3(String s) {
        // todo other solution
        // 1. 双指针
        // 2. 双端队列
        return "";
    }


}
