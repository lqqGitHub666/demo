package com.example.demo.data_structures.sparsearray;

/**
 * @author 作者 lqq
 * @ClassName 类名 SparseArray
 * @date 2020/9/23 19:24
 * @注释：稀疏数组
 */
public class SparseArray {

    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0：表示没有棋子，1：表示黑子，2：表示篮子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[3][3] = 2;
        chessArr1[3][4] = 1;
        //输出原始的二维数组
        System.out.println("原始的二维数组");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //将二维数组 转 稀疏数组
        //1.先遍历二维数组，得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11 ; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0){
                    sum ++;
                }
            }
        }
        //2.根据二维数组的数据情况生成稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        int count = 0;
        for (int i = 0; i < 11 ; i++) {
            for (int j = 0; j < 11; j++) {
                int data = chessArr1[i][j];
                if (data != 0){
                    count ++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = data;
                }
            }
        }
        System.out.println("稀疏数组的样子：");
        for (int i = 0; i < sum+1; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        //将稀疏数组转化为二维数组
        //1.先读取稀疏数组的第一行，根据第一行的数组，创建原始二维数组，比如上面的chessArr2 = int[11][11]
        //2.再读取稀疏数组后几行的数据，并赋给原始的二维数组即可
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        //遍历稀疏数组给二维数组赋值
        for (int i = 1; i <sparseArr[0][2]+1; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //遍历还原的二维数组
        System.out.println("还原的二维数组如下：");
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.printf("%d\t",chessArr2[i][j]);
            }
            System.out.println();
        }

    }


}
