package LeetCode.NovemberLeetcodeChallenge;

import java.util.ArrayList;
import java.util.Objects;

public class day8 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int totalTilt = 0;

    private int totalSum(TreeNode node) {
        if (node == null)
            return 0;

        int leftSum = this.totalSum(node.left);
        int rightSum = this.totalSum(node.right);
        int tilt = Math.abs(leftSum - rightSum);
        totalTilt += tilt;

        // return the sum of values starting from this node.
        return node.val + leftSum + rightSum;
    }

    public int findTilt(TreeNode root) {
        totalTilt = 0;
        totalSum(root);
        return totalTilt;
    }
}
