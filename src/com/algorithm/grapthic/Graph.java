package com.algorithm.grapthic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    int[][]edges;

    List<String> vertix;

    int N;

    public Graph(int n){
        this.N=n;
        edges=new int[N][N];
        vertix=new ArrayList<>();
    }

    public void insertEdge(int i,int j){
        edges[i-1][j-1]=1;
        edges[j-1][i-1]=1;
    }

    public void addVertix(String str){
        vertix.add(str);
    }

    public void dfs(){
        boolean[] visited=new boolean[N];
        for (int i=0;i<N;i++){
            if(!visited[i]){
                dfs(i,visited);
            }
        }
        System.out.println();
    }

    private void dfs(int i, boolean[] visited) {

        System.out.print(vertix.get(i)+" ");
        visited[i]=true;

        int w=getFirstNeighbor(i);
        while (w!=-1){
            if(!visited[w]){
                dfs(w,visited);
            }
            w=getNextNeighbor(i,w);
        }

    }

    public void bfs(){
        boolean[] visited=new boolean[N];
        for (int i=0;i<N;i++){
            if(!visited[i]){
                bfs(i,visited);
            }
        }

    }

    public int getFirstNeighbor(int i){

        for(int j=0;j<N;j++){
            if(edges[i][j]==1){
                return j;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int i,int j){

        for(int k=j+1;k<N;k++){
            if(edges[i][k]==1){
                return k;
            }
        }
        return -1;
    }



    private void bfs(int i, boolean[] visited) {

        Queue<Integer> queue=new LinkedList<>();
        queue.add(i);
        while(!queue.isEmpty()) {
            i=queue.poll();
            System.out.print(vertix.get(i) + " ");
            visited[i] = true;
            int w = getFirstNeighbor(i);
            while (w != -1) {
                if(!visited[w]) {
                    queue.add(w);
                }
                w = getNextNeighbor(i, w);
            }
        }


    }

    public void print(){

        for (int i=0;i<edges.length;i++){

            for (int j=0;j<edges[0].length;j++){
                System.err.print(edges[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        Graph graph=new Graph(7);
        graph.addVertix("A");
        graph.addVertix("B");
        graph.addVertix("C");
        graph.addVertix("D");
        graph.addVertix("E");
        graph.addVertix("F");
        graph.addVertix("G");

        graph.insertEdge(1,2);
        graph.insertEdge(1,3);
        graph.insertEdge(1,4);
        graph.insertEdge(2,5);
        graph.insertEdge(2,6);
        graph.insertEdge(3,7);


        System.out.println("深度优先遍历=====>");
        graph.dfs();

        System.out.println("广度优先遍历=====>");
        graph.bfs();



    }





}
