package com.guoxiaohei.classic;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 * <a href="https://leetcode.cn/problems/roman-to-integer/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class _11_RomToInt {

    private static HashMap<String, Integer> MAP = new HashMap<>();

    static {
        MAP.put("I", 1);
        MAP.put("V", 5);
        MAP.put("X", 10);
        MAP.put("L", 50);
        MAP.put("C", 100);
        MAP.put("D", 500);
        MAP.put("M", 1000);
    }


    public static void main(String[] args) {
        System.out.println(romanToIntEfficient("MCMXCIV"));

    }

    /**
     * 上面的代码性能更好主要有以下几个原因：
     * <p>
     * 字符串处理方式不同：
     * <p>
     * 第一种直接使用 charAt(i) 获取字符，这是O(1)操作
     * 第二种使用 split("") 会创建新的字符串数组，涉及内存分配和拷贝
     * 内存开销：
     * <p>
     * 第一种方式只需要遍历原始字符串
     * 第二种方式需要额外存储分割后的字符串数组，增加了内存使用
     * 字符比较效率：
     * <p>
     * 第一种直接比较字符（基本类型）
     * 第二种比较的是字符串对象（引用类型），需要额外的字符串比较开销
     * 方法调用开销：
     * <p>
     * symbolValues.get(s.charAt(i)) 比 MAP.get(split[i]) 少了一次数组访问和字符串创建
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        String[] split = s.split("");
        int result = 0;
        for (int i = 0; i < split.length; i++) {
            String charStr = split[i];
            Integer num = MAP.get(charStr);
            if (i + 1 < split.length && num < MAP.get(split[i + 1])) {
                result -= num;
            } else {
                result += num;
            }
        }
        return result;
    }


    public static int romanToIntEfficient(String s) {
        Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            // 左面的数字小于右边的数字，那么累计的num就取反
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}
