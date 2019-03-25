package com.guoxiaohei;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * to see https://leetcode-cn.com/articles/two-sum/
 */
public class SumsOfTwoNumbers {

  public static void main(String[] args) {
    int[] sums = {1, 2, 3, 5};
    int target = 4;
    int[] sumsOfTwoNumsIndexs = getSumsOfTwoNumsIndexs(sums, target);
    System.out.println(sumsOfTwoNumsIndexs);
  }

  private static int[] getSumsOfTwoNumsIndexs(int[] sums, int target) {
    int len = sums.length;
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < i + 1; j++) {
        if (sums[i] + sums[j] == target && i != j) {
          return new int[]{i, j};
        }
      }
    }
    return null;
  }

}
