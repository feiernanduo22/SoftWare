package com.likou.dongtaiguihua;
import	java.util.Arrays;

/**
 * DiXiaChengYouXi class
 *
 * @auther Yvqanlee
 * @data 2019/9/18 20:16
 */
public class DiXiaChengYouXi {
    static int value, row, col;
    static int[][] group = {{1,0},{0,1}};
    static boolean[][] isUsed;

    public static void main(String[] args) {
        int[][] arr = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int a = calculateMinimumHP(arr);
        System.out.println(a);
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        row = dungeon.length;
        col = dungeon[0].length;
        int minValue = 65535;
        isUsed = new boolean[row][col];
        dsf(dungeon, 0, 0, dungeon[0][0]);
        return value;
    }

    private static void dsf(int[][] dungeon, int x, int y, int step){
        if(x == (row-1) && y == (col-1)){
            if(value > step){
                value = step;
            }
        }

        for(int i=0;i<group.length;i++){
            int a = x + group[i][0];
            int b = y + group[i][1];
            if(a >= 0 && a < row && b >= 0 && b < col && !isUsed[a][b]){
                isUsed[a][b] = true;
                dsf(dungeon, a, b, step + dungeon[a][b]);
                isUsed[a][b] = false;
            }
        }
    }
}
