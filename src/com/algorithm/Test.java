package com.algorithm;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        System.out.println(new Test().getClass().getClassLoader().getParent().toString());
        new Test().sublist(new int[]{4,3,1});

        //101 110
        //011 1001

        //
//        System.out.println(6&-6);
//        new Test().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
//        new Test().singleNumber(new int[]{2,1,1,2,5,3});

        String str="aaaa";
        new Test().setStr(str);
        System.out.println(str);

        Integer a=123;
        Integer b=123;

        int c=255;
        System.out.println(a==c);
        new Test().print(4);
        int []arr=new int[]{1,1,1,1,1,2};
        new Test().quickSort(arr,0,arr.length-1);
        new Test().print(arr);
    }




    public void setStr(String str){
        str="bbbb";
    }

    public void solve(char[][] board,boolean[] visited) {

        for (int i=1;i<board.length-1;i++){
                if(!visited[i]) {
                    visited[i] = true;
                    solve(board, visited);
                    visited[i] = false;
                }
            }

    }


    public int longestConsecutive(int[] nums) {

        TreeSet<Integer> set=new TreeSet<>();
        for (int num:nums){
            set.add(num);
        }
        System.out.println(set);
        int len=0;
        int temp=1;
        Integer pre=null;

        for (int num:set){
            if(pre==null){
                pre=num;
            }else if(pre!=num-1){
                temp=1;
                pre=null;
            }else {
                pre=num;
                temp++;
            }
            len=Math.max(len,temp);
        }
        System.out.println(len);
        return len;
    }


    public int[] singleNumber(int[] nums) {
        int xor=0;
        for (int num:nums){
            xor^=num;
        }

        int x=xor&-xor;

        int [] rs=new int[2];
        for (int num:nums){
            if((x&num)==x){
                rs[0]^=num;
            }else{
                rs[1]^=num;
            }
        }
        print(rs);

        return rs;

    }

    public void print(int[]arr){

    for (int num:arr){
        System.out.print(num+" ");
    }
        System.out.println();
    }


    public void sublist(int[] arr){

        boolean[] visited=new boolean[arr.length];
        Set<List<Integer>> totals=new HashSet<>();
        List<Integer> subList=new ArrayList<>();
        digui(arr,visited,totals,subList);
        System.out.println(totals);

    }

    private void digui(int[] arr, boolean[] visited,Set<List<Integer>> totals,List<Integer> subList) {



        for (int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i]=true;
                List<Integer> copys=new ArrayList<>(subList);
                copys.add(arr[i]);
                digui(arr,visited,totals,copys);
                visited[i]=false;
            }
        }

        Collections.sort(subList);
        totals.add(subList);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        int dis;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for (int i=0;i<nums.length;i++){
                int a=nums[i]-t;
                int b=nums[i]+t;

                if(map.containsKey(a)){

                }

                if(map.containsKey(b)){

                }

                map.put(nums[i],i);
        }



        return 1==1;
    }

    public void quickSort(int[] arr,int left,int right){

        if(left>right){
            return;
        }
        int target=arr[right];
        int k=left;
        for (int i=left;i<right;i++){
            if(arr[i]<target){
                int temp=arr[k];
                arr[k++]=arr[i];
                arr[i]=temp;
            }
        }

        int temp=arr[k];
        arr[k]=arr[right];
        arr[right]=temp;

        quickSort(arr,left,k-1);
        quickSort(arr,k+1,right);


    }

    public void print(int n){

        for (int i=1;i<=n;i++){
            for(int k=1;k<=n-i;k++){
                System.out.print(" ");
            }

            for (int j=1;j<=2*i-1;j++){
                if(j%2==0){
                    System.out.print(" ");
                }else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }



    }
}
