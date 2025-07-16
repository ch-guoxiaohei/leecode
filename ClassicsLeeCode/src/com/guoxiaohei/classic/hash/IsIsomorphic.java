package com.guoxiaohei.classic.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * <p>
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 * <a href="https://leetcode.cn/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class IsIsomorphic {

    public static void main(String[] args) {
        System.out.println(isIsomorphic2("13", "42"));
    }


    /**
     * 维护两个Hash 表， 分别存储 s 和 t 中字符的映射关系
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> st = new HashMap<>();
        Map<Character, Character> ts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i), y = t.charAt(i);
            // 如果 x 已经被映射到了别的字符，并且不等于y，或者 y 已经被映射到了别的字符，并且不等于x，那么返回false
            // 说明存在不同的映射关系
            if (st.containsKey(x) && st.get(x) != y || ts.containsKey(y) && ts.get(y) != x) {
                return false;
            }
            st.put(x, y);
            ts.put(y, x);
        }
        return true;
    }

    /**
     * 维护两个Hash 表， 分别存储 s 和 t 中字符的映射关系
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic2(String s, String t) {
        char[] sChars = new char[128];
        char[] tChars = new char[128];
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i), y = t.charAt(i);
            // 如果 x 已经被映射到了别的字符，并且不等于y，或者 y 已经被映射到了别的字符，并且不等于x，那么返回false
            // 说明存在不同的映射关系
            if (sChars[x] != 0 && sChars[x] != y || tChars[y] != 0 && tChars[y] != x) {
                return false;
            }
            sChars[x] = y;
            tChars[y] = x;
        }
        return true;
    }
}
