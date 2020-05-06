package com.luogu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * P4017 class
 *
 * @auther Yvqanlee
 * @data 2020/5/6 19:40
 */
public class P4017 {
    static int N, M, Answer;
    static int[] in = new int[5005];
    static int[] out = new int[5005];
    static int[] f = new int[5005];
    static boolean[][] isLink;
    static Queue<Integer> queue = new LinkedList<Integer> ();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        isLink = new boolean [N+1][N+1];
        Answer = 0;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            //记录两点是否连接
            isLink[a][b] = true;
            //记录入读和出度
            out[a]++;
            in[b]++;
        }
        for(int i=1;i<=N;i++){
            if(in[i] == 0){
                //找到入度为0的
                f[i] = 1;
                //加入队列
                queue.add(i);
            }
        }
        //队列不为空
        while(!queue.isEmpty()){
            //出队
            int a = queue.poll();
            //循环所有的路径
            for(int k=1;k<=N;k++){
                //如果想通
                if(isLink[a][k]){
                    //后者 += 前者
                    f[k] += f[a];
                    f[k] %= 80112002;
                    //k的入度--
                    in[k]--;
                    //如果入度为0，
                    if(in[k] == 0){
                        //如果出度为0
                        if(out[k] == 0){
                            //说明是最终的点：+当前点的数量
                            Answer += f[k];
                            Answer %= 80112002;
                        }
                        //入队
                        queue.add(k);
                    }
                }
            }
        }
        System.out.println(Answer);
    }


}
