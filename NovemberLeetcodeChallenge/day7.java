package LeetCode.NovemberLeetcodeChallenge;


import java.math.BigInteger;

public class day7 {
//    You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//    Follow up:
//    What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
//
//    Example:
//    Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//    Output: 7 -> 8 -> 0 -> 7

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        BigInteger num1 = BigInteger.ZERO, num2 = BigInteger.ZERO;
        while(l1 != null){
            num1 = num1.multiply(BigInteger.TEN).add(new BigInteger(String.valueOf(l1.val)));
            l1= l1.next;
        }
        while(l2 != null){
            num2 = num2.multiply(BigInteger.TEN).add(new BigInteger(String.valueOf(l2.val)));
            l2 = l2.next;
        }
        BigInteger ans = num1.add(num2);
        BigInteger n = new BigInteger(String.valueOf(ans));
        int digits = 0;
        while(n != BigInteger.ZERO){
            n=n.divide(BigInteger.TEN);
            digits++;
        }
        return createLL(reverse(ans),digits);
    }
    private static ListNode createLL(BigInteger ans,int digits) {
        ListNode temp = new ListNode();
        ListNode head = temp;
        if(ans == BigInteger.ZERO){
            return new ListNode(0);
        }
        long count = 0;
        while(count < digits || ans != BigInteger.ZERO){
            BigInteger t = ans.mod(BigInteger.TEN);
            ListNode node = new ListNode(t.intValue());
            temp.next = node;
            temp = temp.next;
            ans = ans.divide(BigInteger.TEN);
            count++;
        }
        return head.next;
    }

    private static BigInteger reverse(BigInteger num) {
        BigInteger val = BigInteger.ZERO;
        while(num != BigInteger.ZERO){
            val = val.multiply(BigInteger.TEN).add(num.mod(BigInteger.TEN));
            num = num.divide(BigInteger.TEN);
        }
        return val;
    }
    public static void main(String[] args){
        ListNode node1 = new ListNode(1, new ListNode(9,new ListNode(9, new ListNode(9))));
        ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode ans = addTwoNumbers1(node1, node2);
        while(ans != null){
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}
