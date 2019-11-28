package oj.leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author will
 * @date 2019/11/28
 */
public class P136SingleNumber {

    static class Solution {

//        public int singleNumber(int[] nums) {
//            HashMap<Integer, Integer> map = new HashMap<>();
//            for (int num : nums) {
//                if (map.containsKey(num)) {
//                    map.put(num, 2);
//                } else {
//                    map.put(num, 1);
//                }
//            }
//            for (int num : nums) {
//                if (map.get(num) == 1) {
//                    return num;
//                }
//            }
//            return 0;
//        }

        public int singleNumber(int[] nums) {
            int base = 0;
            for (int num : nums) {
                base ^= num;
            }
            return base;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        Solution s = new Solution();
        System.out.println(s.singleNumber(nums));
    }
}
