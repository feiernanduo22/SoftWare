package com.luogu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * P1025 class
 *
 * @auther Yvqanlee
 * @data 2020/2/2 11:30
 */
public class P1025 {
    static int N, K, Answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());
        Answer = 0;
        dfs(0, 0, 1);
        System.out.println(Answer);
    }

    static void dfs(int count, int step, int index){
        if (count > N) {
            return;
        }

        if(step == K){
            if(count == N) {
                Answer++;
            }
            return;
        }

        for(int i=index;i<=N-count; i++){
            dfs(count+i, step+1, i);
        }


    }
}
