package oj.leetcode.dp;

import java.util.Map;

/**
 *
 * 最长公共子串长度 基础dp
 *
 * @author will
 * @date 2019/12/3
 */
public class P718_MaximumLengthOfRepeatedSubarray {
    static class Solution {
        public int findLength(int[] A, int[] B) {
            int n = A.length;
            int m = B.length;

            // f[i][j] 代表 a[i] b[j]结尾的 最长公共子串的长度
            int[][] f = new int[n][m];

            int ans = 0;

            for (int j = 0; j < m; j++) {
                f[0][j] = A[0] == B[j] ? 1 : 0;
                ans = Math.max(ans, f[0][j]);
            }
            for (int i = 0; i < n; i++) {
                f[i][0] = A[i] == B[0] ? 1 : 0;
                ans = Math.max(ans, f[i][0]);
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    f[i][j] = A[i] == B[j] ? f[i-1][j-1] + 1 : 0;
                    ans = Math.max(ans, f[i][j]);
                }
            }


            return ans;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,2,1};
        int[] b = {3,2,1,4,7};
//        int[] a = {};
//        int[] b = {};

        Solution solution = new Solution();
        System.out.println(solution.findLength(a, b));

    }

}
