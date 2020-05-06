package com.luogu;

import com.sun.org.apache.xerces.internal.dom.AttrNSImpl;

import java.util.Scanner;

/**
 * P1091 class
 * DP
 * @auther Yvqanlee
 * @data 2020/4/20 21:15
 */
public class P1091_2 {
    static int N, Answer;
    static int[] a = new int[105];
    static int [][] DP = new int[2][105];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Answer = 0;
        a[0] = 0;
        for(int i=1;i<=N;i++){
            a[i] = sc.nextInt();
        }
        //从做到右比较
        for(int i=1;i<=N;i++){
            for(int j=0;j<i;j++){
                //如果右>zuo
                if(a[i] > a[j]){
                    //DP[0][i]表示每个位置可以升序的最大长度
                    DP[0][i] = Math.max(DP[0][i], DP[0][j]+1);
                }
            }
        }
        a[N-1] = 0;
        //从右到左取将序最长
        for(int i=N;i>0;i--){
            for(int j=N+1;j>i;j--){
                if(a[i] > a[j]){
                    DP[1][i] = Math.max(DP[1][i], DP[1][j]+1);
                }
            }
        }
        for(int i=1;i<=N;i++){
            Answer = Math.max(DP[0][i]+DP[1][i]-1, Answer);
        }
        System.out.println(N-Answer);
    }
}
