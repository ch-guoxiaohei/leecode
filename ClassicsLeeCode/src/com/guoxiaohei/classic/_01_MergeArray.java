package com.guoxiaohei.classic;

public class _01_MergeArray {

    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     * <p>
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * <p>
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     *
     * @param args https://leetcode.cn/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
     */
    public static void main(String[] args) {

    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int newArrayIndex = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[newArrayIndex] = nums1[index1];
                index1 = index1 - 1;
            } else {
                nums1[newArrayIndex] = nums2[index2];
                index2 = index2 - 1;
            }
            newArrayIndex = newArrayIndex - 1;
        }
        while (index2 >= 0) {
            nums1[newArrayIndex] = nums2[index2];
            index2 -= 1;
            newArrayIndex -= 1;
        }
    }
}
