package com.software.dongtaiguihua;

/**
 * ZuiXiaoLuJingHe class
 *
 * @auther Yvqanlee
 * @data 2019/10/8 19:53
 */

/**
 * 从左上到右下，求出路径上的数字总和最小
 * 1,3,1
 * 1,5,1
 * 4,2,1
 */
public class ZuiXiaoLuJingHe {
    public static void main(String[] args) {
        int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        int row = arr.length;
        int col = arr[0].length;
        int[][] dp = new int[row][col];

        for (int i=row-1;i>=0; i--){
            for(int j=col-1;j>=0; j--){
                if(i != row-1 && j != col-1){
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + arr[i][j];
                }else if(i == row-1 && j != col - 1){
                    dp[i][j] = dp[i][j+1] + arr[i][j];
                }else if(i != row-1 && j == col-1){
                    dp[i][j] = dp[i+1][j] + arr[i][j];
                }else{
                    dp[i][j] = arr[i][j];
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
