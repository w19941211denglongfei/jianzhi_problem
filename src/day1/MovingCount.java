package day1;

import java.util.LinkedList;
import java.util.Queue;

public class MovingCount {

    private static class Node{
        int first;
        int second;
        public Node(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    private static int getSum(int rows, int cols) {
        int s = 0;
        while (rows > 0) {
            s += rows % 10;
            rows /= 10;
        }

        while (cols > 0) {
            s += cols % 10;
            cols /= 10;
        }

        return s;
    }

    private static boolean[][] visited = new boolean[55][55]; //定义一个二维数组
    private static final int[][] nxt = {{1, 0},{-1, 0},{0, 1},{0, -1}}; //定义一个方向二维数组

    public static int movingCount(int threshold, int rows, int cols){
        if (rows < 1 || cols < 1){
            return 0;
        }
        Queue<Node> que = new LinkedList<>(); //双向链表队列
        visited[0][0] = true; //从0，0开始进行队列记录 每次四个方向往下走
        que.add(new Node(0,0));//位置入队
        int res = 0;//变量记录节点个数

        while (!que.isEmpty()){//循环队列
            Node popNode = que.poll();
            res++; //出队加1

            for (int i = 0; i < nxt.length; i++){//四个方向记录 符合方向的继续入队 依次处理
                int fx = popNode.first + nxt[i][0],fy = popNode.second + nxt[i][1];
                if (fx >=0 && fy >=0 && fx < rows && fy < cols && getSum(fx, fy) <= threshold && !visited[fx][fy]){ //多个条件判断
                    que.add(new Node(fx, fy)); //条件成立入队
                    visited[fx][fy] = true; //当前节点置为true
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int rows = visited.length;
        int cols = visited[0].length;
        int threshold = 10;
        int n = movingCount(threshold, rows, cols);
        System.out.println(n);
    }
}
