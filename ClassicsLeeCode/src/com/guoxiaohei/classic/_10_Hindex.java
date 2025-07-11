package com.guoxiaohei.classic;

import java.util.Arrays;

/**
 * H 指数
 * <p>
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * <p>
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且 至少 有 h 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 * <p>
 * <a href="https://leetcode.cn/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * <p>
 * 示例 1：
 * <p>
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 * 由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 */
public class _10_Hindex {

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{1, 1, 1, 2, 3, 3}));
    }

    /**
     * 最大引用指数区间在0-citations.length之间.
     * h 篇论文，每篇论文被引用次数大于等于 h 。
     * <p>
     * 至少有1篇论文的引用次数>=1
     * 至少有2篇论文的引用次数>=2
     * 至少有3篇论文的引用次数>=3
     *
     * @param citations
     * @return
     */
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

}
