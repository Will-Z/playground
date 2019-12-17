package oj.leetcode.linkedlist;

/**
 * @author will
 * @date 2019/12/17
 */
public class P1290_ConvertBinaryNumber {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        public int getDecimalValue(ListNode head) {
            ListNode p = head;
            int ans = 0;
            while (p != null) {
                ans = ans * 2 + p.val;
                p = p.next;
            }
            return ans;
        }
    }
}
