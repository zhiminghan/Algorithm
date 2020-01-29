package com.algorithm.array;

import java.util.*;

public class Test {

    /**
     * 求两数之和
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] arr=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                arr[0]=i;
                arr[1]=map.get(nums[i]);
                break;
            }else{
                int anotherNum=target-nums[i];
                map.put(anotherNum,i);
            }

        }
        return arr;

    }

    /**
     * 求三数只和 借鉴求两数之和的思想，将一个数定住，求另外两个数只和 使用Hashmap保存两个数
     * @param nums
     * @return
     */

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> targetList=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            int target=-nums[i];
            for (int j=i+1;j<nums.length;j++){
                if(map.containsKey(nums[j])){
                    int anotherNum=map.get(nums[j]);
                    List<Integer> list=new ArrayList<>(Arrays.asList(nums[i],anotherNum,nums[j]));

                    if(!targetList.contains(list)){
                        targetList.add(list);
                    }
                    map.remove(nums[j]);
                }else{
                    int anotherNum=target-nums[j];
                    map.put(anotherNum,nums[j]);
                }

            }
            map.clear();
        }

        return targetList;
    }

    /**
     * 通过二分查找求旋转数组目标值
     * @param nums
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0) return -1;

        int rotateIndex=getRotateIndex(nums);

        int left=0;
        int right=nums.length-1;
        if(rotateIndex>-1) {
            if (target == nums[left]) {
                return left;
            } else if (target < nums[left]) {
                left = rotateIndex;
            } else {
                right = rotateIndex - 1;
            }
        }
        while (left<=right) {
            int mid = (left + right) / 2;
            if(target==nums[mid]){
                return mid;
            }else if(target<nums[mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }

        }

        return -1;
    }

    /**
     * 通过二分查找求旋转数组下标
     * @param nums
     * @return
     */
    public static int getRotateIndex(int[] nums) {
        if(nums.length==1) return 0;
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid =(left+right)/2;
            if(mid+1<nums.length&&nums[mid+1]<nums[mid]){
                return mid+1;
            }

            if(mid-1>=0&&nums[mid]<nums[mid-1]){
                return mid;
            }

            if(nums[mid]>nums[left]){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }

        return -1;

    }


    /**
     * 通过二分查找求旋转数组最小值
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {

        return nums[getRotateIndex(nums)];
    }


    public static void main(String[] args) {
        int[] nums=new int[]{2, 7, 11, 15};

        twoSum(nums,9);

        int nums2[]=new int[]{1,2,-2,-1};
        System.out.println(
                threeSum(nums)
        );

//        System.out.println(search(new int[]{
//                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
//
//        },2));



    }






}
