package algorithm12_20.ms;

import java.util.HashMap;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 * 
 * **/
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	private int in = 0;
    private int pre = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MAX_VALUE);
    }
    
    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length) return null;
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;        
    }
    
   /*
    public TreeNode buildTreeHashMap(int[] preorder, int[] inorder) {
        int[] start = new int[1];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) hm.put(inorder[i], i);
        return buildTree(preorder, inorder, 0, inorder.length - 1, start, hm);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int inS, int inE, int[] start, HashMap<Integer, Integer> inMap)
    {
        if(inS > inE) return null;
        TreeNode root = new TreeNode(preorder[start[0]++]);
        int mid = inMap.get(root.val);
        root.left = buildTree(preorder, inorder, inS, mid - 1, start, inMap);
        root.right = buildTree(preorder, inorder, mid + 1, inE, start, inMap);
        return root;
    }
    */
    
    Map<Integer, Integer> map = new HashMap<>();
    int preIndex;
    public TreeNode buildTreeMap(int[] preorder, int[] inorder) {
        preIndex = 0;
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return build(preorder, 0, inorder.length-1);
    }
    
    private TreeNode build(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) 
            return null;
        
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (inStart == inEnd) 
        {
        	return root;
        }
        
        int mid = map.get(root.val);    
        root.left =  build(preorder, inStart, mid-1);
        root.right =  build(preorder, mid+1, inEnd);
        
        return root;
    }
}
