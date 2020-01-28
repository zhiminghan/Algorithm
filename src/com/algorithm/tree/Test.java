package com.algorithm.tree;

import com.algorithm.Structure.TreeNode;

public class Test {

    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p, TreeNode q) {

        if(parent(p,q)!=null){
            return p;
        }

        if(parent(q,p)!=null){
            return q;
        }
        return lowestCommonAncestor2(root,p,q);
    }
        public TreeNode lowestCommonAncestor2(TreeNode root,TreeNode p, TreeNode q) {


        if (root==null){
            return null;
        }

        if (root==p||root==q){
            return root;
        }

        TreeNode n1=lowestCommonAncestor2(root.left,p,q);
        TreeNode n2=lowestCommonAncestor2(root.right,p,q);

        if(n1!=p&&n1!=q){
            return n1;
        }

        if(n2!=p&&n2!=q){
            return n2;
        }

        if(n1!=null&&n2!=null){
            return root;
        }


        return null;
    }

    public TreeNode parent(TreeNode p, TreeNode q){
        if(p==null){
            return null;
        }

        if(p==q){
            return p;
        }

        return (parent(p.left,q)!=null||parent(p.right,q)!=null)?p:null;
    }

    public int maxDepth(TreeNode root) {

        if(root==null) {
            return 0;
        }
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }

    public static void main(String[] args) {

         TreeNode root=new TreeNode(1);
        TreeNode l1=new TreeNode(2);
        TreeNode r1=new TreeNode(3);

        TreeNode l2=new TreeNode(4);
        TreeNode r2=new TreeNode(5);

        TreeNode l3=new TreeNode(6);
        TreeNode r3=new TreeNode(7);
        root.left=l1;
        root.right=r1;
        l1.left=l2;
        l1.right=r2;
        l2.left=l3;
        l3.right=r3;
        System.out.println(new Test().maxDepth(root));
    }

  /*  public TreeNode flatten(TreeNode root) {

        TreeNode left=null;
        TreeNode right=null;
        if(root.left!=null){
            left=flatten(root.left);
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
        }

        if(left!=null){
            root.right=left;
        }

        if(right!=null){
            root.right=right;
        }

        return root;
    }
*/
}
