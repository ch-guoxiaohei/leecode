package com.guoxiaohei;

/**
 * to see https://leetcode-cn.com/problems/reverse-integer/ Description:
 *
 * @author guoyupeng [2019/3/28]
 */
public class IntegerReverse {


  public static void main(String[] args) {
    System.out.println(reverse(123));
    System.out.println(reverse(1534236469));
  }

  /**
   * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 整数反转
   *
   * @param target 目标整数
   */
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
