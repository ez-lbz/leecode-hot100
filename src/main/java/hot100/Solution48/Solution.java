package hot100.Solution48;

// 深搜的思路，有点绕

import hot100.Solution36.TreeNode;

public class Solution {
    // 傻逼卡常，必须long
    public int nodeSum(TreeNode root, long targetSum) {
        if (root == null) return 0;
        // 这里是坑
        int count = 0;
        if (root.val == targetSum) count = 1;
        return count + nodeSum(root.left, targetSum - root.val) + nodeSum(root.right, targetSum- root.val);
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return nodeSum(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
}