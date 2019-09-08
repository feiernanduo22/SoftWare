package com.software.huisu;

/**
 * @auther Yvqanlee
 * @data 2019/9/8 7:29
 */

/**
 * 解数独
 * 回溯
 *
 * 数独首先行、列、3*3 格子内的数组是1~9不能重复
 * 声明boolean数组，表明行列中某个数字是否被使用，被使用视为true，否则视为false
 * 初始化Boolean数组，表明哪些数字已经被使用过了
 * 尝试去填充数组，只要行、列、还有3*3方格内出现已经被使用过的数字，就不去填充，否则尝试填充
 * 如果填充失败，需要回溯，将原来尝试填充的地方改回来
 * 递归直到数独被填充完成
 */

public class JieShuDu {
   public static void solveShuDu(char[][] board){
       //三个boolean数组表明行、列、3*3格子的数字是否被使用过
       boolean rowUsed[][] = new boolean[9][10];
       boolean colUsed[][] = new boolean[9][10];
       boolean boxUsed[][][] = new boolean[3][3][10];
       //初始化
       for (int row = 0; row < board.length; row++){
           for (int col = 0; col < board[0].length; col++){
               int num = board[row][col] - '0';
               if(1 <= num && num <= 9){
                   rowUsed[row][num] = true;
                   colUsed[col][num] = true;
                   boxUsed[row/3][col/3][num] = true;
               }
           }
       }
       print(board);
       //递归尝试填充数组
       recusiveSolveShuDu(board, rowUsed, colUsed, boxUsed, 0, 0);
   }

   private static boolean recusiveSolveShuDu(char[][] board, boolean[][] rowUsed, boolean[][] colUsed, boolean[][][] boxUsed, int row, int col){
        //边界校验，如果已经填充完成，返回true，表示一切结束
       if (col == board[0].length){
           col = 0;
           row++;
           if (row == board.length){
               return true;
           }
       }
       //是空则尝试填充，否则跳过继续尝试填充下一个位置
       if (board[row][col] == '.'){
           //尝试填充1~9
           for (int num = 1; num <= 9; num++){
               //该数字是否使用过
               boolean canUsed = !(rowUsed[row][num] || colUsed[col][num] || boxUsed[row/3][col/3][num]);
               if (canUsed){
                   rowUsed[row][num] = true;
                   colUsed[col][num] = true;
                   boxUsed[row/3][col/3][num] = true;
                   //将该数字放入数独中
                   board[row][col] = (char)('0' + num);
                   if (recusiveSolveShuDu(board, rowUsed, colUsed, boxUsed, row, col + 1)){
                       return true;
                   }
                   board[row][col] = '.';

                   rowUsed[row][num] = false;
                   colUsed[col][num] = false;
                   boxUsed[row/3][col/3][num] = false;
               }
           }
       }else{
           return recusiveSolveShuDu(board, rowUsed, colUsed, boxUsed, row, col + 1);
       }

       return false;
   }

   private static void print(char[][] board){
       for(int i=0;i<board.length;i++){
           System.out.println(board[i]);
       }
       System.out.println();
   }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveShuDu(board);
    }


}
