package com.guoxiaohei.classic;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * <a href="https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class _14_FindFirstMatchIndex {

    public static void main(String[] args) {

    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr2(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        char c = needle.charAt(0);
        int[] matchStartIndex = new int[haystack.length() + needle.length()];
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == c) {
                matchStartIndex[i] = i;
            }
        }
        for (int startIndex : matchStartIndex) {
            if (needle.length() > haystack.length() - startIndex) {
                continue;
            }
            String substring = haystack.substring(startIndex, startIndex + needle.length());
            if (substring.equals(needle)) {
                return startIndex;
            }
        }
        return -1;
    }
}
