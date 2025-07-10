package com.guoxiaohei.classic;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <a href="https://leetcode.cn/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class _012_LastWordIndex {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord2("luffy is still joyboy"));
        System.out.println(lengthOfLastWord2("a"));
    }

    /**
     * 结果OK，就是性能没有直接操作char好
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        String[] split = s.trim().split(" ");
        return split[split.length - 1].length();
    }

    /**
     * leecode执行性能好，因为不用额外的为分割后的string 分配内存空间
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord2(String s) {
        int lastWorkLen = 0;
        String trim = s.trim();
        int len = trim.length();
        for (int i = len - 1; i >= 0; i--) {
            char c = trim.charAt(i);
            if (c != ' ') {
                lastWorkLen++;
            } else {
                break;
            }
        }
        return lastWorkLen;
    }

}
