package com.software.gupiaowenti;
/**
 * K = +infinity
 */

/**
 * Two class
 *
 * @auther Yvqanlee
 * @data 2019/9/16 21:06
 */
public class Two {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(getNum(arr));
    }

    public static int getNum(int[] prices){
        if (prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int dp[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0){
                dp[i][0] = 0;
                dp[i][1] = -prices [i];
                continue;
            }
            dp[i][0] = Math.max(dp [i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp [n-1] [0];
    }
}
