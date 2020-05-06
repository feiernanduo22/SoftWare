package com.luogu;
import	java.util.Scanner;

import java.util.Scanner;

/**
 * P1091 class
 *
 * @auther Yvqanlee
 * @data 2020/4/20 21:15
 */
public class P1091 {
    static int N, Answer;
    static int[] g = new int[105];
    static int[] f = new int[105];
    static int[] a = new int[105];
    static int[] s = new int[105];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Answer = 0;
        for(int i=1;i<=N;i++){
            a[i] = sc.nextInt();
            f[i] = 1;
            g[i] = 1;
        }
        a[N+1] = 0;
        for(int i=2;i<=N;i++){
            for(int j=1;j<i;j++){
                if(a[i] > a[j] && g[i] <= g[j]+1){
                    g[i] = g[j] + 1;
                }
            }
        }
        for(int i=N-1;i>=1;i--){
            for(int j=i+1;j<=N;j++){
                if(a[i] > a[j] && f[i] <= f[j]+1){
                    f[i] = f[j]+1;
                }
            }
        }
        for(int i=1;i<=N;i++){
            s[i] = f[i] + g[i] -1;
            if(s[i] > Answer){
                Answer = s[i];
            }
        }
        System.out.println(N-Answer);
    }
}
