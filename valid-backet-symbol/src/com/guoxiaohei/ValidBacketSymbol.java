package com.guoxiaohei;

/**
 * Description: 算法有效括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * @author guoyupeng [2019/6/5]
 */
public class ValidBacketSymbol {

    public static void main(String[] args) {

    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        return false;
    }
}
