package com.algorithm.dfs;

import com.algorithm.Structure.TreeNode;

import java.util.*;

public class Test {

    public static void main(String[] args) {


        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);

        new Test().sumNumbers(root);

        int[][]arr=new int[4][4];
        int k=1;
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                arr[i][j]=k++;
            }
        }

        new Test().print(arr);
        new Test().plusOne(new int[]{9,9});

        new Test().addStrings("0","0");

        System.out.println(new Test().subarraySum(new int[]{1,2,1,2,1},3));
        System.out.println(new Test().twoSum(new int[]{1,1,1},2));
    }
    public Set<List<Integer>> twoSum(int[] nums, int target) {
        Set<List<Integer>> total=new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                List<Integer> list=Arrays.asList(Math.min(map.get(complement),i),Math.max(map.get(complement),i));
                if(!total.contains(list))
                total.add(list);
            }
        }
        return total;
    }

    public int subarraySum(int[] nums, int k) {

        if(nums==null||nums.length==0){
            return 0;
        }
        Set<Integer> set=new HashSet<>();
        int count=0;
        int sum=0;
        set.add(0);
        for(int i=0;i<nums.length;i++){
            if(set.contains(k-nums[i])){
                count++;
                set.remove(k-nums[i]);
                sum=nums[i];
            }else{
                sum+=nums[i];
            }
            set.add(sum);
        }

        return count;


    }


    public int sumNumbers(TreeNode root) {

        List<Integer> list=new ArrayList<>();
        StringBuffer sb=new StringBuffer();
        sb.append(root.val);
        if(root.left!=null) {
            preOrder(root.left, new StringBuffer(sb.toString()), list);
        }
        if(root.right!=null) {
            preOrder(root.right, new StringBuffer(sb.toString()), list);
        }
            int sum=0;
        for(int num:list){
            sum+=num;
        }
        return sum;

    }

    public void preOrder(TreeNode n,StringBuffer sb,List<Integer> list){
        if(n.left==null&&n.right==null){
            sb.append(n.val);
            list.add(Integer.parseInt(sb.toString()));
            return;
        }
        sb.append(n.val);
        if(n.left!=null) {
            preOrder(n.left, new StringBuffer(sb.toString()), list);
        }
        if(n.right!=null) {
            preOrder(n.right, new StringBuffer(sb.toString()), list);
        }
    }

    public List<Integer> print( int[][] arr){

        boolean LEFT=true;
        boolean UP=false;
        boolean DOWN=false;
        boolean RIGHT=false;
        List<Integer> list=new ArrayList<>();
        if(arr==null||arr.length==0){
            return list;
        }

        int m=arr.length;
        int n=arr[0].length;
        int i=0,j=0,k=0;
        list.add(arr[i][j]);
        while(list.size()<m*n){

            if(RIGHT){
                if(j+1<m-k){
                    j++;
                    list.add(arr[i][j]);
                    continue;
                }
                DOWN=true;
                RIGHT=false;
            }
            if(DOWN){
                if(i+1<n-k){
                    i++;
                    list.add(arr[i][j]);
                    continue;
                }
                DOWN=false;
                LEFT=true;
            }

            if(LEFT){
                if(j-1>=k){
                    j--;
                    list.add(arr[i][j]);
                    continue;
                }
                LEFT=false;
                UP=true;
            }

            if(UP){
                if(i-1>k){
                    i--;
                    list.add(arr[i][j]);
                    continue;
                }
                if(i-1==k){
                    k++;
                }
                UP=false;
                RIGHT=true;
            }

        }
        System.out.println(list);
        return list;

    }

    public int[] plusOne(int[] digits) {
        if(digits.length==0){
            return new int[]{1};
        }

        int x=0;
        int num;
        for(int i=digits.length-1;i>=0;i--){
            if(i==digits.length-1){
                num=digits[i]+1;
            }else{
                num=digits[i];
            }
            digits[i]=(x+num)%10;
            x=(num+x)/10;
        }
        if(x>0){
            int[] newDigits=new int[digits.length+1];
            newDigits[0]=x;
            for(int i=0;i<digits.length;i++){
                newDigits[i+1]=digits[i];
            }
            return newDigits;
        }

        return digits;
    }

    public String addStrings(String num1, String num2) {

        char[] c1=num1.toCharArray();
        char[] c2=num2.toCharArray();
        StringBuffer sb=new StringBuffer();
        int x=0;
        int i,j;
        for(i=c1.length-1,j=c2.length-1;i>=0&&j>=0;i--,j--){
            int num=c1[i]-'0'+c2[j]-'0'+x;
            sb.append(num%10);
            x=num/10;
        }
        if(i>=0){
            while(j>=0){
                int num=c2[j]-'0'+x;
                sb.append(num%10);
                x=num/10;
                j--;
            }


        }else if(i>=0){
            while(i>=0){
                int num=c1[i]-'0'+x;
                sb.append(num%10);
                x=num/10;
                i--;
            }
        }
        if(x>0){
            sb.append(x);
        }


        return sb.reverse().toString();
    }
}
