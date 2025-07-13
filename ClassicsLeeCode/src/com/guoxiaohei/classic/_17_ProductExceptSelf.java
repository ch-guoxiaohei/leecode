package com.guoxiaohei.classic;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * <p>
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * <a href="https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class _17_ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ints = productExceptSelf(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 暴力破解，超出时间限制
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    result[i] *= nums[j];
                }
            }
        }
        return result;
    }


    public static int[] productExceptSelf2(int[] nums) {
        // 使用两个数组分别存放 每一个数组的前缀和后缀

        // 画图的话，可以按照当前索引，将数组拆成两个部分，分别计算前缀和后缀的乘积，然后将两个乘积相乘，就是当前索引的结果
        // 比如说 i = 2, 则前缀数组1中存放的是 num[0] * num[1]的阶乘值
        int[] answer = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] right = new int[nums.length];
        prefix[0] = 1;
        right[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            answer[i] = prefix[i] * right[i];
        }

        return answer;
    }
}
