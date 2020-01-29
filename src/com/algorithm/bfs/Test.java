package com.algorithm.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class Test {

    class Node{

        int x;
        int y;

        public Node(int y, int x) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int numIslands(char[][] grid) {
        int size=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    bfs(i,j,grid);
                    size++;
                }

            }
        }

        return size;
    }

    /**
     * 通过广度优先算法计算岛屿的数量
     * @param i
     * @param j
     * @param grid
     */

    private void bfs(int i, int j,char[][] grid) {
        Node root=new Node(i,j);
        LinkedList<Node> queue=new LinkedList<>();
        HashSet<Node> set=new HashSet<>();
        queue.add(root);
        set.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for (int k=0;k<size;k++){
                Node n=queue.removeFirst();
                grid[n.y][n.x]='2';
                set.remove(n);
                if(n.y+1<grid.length){
                    Node node=new Node(n.y+1,n.x);
                    if(!set.contains(node)&&grid[n.y+1][n.x]=='1'){
                        queue.add(node);
                        set.add(node);
                    }
                }
                if(n.x+1<grid[0].length){
                    Node node=new Node(n.y,n.x+1);
                    if(!set.contains(node)&&grid[n.y][n.x+1]=='1'){
                        queue.add(node);
                        set.add(node);

                    }
                }

                if(n.y-1>=0){
                    Node node=new Node(n.y-1,n.x);
                    if(!set.contains(node)&&grid[n.y-1][n.x]=='1'){
                        queue.add(new Node(n.y-1,n.x));
                        set.add(node);
                    }
                }

                if(n.x-1>=0){
                    Node node=new Node(n.y,n.x-1);
                    if(!set.contains(node)&&grid[n.y][n.x-1]=='1'){
                        queue.add(new Node(n.y,n.x-1));
                        set.add(node);
                    }
                }
            }

        }

    }

    public static void main(String[] args) {

        Test t=new Test();
        char[][] grid=new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.printf("size=%d \n",t.numIslands(grid));

        char[][] grid2=new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.printf("size=%d \n",t.numIslands(grid2));


        char[][] grid3=new char[][]{

                {'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},
                {'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},
                {'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},
                {'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},
                {'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}
   
        };




        System.out.printf("size=%d \n",t.numIslands(grid3));

    }


}
