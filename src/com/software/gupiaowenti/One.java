package com.software.gupiaowenti;
/**
 * K=1  止可买卖一次
 */

/**
 * One class
 *
 * @auther Yvqanlee
 * @data 2019/9/16 20:47
 */
public class One {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(getNum(arr));
    }

    public static int getNum(int[] price){
        if (price.length == 0){
            return 0;
        }
        int n = price.length;
        int dp[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0){
                dp[i][0] = 0;
                /**
                 * dp[0][0]
                 * = max(dp[-1][0], dp[-1][1] + price[i])
                 * = max(0, -infinity + price[i])
                 * = 0;
                 */
                dp[i][1] = -price[i];
                /**
                 * dp[i][1]
                 * = max(dp[-1][1], dp[-1][0] - price[i])
                 * = max(-infinity, 0 - price[i])
                 * = -price[i]
                 */
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + price[i]);
            //注意此处
            dp[i][1] = Math.max(dp[i-1][1], - price[i]);
        }
        return dp[n-1][0];
    }
}
