package com.guoxiaohei.classic;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <a href="https://leetcode.cn/problems/jump-game/solutions/203549/tiao-yue-you-xi-by-leetcode-solution/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class _08_CanJump_ {


    public static void main(String[] args) {
        boolean b = canJump(new int[]{3, 2, 1, 0, 4});
        System.out.println(b);
        System.out.println(canJump(new int[]{2, 3, 1, 2, 4, 2, 3}));
    }

    /**
     * 可达性分析
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int reachIndex = 0;
        boolean canJump = true;
        for (int i = 0; i <= nums.length - 1; i++) {
            if (reachIndex < i) {
                canJump = false;
                break;
            }
            reachIndex = Math.max(reachIndex, i + nums[i]);
        }
        return canJump;
    }


}
