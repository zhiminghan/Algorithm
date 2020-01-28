package com.algorithm.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {

        //System.out.println(findKthlargest(new int[]{3,2,3,1,2,4,5,5,6},4));
        //System.out.println(findSecondLargestValue(new int[]{5,6}));

        Stack stack=new Stack();
        stack.push("aaa");
        stack.push("bbb");
        stack.push("ccc");
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(getRow(3));

    }


    public static List<Integer> getDuiJiaoPrint(int[][]arr){
        //        List<Integer> list=new ArrayList<>();
        //        if(arr==null||arr.length==0||arr[0].length==0) return list;
        //        for()

        return null;
    }

    public static int sumSubArrayMins(int[]arr){

        if(arr==null||arr.length==0) return 0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            int min=arr[i];
            sum+=min;
            for (int j=i+1;j<arr.length;j++){
                min=Math.min(arr[j],min);
                sum+=min;
            }
        }
        return sum;
    }

    public static int findKthlargest(int[]nums,int k){

        int[] topK=new int[k];

        for (int i=0;i<nums.length;i++){

            for (int j=0;j<topK.length;j++){
                if(topK[j]<nums[i]){
                    topK[j]=nums[i];
                    break;
                }
            }

        }
        return topK[k-1];

    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> temp=new ArrayList<>();

        for(int i=0;i<rowIndex;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    list.add(1);
                }else{
                    list.add(temp.get(j-1)+temp.get(j));
                }
            }
            temp=list;

        }
        return temp;
    }


    public static int findSecondLargestValue(int[]nums)
    {
        int max=0;
        int second=0;
        for (int i=0;i<nums.length;i++){

            if(max<nums[i]){
                max=nums[i];
            }else{
                if(second<nums[i]){
                    second=nums[i];
                }
            }

        }

        return second;
    }

}
