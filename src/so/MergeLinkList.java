package so;

/**
 * [desc]
 *  合并两个有序链表
 *  输入两个单调不递减的链表,输出两个链表合并后的链表,合成后的链表满足单调不减规则.
 *
 *  [analysis] 简单归并; 相当于归并排序的一轮
 *
 *
 * @author will
 * @date 2020/1/1
 */
public class MergeLinkList {
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    ListNode merLisge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }


        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode h = null, t = null;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                if (t == null) {
                    h = t = p1;
                } else {
                    t.next = p1;
                    t = t.next;
                }
                    p1 = p1.next;
            } else {
                if (t == null) {
                    h = t = p2;
                } else {
                    t.next = p2;
                    t = t.next;
                }
                p2 = p2.next;

            }
        }
        if (p1 == null) {
            t.next = p2;
        }
        if (p2 == null) {
            t.next = p1;
        }
        return h;
    }

    public static void main(String[] args) {
        ListNode p11 = new ListNode(1);
        ListNode p13 = new ListNode(3);
        ListNode p14 = new ListNode(4);
        p11.next = p13; p13.next = p14;



        ListNode p22 = new ListNode(2);
        ListNode p24 = new ListNode(4);
        ListNode p26 = new ListNode(6);
        ListNode p27 = new ListNode(7);
        p22.next = p24; p24.next = p26; p26.next = p27;

//        ListNode h = new MergeLinkList().merLisge(p11, p22);


        ListNode h = new MergeLinkList().merLisge(null, null);

        System.out.println("dd");





    }

}
