package com.guoxiaohei;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: PalindromeNumber 回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 *
 * @author guoyupeng
 * @Date 2019/4/6 9:58
 */
public class PalindromeNumber {

    public static void main(String[] args) {

    }

    /**
     * 判断目标数字是否为回文数，不使用字符串来识别
     * 思路，判断回文数是将数字从左到右变成从右到左来判断是否数字相同，通过观察，如果目标数为-数，则数字肯定不是回文数。
     * 为正数时，利用了上个leecode的整数反转，将数字反转判别数字是否相同，如果相同则为回文数。
     *
     * @param target
     * @return
     */
    public static boolean isPlindrome(int target) {
        if (target > 0) {
            int reverse = reverse(target);
            return reverse == target;
        }
        return false;
    }


    public static boolean isPlindRrome2(int target) {
        return false;
    }


    /**
     * 分解整数按照位数
     *
     * @param target
     * @return
     */
    public static List<Integer> splitNum(int target) {
        List<Integer> split = new ArrayList<>();
        int temp = target;
        while (temp != 0) {
            int number = temp % 10;
            split.add(number);
            temp = temp / 10;
        }
        return split;
    }

    public static int reverse(int target) {
        long reverse = 0;
        while (target != 0) {
            reverse = 10 * reverse + target % 10;
            target /= 10;
        }
        reverse = (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) ? 0 : reverse;
        return (int) reverse;
    }

}
