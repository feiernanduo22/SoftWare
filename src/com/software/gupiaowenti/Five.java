package com.software.gupiaowenti;
/**
 * K = 2
 */

/**
 * Five class
 *
 * @auther Yvqanlee
 * @data 2019/9/16 21:18
 */
public class Five {
    public static void main(String[] args) {
        int[] arr = {3,3,5,0,0,3,1,4};
        System.out.println(getNum(arr));
    }

    private static int getNum(int[] prices){
        int n = prices.length;
        if (n == 0){
            return 0;
        }
        int[][][] dp = new int[n][3][2];
        for (int i=0;i<n;i++){
            for (int j=2;j>=1;j--){
                if (i == 0){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }
        return dp [n-1][2][0];
    }
}
