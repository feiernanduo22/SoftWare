package com.software.gupiaowenti;
/**
 * K无穷大，每次交易后间隔一天
 */

/**
 * Three class
 *
 * @auther Yvqanlee
 * @data 2019/9/16 21:11
 */
public class Three {
    private static int getNum(int[] prices){
        if (prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0){
                dp[i][0] = 0;
                dp[i][1] = -prices [i];
                continue;
            }
            dp [i] [0] = Math.max(dp [i-1][0], dp [i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
        }
        return dp [n-1] [0];
    }
}
