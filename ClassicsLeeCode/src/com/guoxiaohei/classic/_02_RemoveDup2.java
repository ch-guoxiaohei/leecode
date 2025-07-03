package com.guoxiaohei.classic;

import java.util.Map;
import java.util.TreeMap;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class _02_RemoveDup2 {


    public static void main(String[] args) {
//        int i = removeDuplicates(new int[]{1, 1, 1, 1});
//        int i = removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 1, 1, 2});
//        int i = removeDuplicates2(new int[]{1, 2});
        int i = removeDuplicates2(new int[]{1});
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int repeatCount = 0;
        int newArrayIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[newArrayIndex]) {
                newArrayIndex++;
                nums[newArrayIndex] = nums[i];
                repeatCount = 0;
            } else {
                repeatCount = repeatCount + 1;
                if (repeatCount < 2) {
                    newArrayIndex++;
                    nums[newArrayIndex] = nums[i];
                }
            }
        }
        return newArrayIndex + 1;
    }


    /**
     * 双指针解题法
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int newArrayIndex = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[newArrayIndex - 2]) {
                nums[newArrayIndex++] = nums[i];
            }
        }
        return newArrayIndex;
    }
}
