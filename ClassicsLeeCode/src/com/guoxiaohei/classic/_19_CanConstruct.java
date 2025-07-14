package com.guoxiaohei.classic;

import java.util.HashMap;
import java.util.Map;

/**
 * 赎金信
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 383. 赎金信
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 * <a href="https://leetcode.cn/problems/ransom-note/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 */
public class _19_CanConstruct {

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "ab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        magazine.chars().forEach(c -> {
            Integer integer = map.getOrDefault((char) c, 0);
            map.put((char) c, integer + 1);
        });
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            Integer integer = map.getOrDefault(c, 0);
            if (integer <= 0) {
                return false;
            } else {
                map.put(c, integer - 1);
            }
        }
        return true;
    }


    /**
     * 官方解法+解释
     * 在这段代码中，char - 'a' 的作用是将字符映射到一个数组的索引（0到25），以便统计每个字母出现的次数。这里详细解释一下：
     * <p>
     * 1. 为什么需要 c - 'a'？
     * 在Java中，char 类型实际上是整数（Unicode码点）。字母 'a' 到 'z' 的Unicode码点是连续的（'a' = 97, 'b' = 98, ..., 'z' = 122）。
     * <p>
     * 因此，c - 'a' 的计算结果是：
     * <p>
     * 如果 c == 'a'，则 'a' - 'a' = 0
     * <p>
     * 如果 c == 'b'，则 'b' - 'a' = 1
     * <p>
     * ...
     * <p>
     * 如果 c == 'z'，则 'z' - 'a' = 25
     * <p>
     * 这样，record 数组的索引 0 到 25 就分别对应字母 'a' 到 'z'。
     * <p>
     * 2. 这段代码的作用
     * 这是一个经典的 字母频率统计 问题，用于检查 ransomNote 是否能由 magazine 的字母组成。
     * <p>
     * 步骤：
     * <p>
     * 初始化一个长度为26的数组 record，用于统计每个字母的出现次数。
     * <p>
     * 遍历 magazine 的每个字符 c，并在 record 中对应的位置（c - 'a'）增加计数。
     * <p>
     * 遍历 ransomNote 的每个字符 c，并在 record 中对应的位置（c - 'a'）减少计数。
     * <p>
     * 最后检查 record 中是否有负数：
     * <p>
     * 如果有负数，说明 ransomNote 中某个字母的出现次数 > magazine 中的出现次数，无法组成，返回 false。
     * <p>
     * 如果没有负数，说明可以组成，返回 true。
     * <p>
     * 3. 为什么不用 Map 而用数组？
     * 这里用数组（int[26]）而不是 Map<Character, Integer>，是因为：
     * <p>
     * 数组的访问速度更快（O(1)）。
     * <p>
     * 对于固定范围的字符（如小写字母），数组更简洁高效。
     * <p>
     * Map 会有额外的内存开销（哈希表结构）。
     * <p>
     * 4. 类似场景
     * 这种技巧常用于：
     * <p>
     * 统计字母频率（如判断变位词、字母计数等）。
     * <p>
     * 需要高效映射字母到数字的场景（如Trie树、词频统计等）。
     * <p>
     * 总结
     * c - 'a' 是一种巧妙的 字母到索引的映射方式，利用ASCII/Unicode的特性，将 'a'-'z' 转换为 0-25，方便用数组统计字母频率。这是处理小写字母统计问题的常见技巧。
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if (cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
