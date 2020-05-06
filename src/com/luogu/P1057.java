package com.luogu;

import java.util.Scanner;

/**
 * P1057 class
 * DP
 * @auther Yvqanlee
 * @data 2020/4/20 20:56
 */
public class P1057 {
    static int N, M;
    static int[][] DP;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        DP = new int[M+1][N+1];
        //当事人开始为1
        //次数作为横坐标，人数作为纵坐标
        DP[0][1] = 1;
        //循环横坐标
        for(int i=1;i<=M;i++){
            //循环每个人
            for(int j=1;j<=N;j++){
                //如果为第一个人
                if(j == 1){
                    //等于右边的人+最后一个人
                    DP[i][j] = DP[i-1][2] + DP[i-1][N];
                    //如果最后一个人
                }else if(j == N){
                    //等于第一个人+左边的人
                    DP[i][j] = DP[i-1][1] + DP[i-1][N-1];
                }else{
                    //否则等于左边的人+右边的人
                    DP[i][j] = DP[i-1][j-1] + DP[i-1][j+1];
                }
            }
        }
        System.out.println(DP[M][1]);
    }
}
