package hot100.Solution47;

// 这题是离散的知识，很难，一定要理解


import hot100.Solution36.TreeNode;
import java.util.*;

public class Solution {
    public Map<Integer, Integer> m = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) m.put(inorder[i], i);
        return myBuildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preleft, int preright, int inleft, int inright) {
        if (preleft > preright || inleft > inright) return null;
        int index = m.get(preorder[preleft]);
        int leftsize = index - inleft;
        TreeNode root = new TreeNode(preorder[preleft]);
        root.left = myBuildTree(preorder, inorder, preleft + 1, preleft + leftsize, inleft, inleft + leftsize - 1);
        root.right = myBuildTree(preorder, inorder, preleft + leftsize + 1, preright, inleft +leftsize +1, inright);
        return root;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};
        TreeNode root = solution.buildTree(preorder, inorder);
    }
}