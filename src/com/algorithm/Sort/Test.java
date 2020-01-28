package com.algorithm.Sort;

import com.algorithm.Structure.ListNode;

import java.util.*;

public class Test {


    public static void main(String[] args) {

        int []nums1 = new int[]{1,2,3,0,0,0}; int m = 3;
        int[] nums2 =new int[]{2,5,6};       int n = 3;

        merge(nums1,m,nums2,n);
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        int min;
        int minIndex=0;
        ListNode head=null;

        ListNode cur=null;
        while (true){
            min=Integer.MAX_VALUE;
            for (int i=0;i<lists.length;i++) {
                if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    minIndex=i;
                }

            }
            if(min==Integer.MAX_VALUE){
                break;
            }
            lists[minIndex]=lists[minIndex].next;
            if (head == null) {
                head = new ListNode(min);
                cur = head;
            } else {
                ListNode n = new ListNode(min);
                cur.next = n;
                cur = n;
            }

        }

        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head1=l1;
        ListNode head2=l2;

        if(l1==null&&l2==null){
            return null;
        }

        ListNode head=null;
        ListNode cur=null;

        int min;
        for (;head1!=null&&head2!=null;){
            min=Integer.MAX_VALUE;
            if(head1.val<head2.val){
                min=head1.val;
                head1=head1.next;
            }else {
                min=head2.val;
                head2=head2.next;
            }

            if(head==null){
                head=new ListNode(min);
                cur=head;
            }else {
                ListNode n=new ListNode(min);
                cur.next=n;
                cur=n;
            }

        }

        if(head1==null){
            if(head==null){
                head=head2;
            }else{
                cur.next=head2;
            }
        }else{
            if(head==null){
                head=head1;
            }else{
                cur.next=head1;
            }
        }
        return head;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;
        for (;m!=0&&n!=0;){

            if(nums1[i]<nums2[j]){
                m--;
                i++;
            }else {
                n--;
                for (int k=i+m-1;k>=i;k--){
                    nums1[k+1]=nums1[k];
                }
                nums1[i]=nums2[j];
                i++;
                j++;

            }

        }
        if(n!=0){
            for(int k=i;k<i+n;k++){
                nums1[k]=nums2[j++];
            }
        }

        for (int num:nums1){
            System.out.print(num+" ");
        }
        System.out.println();
    }


    public int[] sortedSquares(int[] A) {

        int left=0;
        int right=A.length-1;
        int [] result=new int[A.length];
        int end=A.length-1;
        while(left<=right){

            if(A[left]*A[left]<A[right]*A[right]){
                result[end--]=A[right]*A[right];
                right--;
            }else {
                result[end--]=A[left]*A[left];
                left++;
            }


        }

        return result;



    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map=new HashMap<>();
        int[] rs=new int[2];
        for (int i=0;i<nums.length;i++){
            int num=target-nums[i];
            if(map.containsKey(num)){
                rs[0]=i;
                rs[1]=map.get(num);
                break;
            }else{
                map.put(nums[i],i);
            }
        }

        return rs;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> total=new ArrayList<>();
        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){

                if(map.containsKey(nums[j])){
                    List<Integer> list=map.get(nums[j]);
                    list.add(nums[j]);
                    Collections.sort(list);
                    if(!total.contains(list)){
                        total.add(list);
                    }
                    map.remove(nums[j]);
                }else {
                    int key=0-nums[i]-nums[j];
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    map.put(key,list);
                }

            }
            map.clear();
        }

        return total;
    }


    /*public int lengthOfLongestSubstring(String s) {

    }*/
}
