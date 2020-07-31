package day1;

import java.util.Arrays;
public class BuildTree {
    public class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value){
            this.value = value;
        }
    }
    public  TreeNode buildTree(int[] preorder, int[] inorder){
        if (preorder == null || inorder == null ){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = getIndex(preorder,inorder);
        root.left = buildTree(Arrays.copyOfRange(preorder,1,index),Arrays.copyOfRange(inorder,0,index));
        root.right = buildTree(Arrays.copyOfRange(preorder,index + 1,preorder.length),Arrays.copyOfRange(inorder,index + 1,inorder.length));
        return root;
    }

    public int getIndex(int[] preorder, int[] inorder){
        for (int i = 0; i < inorder.length; i++){
            if (inorder[i] == preorder[0]){
                return i;
            }
        }
        return 0;
    }
}
