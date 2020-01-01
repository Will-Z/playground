package so;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [desc]
 *      输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 *      例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *      （注意：这两个序列的长度是相等的）
 * [analysis]
 *      模拟
 *
 *
 * @author will
 * @date 2019/12/30
 */
public class StackOrder {
    private boolean pd(List<Integer> l1, List<Integer> l2) {
        if (l1 == null || l2 == null || l1.size() == 0) {
            return true;
        }
        Stack<Integer> s = new Stack<>();
        int n = l1.size();
        int p1 = 0;
        int p2 = 0;
        for (;;) {
            if (s.isEmpty()) {
                s.push(l1.get(p1));
                p1++;
            }
            if (s.peek().equals(l2.get(p2))) {
                while (!s.isEmpty() && s.peek().equals(l2.get(p2))) {
                    s.pop();
                    p2++;
                }
            }
            if (p1 == n ) {
                return s.isEmpty();
            }
            s.push(l1.get(p1));
            p1++;
        }
    }

    public static void main(String[] args) {
//        int[] arr1 = new int[]{1,2,3,4,5};
//        int[] arr2 = new int[]{4,5,3,2,1};
//        int[] arr2 = new int[] {4,3,5,1,2};
        int[] arr1 = new int[] {};
        int[] arr2 = new int[] {};
        List<Integer> l1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        List<Integer> l2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        System.out.println(new StackOrder().pd(l1, l2));
    }




}
