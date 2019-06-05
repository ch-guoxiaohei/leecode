package com.guoxiaohei;

/**
 * Description: 最大公共後綴：@see https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author guoyupeng [2019/4/28]
 */
public class MaxCommonPrefix {

    public static void main(String[] args) {
        String[] aaa = { "flower", "flow", "flight" };
        String[] ccc = { "floghtffff", "flogwer", "floghtffff" };
        String[] bb = { "dog", "racecar", "car" };
        String[] dd = { "ddd", "" };
        String[] eee = { "c", "acc", "ccc" };
        String[] fff = { "a", "ab" };
        System.out.println(findMaxCommonPrefix(null));
        System.out.println(findMaxCommonPrefix(aaa));
        System.out.println(findMaxCommonPrefix(bb));
        System.out.println(findMaxCommonPrefix(ccc));
        System.out.println(findMaxCommonPrefix(dd));
        System.out.println(findMaxCommonPrefix(eee));
        System.out.println(findMaxCommonPrefix(fff));
    }

    /**
     * 数来查找字符串数组中的最长公共前缀。
     * @param strs 目標數組
     * @return
     */
    private static String findMaxCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

}
