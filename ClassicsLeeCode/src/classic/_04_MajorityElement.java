package classic;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <a href="https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150">169. 多数元素</a>
 */
public class _04_MajorityElement {

    public static void main(String[] args) {

        System.out.println(majorityElement(new int[]{1, 1, 2, 2, 2}));
    }


    /**
     * 利用map 计算每一个数字的count数，最后计算count数最大的key ，比较笨
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int majorityElementSize = nums.length / 2 + 1;
        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            Integer value = integerIntegerEntry.getValue();
            Integer key = integerIntegerEntry.getKey();
            if (value >= majorityElementSize) {
                return key;
            }
        }
        return nums[0];
    }


    /**
     * 有解算法:投票算法 | Boyer-Moore BM算法
     * <p>
     * 投票算法（Voting Algorithm）是一种用于在数据流或数组中高效找出出现次数超过一半的主要元素的算法，也称为 Boyer-Moore 多数投票算法。它的核心思想是通过 "抵消" 策略来减少计算量，时间复杂度为 O(n)，空间复杂度为 O(1)。
     * <p>
     * 算法原理
     * 初始化：选择第一个元素作为候选（candidate），并设置计数器 count = 1。
     * 遍历数组：
     * 如果当前元素等于 candidate，则 count++。
     * 否则 count--。
     * 如果 count == 0，则更换 candidate 为当前元素，并重置 count = 1。
     * 验证（可选）：遍历结束后，检查 candidate 是否真的超过半数（如果题目保证存在多数元素，可以省略）。
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = nums[0];

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}

