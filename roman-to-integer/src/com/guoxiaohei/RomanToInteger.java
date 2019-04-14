package com.guoxiaohei;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: RomanToInteger
 * 罗马文字转整数:https://leetcode-cn.com/problems/roman-to-integer/
 *
 * @author guoyupeng
 * @Date 2019/4/14 19:17
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInteger("IV"));
        System.out.println(romanToInteger("IX"));
        System.out.println(romanToInteger("LVIII"));
        System.out.println(romanToInteger("MCMXCIV"));
    }


    public static Integer romanToInteger(String roman) {
        Map<String, Integer> maps = new HashMap<>(7);
        maps.put("I", 1);
        maps.put("V", 5);
        maps.put("X", 10);
        maps.put("L", 50);
        maps.put("C", 100);
        maps.put("D", 500);
        maps.put("M", 1000);
        String[] romans = roman.split("");
        int result = maps.get(romans[0]);
        for (int i = 1; i < romans.length; i++) {
            if ("V".equals(romans[i]) && "I".equals(romans[i - 1]) || "X".equals(romans[i]) && "I"
                    .equals(romans[i - 1])) {
                result = result - 1 * 2;
            }
            if ("L".equals(romans[i]) && "X".equals(romans[i - 1]) || "C".equals(romans[i]) && "X"
                    .equals(romans[i - 1])) {
                result = result - 10 * 2;
            }
            if ("D".equals(romans[i]) && "C".equals(romans[i - 1]) || "C".equals(romans[i]) && "X"
                    .equals(romans[i - 1])) {
                result = result - 100 * 2;
            }
            result += maps.get(romans[i]);
        }
        return result;
    }
}
