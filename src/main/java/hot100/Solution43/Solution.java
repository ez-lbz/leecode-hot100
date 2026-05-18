package hot100.Solution43;

import hot100.Solution36.TreeNode;

public class Solution {
    boolean success = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        int[] minmax = new int[]{root.val, root.val};
        int[] left = new int[2];
        if (root.left != null) {
            left = dfs(root.left);
            minmax[0] = left[0];
            if (left[1] >= root.val) success = false;
        }
        int[] right = new int[2];
        if (root.right != null) {
            right = dfs(root.right);
            minmax[1] = right[1];
            if (right[0] <= root.val) success = false;
        }
        return success;
    }

    public int[] dfs(TreeNode root) {
        if (!success) return new int[]{0, 0};
        int[] minmax = new int[]{root.val, root.val};
        int[] left = new int[2];
        if (root.left != null) {
            left = dfs(root.left);
            minmax[0] = left[0];
            if (left[1] >= root.val) success = false;
        }
        int[] right = new int[2];
        if (root.right != null) {
            right = dfs(root.right);
            minmax[1] = right[1];
            if (right[0] <= root.val) success = false;
        }
        return minmax;
    }
}