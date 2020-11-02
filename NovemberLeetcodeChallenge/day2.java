package LeetCode.NovemberLeetcodeChallenge;

import java.util.ArrayList;
import java.util.List;

public class day2 {
//    Sort a linked list using insertion sort.
//
//    Algorithm of Insertion Sort:
//    Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
//    At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
//    It repeats until no input elements remain.
//
//    Example 1:
//    Input: 4->2->1->3
//    Output: 1->2->3->4
//
//    Example 2:
//    Input: -1->5->3->4->0
//    Output: -1->0->3->4->5

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
    public static Integer[] LLtoArr(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Integer[] arr = new Integer[list.size()];
        arr = list.toArray(arr);
        return arr;
    }

    public static ListNode ArrayToLL(Integer[] arr) {
        if(arr.length == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    public static Integer[] InsertionSort(Integer[] arr) {
        int temp, j,k;
        for (int i = 1; i < arr.length; i++) {
            j = i - 1;
            k = i;
            while (j >= 0) {
                if(arr[j] > arr[k]) {
                    temp = arr[k];
                    arr[k] = arr[j];
                    arr[j] = temp;
                    k = j;
                }
                j--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Integer[] arr = InsertionSort(new Integer[]{0, 5, 2, 1, 8, 4, 6});
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }


}
