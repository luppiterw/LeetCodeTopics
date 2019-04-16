package com.hughie.leet.algorithm;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 * */
public class P0002_AddTwoNumbers {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }

        public String toText() {

            StringBuilder builder = new StringBuilder();
            builder.append(val);
            if(next != null) builder.append("-").append(next.toText());
//        System.out.println("---> val=" + val + " " + builder.toString());
            return builder.toString();

        }

//    @Override
//    public String toString() {
//
//        StringBuilder builder = new StringBuilder();
//        builder.append(val);
//        if(next != null) builder.append(next.toString());
////        System.out.println("---> val=" + val + " " + builder.toString());
//        return builder.toString();
//
//    }
    }

    /**
     * 测试用例：
     * [0], [7,3]
     * [5], [5]
     * [9], [9,9]
     * 个人解法
     * */
//    public class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l2 == null) return l1;
//        if (l1 == null) l1 = new ListNode(0);

            System.out.println("pre l1=" + l1 + " l2=" + l2);
            if(l1.next == null && l2.next != null) l1.next = new ListNode(0);
            final int curCount = l1.val + l2.val;
            if (curCount >= 10) {
                l1.val = curCount % 10;
                if(l1.next == null) l1.next = new ListNode(0);
//            l1.next.val += 1;
                addTwoNumbers(l1.next, new ListNode(1));
            } else {
                l1.val = curCount;
                System.out.println("l1=" + l1.toText() +
                        " " + l1 + " l1.next=" + l1.next +
                        " " + l2 + " l2.next=" + l2.next);
            }
            addTwoNumbers(l1.next, l2.next);
            return l1;
        }

        /**
         * 官方解法
         * 就像你在纸上计算两个数字的和那样，我们首先从最低有效位也就是列表 l1l1 和 l2l2 的表头开始相加。
         * 由于每位数字都应当处于 0 \ldots 90…9 的范围内，我们计算两个数字的和时可能会出现“溢出”。
         * 例如，5 + 7 = 125+7=12。
         * 在这种情况下，我们会将当前位的数值设置为 22，并将进位 carry = 1carry=1 带入下一次迭代。
         * 进位 carrycarry 必定是 00 或 11，这是因为两个数字相加（考虑到进位）可能出现的最大和为 9 + 9 + 1 = 199+9+1=19。
         * */
        public static ListNode f1_addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode p = l1, q = l2, curr = dummyHead;
            int carry = 0;
            while (p != null || q != null) {
                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;
                int sum = carry + x + y;
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (p != null) p = p.next;
                if (q != null) q = q.next;
            }
            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
            return dummyHead.next;
        }
//    }
}
