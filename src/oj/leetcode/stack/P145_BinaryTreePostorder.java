package oj.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author will
 * @date 2019/12/21
 */
public class P145_BinaryTreePostorder {
    private static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }

    static class Solution {
        private void traverse(TreeNode p, List<Integer> list) {
            if (p == null) {
                return;
            }
            traverse(p.left, list);
            traverse(p.right, list);
            list.add(p.val);
        }

        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            traverse(root, ans);
            return ans;
        }
    }

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);

        p1.left = p2;
        p2.left = p4;
        p2.right = p5;
        p1.right = p3;

        List<Integer> list = new Solution().postorderTraversal(p1);
        for (Integer item : list) {
            System.out.println(item);
        }
    }
}
