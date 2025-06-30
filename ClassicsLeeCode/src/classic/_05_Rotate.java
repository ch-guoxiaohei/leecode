package classic;


import java.util.Arrays;

/**
 * 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <a href="https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150">轮转数组</a>
 */
public class _05_Rotate {

    public static void main(String[] args) {
        int[] ints = {1, 2};
        rotate(ints, 3);
        System.out.println(Arrays.toString(ints));
    }


    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        // 处理k大于数组长度的情况 ,当k=n时属于无效rotate，因为轮转之后仍然是相同的顺序
        int maxRotateSize = k % n;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, maxRotateSize - 1);
        reverse(nums, maxRotateSize, nums.length - 1);
    }


    public static void reverse(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
