package so;

import java.util.Stack;

/**
 * [desc] 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 *
 * [analysis] 模拟
 *
 *
 * @author will
 * @date 2019/12/27
 */
public class DoubleStack2Queue {

    private static Stack<Integer> s1 = new Stack<>();
    private static Stack<Integer> s2 = new Stack<>();

    private void push(int num) {
        s1.push(num);
    }

    private int pop() {
        if (s1.isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int ans = s2.pop();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return ans;
    }

    public static void main(String[] args) {
        DoubleStack2Queue queue = new DoubleStack2Queue();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(5);
        queue.push(6);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
//        System.out.println(queue.pop());




    }



}
