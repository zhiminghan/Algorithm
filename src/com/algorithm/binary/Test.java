package com.algorithm.binary;

public class Test {


    public static void main(String[] args) {
        new Test().search(new int[]{3,5,1

        },1);
    }

    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return -1;
        int left=0;
        int right=nums.length-1;
        int n=getRotateIndex(nums,left,right);
        if(n>=0){
            if(target>=nums[left]){
                right=n;
            }else{
                left=n+1;
            }
        }

        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;


    }

    public int getRotateIndex(int[] nums, int left,int right) {

        if(nums.length==2){
            if(nums[0]>nums[1]){
                return 0;
            }
        }

        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>nums[i-1]&&nums[i]>nums[i+1]){
                return i-1;
            }
        }
        return -1;

    }

}
