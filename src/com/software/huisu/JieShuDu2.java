package com.software.huisu;

/**
 * @auther Yvqanlee
 * @data 2019/9/10 17:21
 */
public class JieShuDu2 {
    private static final char NOVSLUE = '.';
    private static final int STARTVALUE = 1;
    private static final int ENDVALUE = 9;

    public static void solveShuDu(char[][] board){
        //定义行、列、3*3格子是否使用过数字
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] boxUsed = new boolean[3][3][10];
        //初始化行、列、3*3格子
        for (int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int num = board[i][j] - '0';
                if (num >= 1 && num <= 9){
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    boxUsed[i/3][j/3][num] = true;
                }
            }
        }

        show(board);
        dsf(board, rowUsed, colUsed, boxUsed, 0, 0);
        show(board);
    }

    private static boolean dsf(char[][] board, boolean[][] rowUsed, boolean[][] colUsed, boolean[][][] boxUsed, int row, int col){
        //判断是否所有空格已填充，如果是则跳出
        if (col == board[0].length){
            col = 0;
            row++;
            if (row == board.length){
                return true;
            }
        }

        //如果该位置为.则找数字填充
        if (board[row][col] == NOVSLUE){
            //从1到9选出数字来填充
            for (int i=STARTVALUE;i<=ENDVALUE;i++){
                //判断该数字是否在行、列、3*3格子使用过
                boolean used = (rowUsed[row][i] || colUsed[col][i] || boxUsed[row/3][col/3][i]);
                if(!used){
                    rowUsed[row][i] = true;
                    colUsed[col][i] = true;
                    boxUsed[row/3][col/3][i] = true;
                    board[row][col] = (char)(i + '0');

                    if (dsf(board, rowUsed, colUsed, boxUsed, row, col + 1)){
                        return true;
                    }
                    rowUsed[row][i] = false;
                    colUsed[col][i] = false;
                    boxUsed[row/3][col/3][i] = false;
                    board[row][col] = '.';
                }
            }
        }else {//否则列加1
           return dsf(board, rowUsed, colUsed, boxUsed, row, col+1);
        }
        return false;
    }

    private static void show(char[][] board){
        for (int i=0;i<board.length;i++){
            System.out.println(board[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveShuDu(board);
    }
}
