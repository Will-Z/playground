package oj.leetcode.hashtable;

import java.util.Stack;

/**
 * @author will
 * @date 2019/12/1
 */
public class P739_DailyTemperatures {

    // simple and violence solution
//    static class Solution {
//        public int[] dailyTemperatures(int[] T) {
//            int len = T.length;
//            int ans[] = new int [len];
//            for (int i = 0; i < len; i++) {
//                for (int j = i + 1; j < len; j++) {
//                    if (T[j] > T[i]) {
//                        ans[i] = j - i;
//                        break;
//                    }
//                }
//            }
//            return ans;
//        }
//    }
    // use stack
    static class Solution {
        public int[] dailyTemperatures(int[] T) {
            Stack<Integer> valueStack = new Stack<>();
            Stack<Integer> indexStack = new Stack<>();
            int len = T.length;
            int[] ans = new int[len];

            valueStack.push(T[0]);
            indexStack.push(0);
            for (int i = 1; i < len; i++) {
                if (T[i] > valueStack.peek()) {
                    while (!valueStack.empty() && T[i] > valueStack.peek()) {
                        valueStack.pop();
                        int index = indexStack.pop();
                        ans[index] = i - index;
                    }
                    valueStack.push(T[i]);
                    indexStack.push(i);
                } else {
                    valueStack.push(T[i]);
                    indexStack.push(i);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
//        int[] t = {1};
        int[] ans = solution.dailyTemperatures(t);
        System.out.println("ee");
    }
}
