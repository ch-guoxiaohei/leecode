package com.guoxiaohei.classic.hash;

import java.util.*;

/**
 * 290. 单词规律
 * <p>
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * <a href="https://leetcode.cn/problems/word-pattern/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class WordPattern {

    public static void main(String[] args) {

        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));


    }

    public static boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (split.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        // 相互映射
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = split[i];
            map.put(c, word);
            map2.put(word, c);
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = split[i];
            if (!word.equals(map.get(c)) || c != map2.get(word)) {
                return false;
            }
        }
        return true;
    }
}
