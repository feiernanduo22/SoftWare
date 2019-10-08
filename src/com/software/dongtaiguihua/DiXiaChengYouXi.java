package com.software.dongtaiguihua;
/**
 * 力扣
 */

/**
 * DiXiaChengYouXi class
 *
 * @auther Yvqanlee
 * @data 2019/9/24 21:31
 */
public class DiXiaChengYouXi {
    static int[][] arr = {{-2,-3,3},
                          {-5,-10,1},
                          {10,30,-5}};

    public static void main(String[] args) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        int value = dsf(m, n, dp);
        System.out.println(value);

    }

    private static int dsf(int m,int n,int[][] dp){
        for (int i=m-1;i>=0;i--){
            for (int j=n-1;j>=0;j--){
                if(i == m - 1 && j == n - 1){
                    dp[i][j] = Math.max(0, -arr[i][j]);
                }else if (i == m - 1 && j != n - 1){
                    dp[i][j] = Math.max(0, dp[i][j+1] - arr[i][j]);
                }else if(i != m - 1 && j == n - 1){
                    dp[i][j] = Math.max(0, dp[i+1][j] - arr [i] [j]);
                }else {
                    dp [i] [j] = Math.max(0, Math.min(dp[i+1][j], dp[i][j+1]) - arr[i][j]);
                }
            }
        }
        return dp[0][0] + 1;
    }
}
