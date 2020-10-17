package LeetCode.Problems;

public class AddTwoNumbers {
//    You are given two non-empty linked lists representing two non-negative integers.
//    The digits are stored in reverse order, and each of their nodes contains a single digit.
//    Add the two numbers and return the sum as a linked list.
//
//    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//    Example 1:
//    Input: l1 = [2,4,3], l2 = [5,6,4]
//    Output: [7,0,8]
//    Explanation: 342 + 465 = 807.
//
//    Example 2:
//    Input: l1 = [0], l2 = [0]
//    Output: [0]
//
//    Example 3:
//    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//    Output: [8,9,9,9,0,0,0,1]

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
        int num1 = 0, num2 = 0;
        while(l1 != null){
            num1 = num1 * 10 + l1.val;
            l1= l1.next;
        }
        while(l2 != null){
            num2 = num2 * 10 + l2.val;
            l2 = l2.next;
        }
        num1 = reverse(num1);
        num2 = reverse(num2);
        var ans = num1 + num2;
        return createLL(ans);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode Head = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode currentNode = Head;
        int carry = 0;

        while (p1 != null || p2 != null) {
            int x = (p1 != null) ? p1.val : 0;
            int y = (p2 != null) ? p2.val : 0;
            int sum = x + y + carry;

            carry = (int)Math.floor(sum / 10);
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;

            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }

        if (carry > 0) {
            currentNode.next = new ListNode(1);
        }

        return Head.next;
    }

    private static ListNode createLL(int ans) {
        ListNode temp = new ListNode();
        ListNode head = temp;
        if(ans == 0){
            return new ListNode(0);
        }
        while(ans != 0){
            int t = ans % 10;
            ListNode node = new ListNode(t);
            temp.next = node;
            temp = temp.next;
            ans = ans / 10;
        }
        return head.next;
    }

    private static int reverse(int num) {
        int val = 0;
        while(num != 0){
            val = val * 10 + num % 10;
            num = num / 10;
        }
        return val;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(1,new ListNode(9,new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))))));
        ListNode ans = addTwoNumbers1(node1, node2);
        while(ans != null){
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}
