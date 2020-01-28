package com.algorithm;

import com.algorithm.Structure.ListNode;
import com.algorithm.Structure.TreeNode;

import java.util.*;

public class Tree {


    public static int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.push(root);
        TreeNode left=null;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode n=queue.pollFirst();
                if(i==0){
                    left=n;
                }
                if(n.left!=null){
                    queue.add(n.left);
                }
                if(n.right!=null){
                    queue.add(n.right);
                }
            }
        }
        return left.val;
    }

    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> totals=new ArrayList<>();

        LinkedList<TreeNode> queue=new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> subList=new ArrayList<>();
            for (int i=0;i<size;i++) {
                TreeNode n = queue.pop();
                subList.add(n.val);
                if (n.left != null) {
                    queue.add(n.left);
                }

                if (n.right != null) {
                    queue.add(n.right);
                }
            }
            totals.add(subList);
        }
        print(totals);
        return totals;

    }

    private static void print(List<List<Integer>> totals) {

        for (List<Integer> sub :totals){

            for (Integer val:sub){
                System.out.print(val+" ");
            }
            System.out.println("<==========>");
        }



    }


    public static TreeNode findClosestRoot(  TreeNode n,TreeNode left,TreeNode right){

        if (n==null){
            return null;
        }

        if(n.left==left&&n.right==right){
            return n;
        }

        if(n.left==left){
            return n;
        }

        if(n.right==right){
            return n;
        }


        TreeNode l=findClosestRoot(n.left,left,right);
        TreeNode r=findClosestRoot(n.right,left,right);
        return l==null?r:r==null?l:n;

    }

    //[1,1,1,1,2,2,3]
    public static int removeDuplicates(int[] nums) {
        int size = nums.length;
        int count = 1;
        int removeStartIndex = -1;
        int len = 0;
        for (int i = 1; i < nums.length; i++) {
            if(i==size){
                break;
            }
            if (nums[i - 1] == nums[i]) {
                count++;
            } else {
                if (count>=3){
                    for (int j =removeStartIndex+len; j < nums.length; j++) {
                        nums[j-len]=nums[j];
                    }
                    size-=len;
                    i=removeStartIndex;
                    removeStartIndex=-1;
                    len=0;
                }
                count=1;
            }
            if (count >= 3) {
                if (removeStartIndex == -1) {
                    removeStartIndex = i;
                }
                len++;

                if(i==size-1){
                    size-=len;
                    removeStartIndex=-1;
                    len=0;
                    count=1;
                }

            }



        }
        print(nums);
        return size;
    }

    public static void print(int[]arr){

        for (int num:arr){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        TreeNode root=new TreeNode(1);

        TreeNode l=new TreeNode(3);
        TreeNode r=new TreeNode(2);
        root.right=r;
        r.left=l;
        System.out.println(inorderTraversal(root));

//        TreeNode l11=new TreeNode(2);
//
//        TreeNode l12=new TreeNode(8);
//
//        TreeNode r11=new TreeNode(9);
//
//        TreeNode r12=new TreeNode(44);
//
//        root.left=l1;
//        root.right=r2;
//
//        l1.left=l11;
//        l1.right=l12;
//
//        r2.left=r11;
//        r2.right=r12;
//
//        //System.out.println(findClosestRoot(root,l11,r12));
//
//        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,2,3,3}));
//
//        System.out.println(containsNearbyAlmostDuplicate(new int[]{4,2},2,1));
//
//        levelOrder(root);
//        System.out.println("二叉树转化为单链表:");
//        levelOrder(flatten(root));
////        preOrder(root);
////        System.out.println();
////        System.out.println(maxDepth(root));
//        System.out.println("有序数组转化为二叉搜索树:");
//        levelOrder(new Tree().sortedArrayToBST(new int[]{-6,-3,-1,1,2,7,9}));
//
//       // System.out.println("有序单链表转化为二叉搜索树:");
//
//
//        TreeNode root2=new TreeNode(1);
//
//        TreeNode L1=new TreeNode(2);
//
//
//        root2.left=L1;
//
//        new Tree().zigzagLevelOrder(root2);
//        new Tree().pathSum(root2,1);
    }


    public int numPairsDivisibleBy60(int[] time) {
        int count=0;
        for (int i=0;i<time.length-1;i++){
            for(int j=i+1;j<time.length;j++){
                if((time[i]+time[j])%60==0){
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length==0||nums.length==1){
            return false;
        }

        TreeMap<Integer,List<Integer>> map=new TreeMap<>();
        int dij=0;

        for (int i=0;i<nums.length;i++){

            if (map.containsKey(nums[i])){
                List<Integer> list=map.get(nums[i]);
                list.add(i);
                map.put(nums[i],list);
            }else {
                List<Integer> list=new ArrayList<>();
                list.add(i);
                map.put(nums[i],list);
            }
        }
        for (Integer key:map.keySet()){
            for (int i=0;i<nums.length;i++) {
                if (Math.abs(key-nums[i])==t) {
                    List<Integer> list=map.get(key);
                    for (int j:list){
                        if(i==j){
                            continue;
                        }
                        dij=Math.max(dij,Math.abs(j-i));
                    }
                }
            }
        }

        return dij==k?true:false;
    }

    public static void preOrder(TreeNode n){
        if (n==null){
            return;
        }

        System.out.print(n.val+" ");
        preOrder(n.left);
        preOrder(n.right);

    }

    public static int order(TreeNode n){
        if (n==null){
            return 0;
        }

        System.out.print(n.val+" ");
        return Math.max(order(n.left)+1,order(n.right)+1);


    }

    public static int maxDepth(TreeNode root) {
        return order(root);

    }

    public static TreeNode flatten(TreeNode root) {

        TreeNode left=null;
        TreeNode right=null;
        if(root.left!=null){
            left=flatten(root.left);
            root.left=null;
        }
        if(root.right!=null){
            right=flatten(root.right);
        }

        if(left!=null&&right!=null){
            root.right=left;
            TreeNode last=left;
            while(last.right!=null){
                last=last.right;
            }
            last.right=right;
        }else if(left!=null){
            root.right=left;
        }else if(right!=null){
            root.right=right;
        }

        return root;



    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode n=stack.peek();
            TreeNode l=n.left;
            TreeNode r=n.right;

            if(l!=null){
                n.left=null;
                stack.push(l);
                continue;
            }
            stack.pop();
            list.add(n.val);
            if(r!=null){
                n.right=null;
                stack.push(r);
            }
        }
        return list;

    }

    public TreeNode sortedArrayToBST(int[] arr) {

        if (arr.length==0){
            return null;
        }
        return sortedArrayToBST(arr,0,arr.length-1);

    }

    public TreeNode sortedArrayToBST(int[] arr,int left,int right) {

        if(left>right){
            return null;
        }

        int mid=(left+right)/2;
        TreeNode node=new TreeNode(arr[mid]);
        TreeNode l=sortedArrayToBST(arr,left,mid-1);
        TreeNode r=sortedArrayToBST(arr,mid+1,right);
        node.left=l;
        node.right=r;
        return node;

    }

    //1->3->5->7->8->11
    public TreeNode sortedListToBST(ListNode head) {

        return sortedListToBST(head,null);

    }

    public TreeNode sortedListToBST(ListNode left, ListNode right) {

        ListNode prev=null;
        ListNode n1=left;
        ListNode n2=left;

        //尾节点
        while (n2!=null&&n2.next!=null){
            prev=n1;
            n1=n1.next;
            n2=n2.next.next;
        }
        //到达链表的中间位置
        ListNode mid=n1;
        TreeNode node=new TreeNode(mid.val);
        TreeNode l=sortedListToBST(left,prev);
        TreeNode r=sortedListToBST(left,n1.next);
        node.left=l;
        node.right=r;
        return node;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> total=levelOrder(root);
        List<List<Integer>> totals=new ArrayList<>();
        for(int j=0;j<total.size();j++){
            List<Integer> list=total.get(j);
            if ((j)%2!=0) {
                List<Integer> temp=new ArrayList<>();
                for (int i = list.size() - 1; i >= 0; i--) {
                    temp.add(list.get(i));
                }
                totals.add(temp);
            }else {
                totals.add(list);
            }
        }
        return totals;

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> list=new ArrayList<>();
        if(root!=null){
            List<Integer> l=new ArrayList<>();
            pathSum(root,sum,l,list);
        }
        return list;

    }

    private void pathSum(TreeNode node, int sum, List<Integer> tmp,List<List<Integer>> list) {

        if(node==null){
            return;
        }
        List<Integer> l=new ArrayList<>(tmp);
        l.add(node.val);
        if(sum==node.val&&node.left==null&&node.right==null) {
            list.add(l);
            return;
        }

        pathSum(node.left,sum-node.val,l,list);
        pathSum(node.right,sum-node.val,l,list);
    }

    public boolean hasPathSum(TreeNode root, int sum) {

        if(root==null){
            return false;
        }
        if(sum==root.val&&root.left==null&&root.right==null) {
            return true;
        }

        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }

    public int maxPathSum(TreeNode root) {

        if(root==null){
            return 0;
        }

        return Math.max(maxPathSum(root.left)+root.val,maxPathSum(root.right)+root.val);

    }

}
