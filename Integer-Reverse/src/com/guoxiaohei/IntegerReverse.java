package com.guoxiaohei;

/**
 *
 * to see https://leetcode-cn.com/problems/reverse-integer/
 * Description:
 * @author guoyupeng [2019/3/28]
 */
public class IntegerReverse {

    private static int max = (2 << 30) - 1;

    private static int min = -2 << 30;

    public static void main(String[] args) {

    }

    /**
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     * 整数反转
     * @param target 目标整数
     * @return
     */
    public static int reverse(int target) {
        // 需要考虑边界问题
        int reverse = 0;
        if (target > max || target < min) {
            return reverse;
        }
        if (target == 0) {
            return 0;
        }

        if (target < 0) {
            target = Math.abs(target);
            reverse = rev(target, reverse);
            return -reverse;
        } else {
            reverse = rev(target, reverse);
            return -reverse;
        }
    }

    private static int rev(int target, int reverse) {
        int temp = target;
        while (temp > 0) {
            reverse = 10 * reverse + temp % 10;
            temp /= 10;
        }
        return reverse;
    }
}
