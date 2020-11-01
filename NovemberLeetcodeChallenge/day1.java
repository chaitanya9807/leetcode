package LeetCode.NovemberLeetcodeChallenge;

import java.math.BigDecimal;
import java.math.BigInteger;

public class day1  {
    //Given head which is a reference node to a singly-linked list.
    // The value of each node in the linked list is either 0 or 1.
    // The linked list holds the binary representation of a number.
    //Return the decimal value of the number in the linked list.
    //
    // Example 1:
    //Input: head = [1,0,1]
    //Output: 5
    //Explanation: (101) in base 2 = (5) in base 10
    //
    // Example 2:
    //Input: head = [0]
    //Output: 0
    //
    // Example 3:
    //Input: head = [1]
    //Output: 1
    //
    // Example 4:
    //Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
    //Output: 18880
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() { }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode arrayToLL(int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    public static BigInteger LLtoInt(ListNode listNode) { // biginteger to cater values outside of the range of long
        BigInteger ans = BigInteger.ZERO;
        while (listNode != null) {
            ans = ans.multiply(new BigInteger("10")).add(new BigInteger(String.valueOf(listNode.val)));
            listNode = listNode.next;
        }
        return ans;
    }

    public static BigInteger intTodecimal(BigInteger n) {
        BigInteger count = BigInteger.ONE;
        BigInteger ans = BigInteger.ZERO;
        while (n != BigInteger.ZERO) {
            BigInteger t = n.mod(BigInteger.TEN);
            ans = ans.add(t.multiply(count));
            count = count.multiply(BigInteger.TWO);
            n = n.divide(BigInteger.TEN);
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode listNode = arrayToLL(new int[]{1,0,1,0,0,1,1,1,0,1,1,0,0,0,0,0,0,0,0,1});
        BigInteger ans = LLtoInt(listNode);
        System.out.println(intTodecimal(ans).intValue());
    }

}
