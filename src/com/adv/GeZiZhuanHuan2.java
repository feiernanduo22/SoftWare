package com.adv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * 3
 * 2
 * 0 1
 * 1 0
 * 1 1
 * 1 0
 * 3
 * 1 1 1
 * 1 0 0
 * 1 0 1
 * 0 1 1
 * 0 0 1
 * 1 1 0
 * 4
 * 1 1 0 0
 * 0 1 0 1
 * 1 1 1 1
 * 0 0 0 0
 * 0 1 0 1
 * 1 0 1 0
 * 1 1 0 0
 * 0 0 1 1
 */

/**
 * GeZiZhuanHuan2 class
 *
 * @auther Yvqanlee
 * @data 2020/3/29 20:06
 */
public class GeZiZhuanHuan2 {
    /**
     * 格子大小及最终答案
     */
    static int N, Answer;
    /**
     * 初始值
     */
    static int[][] Value1;
    /**
     * 最终结果
     */
    static int[][] Value2;
    static int[] Gx = {1,-1,0,0,0};
    static int[] Gy = {0,0,1,-1,0};
    static boolean find;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int T = Integer.valueOf(st.nextToken());
        for (int t=1;t<=T;t++){
            st = new StringTokenizer(bf.readLine());
            N = Integer.valueOf(st.nextToken());
            Value1 = new int[N][N];
            Value2 = new int[N][N];
            Answer = -1;
            find = false;
            for(int i=0;i<N;i++){
                st = new StringTokenizer(bf.readLine());
                for (int j=0;j<N;j++){
                    Value1[i][j] = Integer.valueOf(st.nextToken());
                }
            }
            for(int i=0;i<N;i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++){
                    Value2[i][j] = Integer.valueOf(st.nextToken());
                }
            }
            //假设1步就可以完成，一直到6步可以完成
            for(int i=1;i<=6;i++){
                int[][] value = new int[N][N];
                for(int k=0;k<N;k++){
                    value[k] = Value1[k].clone();
                }
                dfs(value, i, 0, 0, 0);
            }
            System.out.println("#" + t + " " + Answer);
        }
    }

    /**
     * dfs找到需要几步
     * @param value 二维数组
     * @param index  总步数
     * @param step   当前几步
     * @param x      改变的坐标
     * @param y
     */
    static void dfs(int[][] value, int index, int step, int x, int y){
        //如果找到，则跳出
        if(find){
            return;
        }
        //如果当前步数==总步数，也跳出
        if(step == index){
            return;
        }

        //如果y到最后一列，置为0，如果x到最后一行，则返回
        if(y == N){
            y = 0;
            x++;
            if(x == N){
                return;
            }
        }

        //转换当前的值
        bfs(value, x, y, step);
        //递归
        dfs(value, index, step+1, x, y+1);
        //将当前值复原
        bfs(value, x, y, step);
        //手动往后循环一个值
        dfs(value, index, step, x, y+1);
    }

    /**
     * 改变当前值及周围值
     * @param value 二维数组
     * @param x     改变的坐标
     * @param y
     * @param step  当前第几步
     */
    static void bfs(int[][] value, int x, int y, int step){
        //改变当前以及周围的值
        for(int i=0;i<5;i++){
            int a = x + Gx[i];
            int b = y + Gy[i];
            if(a >= 0 && a < N && b >= 0 && b < N){
                if(value[a][b] == 0){
                    value[a][b] = 1;
                }else{
                    value[a][b] = 0;
                }
            }
        }
        //判断改变完后的值与最后值是否相同
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(value [i] [j] != Value2[i][j]){
                    return;
                }
            }
        }
        //如果相同，find改为true，并将当前步数付给答案
        find = true;
        Answer = step;
    }
}
