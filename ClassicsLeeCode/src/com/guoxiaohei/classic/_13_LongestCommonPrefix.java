package com.guoxiaohei.classic;

/**
 * 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * <a href="https://leetcode.cn/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * @author guoxiaohei
 * @date 2023/1/12 10:59
 */
public class _13_LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));

    }

    /**
     * 暴力破解
     * <p>
     * 使用第一个数组的每个最大前缀分别便利比较,只有有一个不匹配则跳出循环,因为最长前缀是从第一个开始的,所以每次匹配成功后,都更新最长前缀的下标
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String str = strs[0];
        int endIndex = 0;
        for (int i = 1; i <= str.length(); i++) {
            String substring = str.substring(0, i);
            boolean containsMaxIndex = true;
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(substring)) {
                    containsMaxIndex = false;
                    break;
                }
            }
            if (containsMaxIndex) {
                endIndex = i;
            }
        }
        return str.substring(0, endIndex);
    }

}
