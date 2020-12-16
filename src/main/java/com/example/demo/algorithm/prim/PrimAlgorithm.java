package com.example.demo.algorithm.prim;

import java.util.Arrays;

/**
 * @ClassName: PrimAlgorithm
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/12/15 20:16
 * @Version: 1.0
 */
public class PrimAlgorithm {

    public static void main(String[] args) {
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        int[][] weight = new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}
        };
        MGraph mGraph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.creatGraph(mGraph,verxs,data,weight);
        minTree.showGraph(mGraph);
        minTree.prim(mGraph,1);
    }

    static class MinTree{

        public void creatGraph(MGraph mGraph,int verxs,char data[],int[][] weight){
            int i,j;
            for (i = 0; i < verxs; i++) {
                mGraph.data[i] = data[i];
                for (j = 0; j < verxs; j++) {
                    mGraph.weight[i][j] = weight[i][j];
                }
            }
        }

        public void showGraph(MGraph mGraph){
            for (int[] link : mGraph.weight) {
                System.out.println(Arrays.toString(link));
            }
        }

        //编写prim算法，得到最小生成树
        public void prim(MGraph mGraph,int v){
            int visited[] = new int[mGraph.verxs];
            visited[v] = 1;
            int h1 = -1;
            int h2 = -1;
            int minWeight = 10000;
            for (int k = 1; k < mGraph.verxs; k++) {
                for (int i = 0; i < mGraph.verxs; i++) {
                    for (int j = 0; j < mGraph.verxs; j++) {
                        if (visited[i] == 1 && visited[j] == 0 && mGraph.weight[i][j] < minWeight){
                            h1= i;
                            h2= j;
                            minWeight = mGraph.weight[i][j];
                        }
                    }
                }
                System.out.println("边<" + mGraph.data[h1] + "," + mGraph.data[h2] + "> 权值:" + minWeight);
                minWeight = 10000;
                visited[h2] = 1;
            }
        }
    }

    static class MGraph{
        int verxs;
        char[] data;
        int[][] weight;

        public MGraph(int verxs) {
            this.verxs = verxs;
            this.data = new char[verxs];
            this.weight = new int[verxs][verxs];
        }
    }
}
