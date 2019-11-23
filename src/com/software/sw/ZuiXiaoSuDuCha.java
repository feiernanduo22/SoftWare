package com.software.sw;
import	java.util.Objects;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * ZuiXiaoSuDuCha class
 *
 * @auther Yvqanlee
 * @data 2019/11/4 20:57
 */
public class ZuiXiaoSuDuCha {
    static int N,M,start,end,Answer;
    static int[] parent;
    static int[][] Value;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int test_case = 1;test_case<=T;test_case++){
            N = scanner.nextInt();//点的个数
            M = scanner.nextInt();//线的个数
            Value = new int [M+1] [3];//存放点的信息
            parent = new int [N+1];
            for (int i=1;i<=M;i++){
                Value[i][0] = scanner.nextInt();
                Value [i] [1] = scanner.nextInt();
                Value [i] [2] = scanner.nextInt();
            }
            start = scanner.nextInt();
            end = scanner.nextInt();
            Arrays.sort(Value, 1, M+1, new CompareBySpeed());
            Answer = Integer.MAX_VALUE;

            int result;
            for (int i=1;i<=M;i++){
                result = dfs(i);
                if (result == -1) {
                    break;
                }
                i = result + 1;
            }
            System.out.println("#" + test_case + " " + Answer);
        }
    }

    static int dfs(int min){
        for (int i=1;i<=N;i++){
            parent[i] = i;
        }

        int s1, s2, max = 0;

        for (int i=min;i<=M;i++){
            s1 = getRoot(Value[i][0]);
            s2 = getRoot(Value[i][1]);
            if (s1 == s2){
                continue;
            }else {
                parent [s2] = s1;
                if (getRoot(start) == getRoot(end)){
                    Answer = Math.min(Answer, Value [i][2] - Value [min] [2]);
                    max = i;
                    break;
                }
            }
        }

        if (max == 0){
            return -1;
        }

        for (int i=1;i<=N;i++){
            parent [i] = i;
        }
        for (int i=max;i>=1;i--){
            s1 = getRoot(Value [i] [0]);
            s2 = getRoot(Value[i][1]);
            if (s1 == s2){
                continue;
            }else {
                parent [s2] = s1;
                if (getRoot(start) == getRoot(end)){
                    Answer = Math.min(Answer, Value [max] [2] - Value [i] [2]);
                    min = i;
                    break;
                }
            }
        }

        return min;
    }

    static int getRoot(int child){
        if(child == parent [child]){
            return child;
        }else {
            return parent [child] = getRoot(parent[child]);
        }
    }

    static class CompareBySpeed implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1 [2] - o2 [2];
        }
    }
}
