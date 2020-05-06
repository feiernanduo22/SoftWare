package com.luogu.march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * P1141 class
 *
 * @auther Yvqanlee
 * @data 2020/3/16 21:15
 */
public class P1141 {
    static int N, M, Answer;
    static char[][] Value;
    static int[][] DP;
    static int[] Gx = {1,-1,0,0};
    static int[] Gy = {0,0,1,-1};
    static Map<Integer, Integer> map;
    static int[][] Start;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        Value = new char[N][N];
        DP = new int[N][N];
        Start = new int[M][2];
        map = new HashMap<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            Value[i] = st.nextToken().toCharArray();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            Start[i][0] = Integer.valueOf(st.nextToken())-1;
            Start[i][1] = Integer.valueOf(st.nextToken())-1;
        }
        int index = 1;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(DP[i][j] == 0){
                    DP[i][j] = index;
                    queue.clear();
                    queue.add(i);
                    queue.add(j);
                    bfs(queue, index);
                    index++;
                }
            }
        }
        for(int i=0;i<M;i++){
            System.out.println(map.get(DP[Start[i][0]][Start[i][1]]));
        }

    }

    static void bfs(Queue<Integer> queue, int index){
        int num = 1;
        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            for(int i=0;i<4;i++){
                int a = x + Gx[i];
                int b = y + Gy[i];
                if(a >= 0 && a < N && b >= 0 && b < M && DP[a][b] == 0 && Value[a][b] != Value[x][y]){
                    num++;
                    queue.add(a);
                    queue.add(b);
                    DP[a][b] = index;
                }
            }
        }
        map.put(index, num);
    }
}
