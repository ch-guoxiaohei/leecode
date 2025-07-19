package com.guoxiaohei.classic.array;

/**
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * <p>
 * <a href="https://leetcode.cn/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class CanCompleteCircuit {

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1}));
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }


    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalNum = 0;
        int curNum = 0;
        int idx = 0;
        for (int i = 0; i < gas.length; i++) {
            curNum += gas[i] - cost[i];
            totalNum += gas[i] - cost[i];
            if (curNum < 0) {
                idx = (i + 1) % gas.length;
                curNum = 0;
            }

        }
        if (totalNum < 0) return -1;
        return idx;
    }
}
