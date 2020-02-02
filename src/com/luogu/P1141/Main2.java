package com.luogu.P1141;
import java.io.IOException;
import	java.util.StringTokenizer;
import	java.io.InputStreamReader;
import	java.io.BufferedReader;
import java.util.*;

/**
 * Main class
 *
 * @auther Yvqanlee
 * @data 2019/12/1 19:47
 */
public class Main2 {
    static int N, M;
    static char[][] Value;
    static int[][] Start;
    static int[][] DP;
    static int[][] Group = {{1,0},{-1,0},{0,1},{0,-1}};
    static Map<Integer, Integer> map = new HashMap<> ();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        Value = new char[N][N];
        Start = new int[M][2];
        DP = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            Value[i] = st.nextToken().toCharArray();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            Start[i][0] = Integer.valueOf(st.nextToken())-1;
            Start[i][1] = Integer.valueOf(st.nextToken())-1;
        }

        int step = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(DP[i][j] == 0){
                    step++;
                    queue.clear();
                    queue.add(i);
                    queue.add(j);
                    DP[i][j] = step;
                    bfs(queue, step);
                }
            }
        }

        for(int i=0;i<M;i++){
            System.out.println(map.get(DP[Start[i][0]][Start[i][1]]));
        }


    }

    static void bfs(Queue<Integer> queue, int step){
        int count = 1;
        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            for(int i=0;i<4;i++){
                int a = x + Group[i][0];
                int b = y + Group[i][1];
                if(a >= 0 && a < N && b >= 0 && b < N && Value[a][b] != Value[x][y] && DP[a][b] == 0){
                    DP[a][b] = step;
                    count++;
                    queue.add(a);
                    queue.add(b);
                }
            }
        }
        map.put(step, count);
    }

}
