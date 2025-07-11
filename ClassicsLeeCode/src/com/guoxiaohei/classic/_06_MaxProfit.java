package com.guoxiaohei.classic;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class _06_MaxProfit {

    public static void main(String[] args) {
        int i = maxProfit2(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
    }


    /**
     * 暴力解法，但是超出了时间限制
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > profit) {
                    profit = prices[j] - prices[i];
                }
            }
        }
        return profit;
    }


    /**
     * 遍历一遍，当前的prices-前面最小的prices。记录下收益最大的值
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int min = prices[0];
        int maxProfile = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                continue;
            }
            int currentProfile = prices[i] - min;
            if (currentProfile > maxProfile) {
                maxProfile = currentProfile;
            }

        }
        return maxProfile;
    }

}
