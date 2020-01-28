package com.algorithm.backtrack;

import java.util.*;

public class Test {

    private static Map<Character,Character> mapping;

    private static Map<Character,String> phone;


    static {

        mapping=new HashMap<>();
        mapping.put('{','}');
        mapping.put('(',')');
        mapping.put('[',']');

        phone=new HashMap<>();
        phone.put('2',"abc");
        phone.put('3',"def");
        phone.put('4',"ghi");
        phone.put('5',"jkl");
        phone.put('6',"mno");
        phone.put('7',"pqrs");
        phone.put('8',"tuv");
        phone.put('9',"wxyz");


    }



    public static boolean valid(String s) {
        Stack<Character> stack=new Stack<>();
        int c1=0,c2=0;
        for (Character c:s.toCharArray()){

            if (c=='('){
                c1++;
            }

            if (c==')'){
                c2++;
            }

            if(c1>s.length()/2||c2>s.length()/2){
                return false;
            }
            if (stack.size()==0){
                stack.push(c);
            }else if (((mapping.get(stack.peek()))==c)){
                stack.pop();
            }else{
                stack.push(c);
            }

        }
        return stack.size()==0?true:false;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        Character character;
        for (Character c:s.toCharArray()){

            if (stack.size()==0){
                stack.push(c);
            }else if (((mapping.get(stack.peek()))==c)){
                stack.pop();
            }else{
                stack.push(c);
            }

        }
        return stack.size()==0?true:false;
    }

    public static List<String> generateParenthesis(int n) {

     HashSet<String> set=new HashSet<>();
     StringBuffer subStr=new StringBuffer();
     generateParenthesis(0,2*n,set,subStr);
     return new ArrayList<>(set);
    }


    private static void generateParenthesis(int i, int len,HashSet<String> set, StringBuffer subStr) {

        if (i==len){
            String str=subStr.toString();
            if(valid(str)){
                set.add(str);
            }
            return;
        }
        StringBuffer newSub=new StringBuffer(subStr);
        newSub.append("(");
        int temp=i;
        generateParenthesis(temp+1,len,set,newSub);
        newSub=new StringBuffer(subStr);
        newSub.append(")");
        generateParenthesis(temp+1,len,set,newSub);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> stringList=new ArrayList<>();

        if(digits==null||digits.isEmpty()){
            return stringList;
        }

        LinkedList<String> nums=new LinkedList<>();


        for (Character c:digits.toCharArray()){
            nums.add(phone.get(c));
        }
        StringBuffer sb=new StringBuffer();
        letterCombinations(sb,nums,stringList);
        return  stringList;
    }

    private static void letterCombinations(StringBuffer sb,LinkedList<String> nums, List<String> stringList) {

        if(nums.size()==0){
            stringList.add(sb.toString());
            return;
        }
        String str=nums.remove();
        for (int i=0;i<str.length();i++){
            LinkedList<String> newNums=new LinkedList<>(nums);
            StringBuffer newStr=new StringBuffer(sb);
            newStr.append(str.charAt(i));
            letterCombinations(newStr,newNums,stringList);
        }


    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));

       // System.out.println(generateParenthesis(8));

        //System.out.println(letterCombinations("23"));
        //System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5},8));

        System.out.println(combinationSum3(3,9));

        new Test().longestCommonSubsequence("bsbininm"
                ,"jmjkbkjkv");
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        //System.out.println(candidates);
        backtrack(candidates, target, res, 0, new ArrayList<Integer>());
        return res;
    }

    private static void backtrack(int[] candidates, int target, List<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int start = i; start < candidates.length; start++) {
           // if (target < candidates[start]) break;
            //System.out.println(start);
            tmp_list.add(candidates[start]);
            //System.out.println(tmp_list);
            backtrack(candidates, target - candidates[start], res, start, tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        //System.out.println(candidates);
        boolean[] visited=new boolean[candidates.length];
        backtrack2(candidates,visited, target, res, 0, new ArrayList<Integer>());
        return res;
    }

    private static void backtrack2(int[] candidates,boolean[] visited,int target, List<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
        if (target < 0) return;
        if (target == 0) {
            if(!res.contains(tmp_list)) {
                res.add(new ArrayList<>(tmp_list));
            }
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            // if (target < candidates[start]) break;
            //System.out.println(start);
            if (!visited[start]) {
                tmp_list.add(candidates[start]);
                visited[start]=true;
                //System.out.println(tmp_list);
                backtrack2(candidates, visited,target - candidates[start], res, start, tmp_list);
                tmp_list.remove(tmp_list.size() - 1);
                visited[start]=false;
            }
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {

        int [] candidates=new int[9];
        for(int i=0;i<9;i++){
            candidates[i]=i+1;
        }

        List<List<Integer>> res = new ArrayList<>();
        //System.out.println(candidates);
        boolean[] visited=new boolean[candidates.length];
        backtrack3(candidates,visited, n,k, res, 0, new ArrayList<Integer>());
        return res;
    }

    private static void backtrack3(int[] candidates,boolean[] visited,int target,int len,List<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
        if (target < 0) return;
        if (target == 0) {
            if(!res.contains(tmp_list)&&tmp_list.size()==len) {
                res.add(new ArrayList<>(tmp_list));
            }
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            // if (target < candidates[start]) break;
            //System.out.println(start);
            if (!visited[start]) {
                tmp_list.add(candidates[start]);
                visited[start]=true;
                //System.out.println(tmp_list);
                backtrack3(candidates, visited,target - candidates[start],len, res, start, tmp_list);
                tmp_list.remove(tmp_list.size() - 1);
                visited[start]=false;
            }
        }
    }


    public void print (int[][] map){

        for (int[] arr:map){
            System.out.print("[ ");
            for (int i:arr){
                System.out.print(i+" ");
            }
            System.out.println("]");
        }
    }

    public int minPathSum(int[][] grid) {


        return minPathSum(grid,0,0);

    }

    public int minPathSum(int[][] grid,int i,int j) {

        if(i>grid.length-1||j>grid[0].length-1){
            return Integer.MAX_VALUE;
        }

        if(i==grid.length-1&&j==grid[0].length-1){
            return grid[i][j];
        }
        return grid[i][j]+Math.min(minPathSum(grid,i+1,j),minPathSum(grid,i,j+1));
    }

    public int uniquePaths(int m, int n) {

        int[][] dp=new int[m][n];

        for (int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }

        for (int j=0;j<dp[0].length;j++){
            dp[0][j]=1;
        }

        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[0].length;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }

    public List<List<Integer>> subsets(int[] nums) {

        boolean[]visited=new boolean[nums.length];
        List<List<Integer>> total=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        subsets(0,list,total,nums,visited);
        return total;
    }

    private void subsets(int start,ArrayList<Integer> list, List<List<Integer>> total, int[] nums, boolean[] visited) {

        for (int i=start;i<nums.length;i++){
            if(!visited[i]){
                ArrayList temp=new ArrayList<>(list);
                list.add(nums[i]);
                visited[i]=true;
                subsets(i+1,temp, total, nums, visited);
                visited[i]=false;
            }
        }

        if(list.size()==nums.length&&!total.contains(list)){
            total.add(list);
        }

    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int[] rs=new int[2];
        for(int i=0;i<numbers.length;i++){
            int num=target-numbers[i];
            if(!map.containsKey(num)){
                map.put(numbers[i],i);
            }else{
                rs[0]=map.get(num);
                rs[1]=i;
            }
        }
        return rs;

    }


    public int longestCommonSubsequence(String text1, String text2) {

        int [][] dp=new int[text1.length()+1][text2.length()+1];

        for (int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }

        for (int i=0;i<dp[0].length;i++){
            dp[0][i]=0;
        }

        for (int i=1;i<dp.length;i++) {
            for (int j = 1; j<dp[0].length;j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] =dp[i-1][j-1]+1;
                }else {
                    dp[i][j] =Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

}
