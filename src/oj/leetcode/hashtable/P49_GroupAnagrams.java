package oj.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author will
 * @date 2019/11/29
 */
public class P49_GroupAnagrams {

    static class Solution {

        private String sort(String str) {
            int len = str.length();
            if (len <= 1) {
                return str;
            }
            char[] arr = str.toCharArray();
            char x;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (arr[i] > arr[j]) {
                        x = arr[i]; arr[i] = arr[j]; arr[j] = x;
                    }
                }
            }

            return String.valueOf(arr);
        }

        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> ans = new ArrayList<>();
            int num = -1;
            Map<String, Integer> map = new HashMap<>();
            for (String str : strs) {
                String orderedStr = sort(str);
                if (map.containsKey(orderedStr)) {
                    int index = map.get(orderedStr);
                    ans.get(index).add(str);
                } else {
                    num++;
                    map.put(orderedStr, num);
                    List<String> l = new ArrayList<>();
                    l.add(str);
                    ans.add(l);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.sort("tea"));

//        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] str = {};

        List<List<String>> l = solution.groupAnagrams(str);

        System.out.println(l);


    }
}
