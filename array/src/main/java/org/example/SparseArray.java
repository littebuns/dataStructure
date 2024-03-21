package org.example;

/**
 * 稀疏数组
 */
public class SparseArray {
    static int[][] chessArray;

    static {
        //模拟一个 8*8 的棋盘
        chessArray = new int[8][8];
        chessArray[2][2] = 1;
        chessArray[3][3] = 2;
        //打印棋盘
        System.out.println("原本的棋盘如下所示:");
        printArray(chessArray);
    }

    /**
     * 将二维数组转化为稀疏数组
     *
     * @param array
     * @return
     */
    static int[][] arrayToSparseArray(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    sum++;
                }
            }
        }
        int[][] sparseArray = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArray[0][0] = array.length;
        sparseArray[0][1] = array[0].length;
        sparseArray[0][2] = 3;
        //将非0的值存放到稀疏数组中
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array[i][j];
                }
            }
        }
        return sparseArray;
    }

    static int[][] sparseArrayToArray(int[][] sparseArray) {
        int[][] array = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            int[] data = sparseArray[i];
            array[data[0]][data[1]] = data[2];
        }
        return array;
    }

    static void printArray(int[][] array){
        for (int[] row : array) {
            for (int i : row) {
                System.out.printf("%s\t", i);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] sparseArray = arrayToSparseArray(chessArray);
        System.out.println("获得的稀疏数组如下所示:");
        printArray(sparseArray);
        int[][] array = sparseArrayToArray(sparseArray);
        System.out.println("获得的数组如下所示");
        printArray(array);
    }
}
