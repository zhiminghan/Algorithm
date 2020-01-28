package com.algorithm.double_pointer;

import com.algorithm.Structure.ListNode;

import java.util.*;

public class Test {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        for (;i<nums1.length&j<nums2.length;){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        return toArray(list);
    }

    public int[] toArray(List<Integer> list){
        int []rs=new int[list.size()];
        for (int k=0;k<list.size();k++){
            rs[k]=list.get(k);
        }
        return rs;
    }


    public int[] intersect2(int[] nums1, int[] nums2) {

        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        for (int num:nums1){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);

            }
        }

        for (int num:nums2){
            if(map.containsKey(num)){
                int count=map.get(num);
                if (count==1){
                    map.remove(num);
                }else{
                    map.put(num,count-1);
                }
                list.add(num);
            }
        }
        return toArray(list);
    }

    public static int removeDuplicates(int[] nums) {

        int size=nums.length;
        int pre=0,next=0;
        int len=0;

        for (int i=next+1;i<size;i++){

            if(nums[pre]!=nums[i]){
                if (len!=0) {
                    for (int j = i; j < size; j++) {
                        nums[j - len] = nums[j];
                    }
                }
                i=i-len;
                pre=i;
                size-=len;
                len = 0;
                printArr(nums);
            }else{
                len++;
            }

        }

        if(len>0){
            size-=len;
        }

        return size;
    }

    private static void printArr(int[] nums) {

        for (int num:nums){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    public int removeElement(int[] nums, int val) {
        int size=nums.length;
        for (int i=0;i<size;i++){

            if(nums[i]==val){
                for (int j = i+1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                size--;
                i=i-1;
            }
        }
        return size;

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode prev=null;
        ListNode removeNode=head.next;
        ListNode cur=removeNode;
        for (int i=0;i<n&&cur!=null;i++){
            prev=cur;
            cur=cur.next;
        }
        while(cur!=null){

            cur=cur.next;
            removeNode=removeNode.next;
            prev=prev.next;
        }

        prev.next=removeNode.next;
        return head;
    }

    public static int getMaxSum(int []arr){

        int sum=Integer.MIN_VALUE;
        int temp=0;

        for (int i=0;i<arr.length;i++){

            temp+=arr[i];
            sum=Math.max(sum,temp);
            if(temp<0){
                temp=0;
                continue;
            }

        }
        return sum;
    }

    public int getMinLenSubArray(int []arr,int sum){
        if(arr==null||arr.length==0)
            return 0;

       List<List<Integer>> totals=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        boolean[] visited=new boolean[arr.length];
        getMinLenSubArray(arr,visited,totals,temp,sum);
        System.out.printf("totals=%s\n",totals);
        int min=0;
        for (List<Integer> list :totals){
            min=Math.min(min,list.size());
        }
        return min;
    }

    private void getMinLenSubArray(int[] arr,boolean[] visited,List<List<Integer>> totals, List<Integer> temp, int sum) {
        if(sum<0){
            return;
        }

        if(sum==0&&!totals.contains(temp)){
            totals.add(temp);
        }

        for (int j=0;j<arr.length;j++){
            if(!visited[j]) {
                temp.add(arr[j]);
                visited[j]=true;
                getMinLenSubArray(arr, visited, totals, temp, sum - arr[j]);
                temp.remove(temp.size() - 1);
                visited[j]=false;

            }
        }


    }

    //"abcabcbb"
    public static int lengthOfLongestSubstring(String s) {

        if(s==null){
            return 0;
        }

       HashMap<Character,Integer> map=new HashMap<>();
       char[] chars=s.toCharArray();
       int len=0;
       int low=0;
       for (int i=0;i<chars.length;i++){

           if (map.containsKey(chars[i])){

               int temp=low;
               low=map.get(chars[i])+1;
               map.put(chars[i],i);
               for (int j=low-1;j>=temp;j--){
                   if (chars[j]!=chars[i])
                       map.remove(chars[j]);
               }

           }else{
               map.put(chars[i],i);
           }
           len=Math.max(len,i-low+1);
       }

       return len;


    }

    public static int findDuplicate(int[] nums) {

        Arrays.sort(nums);
        int first=0;
        for(int i=1;i<nums.length;i++){

             if(nums[first]==nums[i]){
                 return nums[i];
             }else{
                 first=i;
             }
        }
        return -1;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int len=0;
        for (int num:nums){
            if(num==1){
                count++;
                len=Math.max(len,count);
            }else{
                count=0;
            }
        }
        return len;
    }


    public boolean hasCycle(ListNode head) {
        ListNode cur=head;
        Set<ListNode> set=new HashSet<>();

        while (cur != null) {
            if(!set.contains(cur)){
                set.add(cur);
                cur=cur.next;
            }else{
                return true;
            }

        }

        return false;

    }

    public static ListNode detectCycle(ListNode head) {
        ListNode first=head;
        ListNode second=head;

        while (first!=null&&second!=null&&second.next!=null&&!(first!=head&&first == second)) {
            first=first.next;
            second=second.next.next;
        }

        if(first==null||second==null||second.next==null){
            return null;
        }

        ListNode third=head;

        while (third!= second) {
            third=third.next;
            second=second.next;
        }


        return third;
    }

    public int[] searchRange(int[] nums, int target) {

        return nums;

    }

    /**
     * 求三数之和 使用双指针
     * @param nums
     * @return
     */

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> targetList=new ArrayList<>();
        for (int k=0;k<nums.length-2;k++){
            if(k>0&&nums[k]==nums[k-1]) continue;
            int target=-nums[k];
            int i=k+1;
            int j=nums.length-1;
            while(i<j){
                int sum=nums[i]+nums[j];
                if(sum<target){
                    while (i<j&&nums[i++]==nums[i]);
                }else if(sum>target){
                    while (i<j&&nums[j--]==nums[i]);
                }else {
                    List<Integer> list=new ArrayList<>(Arrays.asList(nums[k],nums[i],nums[j]));
                    targetList.add(list);
                    while (i<j&&nums[i++]==nums[i]);
                    while (i<j&&nums[j--]==nums[i]);
                }
            }
        }
        return targetList;
    }

    /**
     * 求四数之和 使用双指针 思想与求三数之和相同 难点在于去重
     * @param nums
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> targetList=new ArrayList<>();
        for (int m=0;m<nums.length-3;m++){
            if(m>0&&nums[m]==nums[m-1]) continue;
            for (int n=m+1;n<nums.length-2;n++) {
                if(n>m+1&&nums[n]==nums[n-1]) continue;
                int anotherSum =target-(nums[m] + nums[n]);
                int i = n + 1;
                int j = nums.length - 1;
                while (i < j) {
                    int sum = nums[i] + nums[j];
                    if (sum < anotherSum) {
                        while (i < j && nums[i++] == nums[i]) ;
                    } else if (sum > anotherSum) {
                        while (i < j && nums[j--] == nums[i]) ;
                    } else {
                        List<Integer> list = new ArrayList<>(Arrays.asList(nums[m],nums[n],nums[i], nums[j]));
                        targetList.add(list);
                        while (i < j && nums[i++] == nums[i]) ;
                        while (i < j && nums[j--] == nums[i]) ;
                    }
                }
            }
        }
        return targetList;
    }



    public static void main(String[] args) {

        removeDuplicates(new int[]{-3,-1,-1,0,0,0,0,0,2});

        System.out.println(getMaxSum(new int[]{-3,-1,7,-1,9,-1}));


        System.out.printf("min length=%d\n",new Test().getMinLenSubArray(new int[]{2,3,1,2,4,3},7));

        lengthOfLongestSubstring("abcabcbb");

        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
        ListNode head=new ListNode(1);
        ListNode second=new ListNode(2);
        head.next=second;

        System.out.println(detectCycle(head));


        System.out.println(fourSum(new int[]{-1,0,1,2,-1,-4},-1));


    }


}
