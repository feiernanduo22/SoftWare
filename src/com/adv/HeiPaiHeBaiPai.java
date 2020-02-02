package com.adv;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import	java.util.StringTokenizer;

import java.io.BufferedReader;
import java.util.StringTokenizer;

/**
 * HeiPaiHeBaiPai class
 *
 * @auther Yvqanlee
 * @data 2019/12/20 19:37
 */
public class HeiPaiHeBaiPai {
    /**
     * 黑牌和白牌的数量
     */
    static int B, W, Answer;
    /**
     * 黑牌在前的值
     */
    static int[][] BW;
    /**
     * 白牌在前的值
     */
    static int[][] WB;
    /**
     * 判断该牌是否使用过
     */
    static boolean[] isUsed = new boolean [11];

    public static void main(String[] args) throws IOException {
        long time1 = System.currentTimeMillis();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int T = Integer.valueOf(st.nextToken());
        for(int test_case=1;test_case<=T;test_case++){
            st = new StringTokenizer(bf.readLine());
            B = Integer.valueOf(st.nextToken());
            W = Integer.valueOf(st.nextToken());
            BW = new int[B+1][W+1];
            WB = new int[W+1][B+1];
            Answer = 0;
            for(int i=1;i<=B;i++){
                st = new StringTokenizer(bf.readLine());
                for (int j=1;j<=W;j++){
                    BW[i][j] = Integer.valueOf(st.nextToken());
                }
            }
            for (int i = 1; i <= W;i++){
                st = new StringTokenizer(bf.readLine());
                for (int j = 1; j <= B;j++){
                    WB[i][j] = Integer.valueOf(st.nextToken());
                }
            }
            if(B <= W){
                BDFS(1, 0);
            }else {
                WDFS(1, 0);
            }
            System.out.println("#" + test_case + " " + Answer);
        }
        long time2 = System.currentTimeMillis();
        System.out.println("times:::" + (time2-time1));
    }

    static void BDFS(int index, int count){
        if(index == B){
            Answer = Math.max(Answer, count);
            return;
        }

        for(int i=1;i<=W;i++){
            if (!isUsed[i]){
                isUsed[i] = true;
                BDFS(index+1, Answer + Math.max(BW[index][i], WB[i][index]));
                isUsed[i] = false;
            }
        }
    }

    static void WDFS(int index, int count){
        if(index == W){
            Answer = Math.max(Answer, count);
            return;
        }

        for(int i=1;i<=B;i++){
            if(!isUsed [i]){
                isUsed[i] = true;
                WDFS(index+1, Answer + Math.max(WB [index] [i], BW [i] [index]));
                isUsed [i] = false;
            }
        }
    }
}
