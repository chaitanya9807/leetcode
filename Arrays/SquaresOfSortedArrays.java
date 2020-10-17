package LeetCode.Explore.Arrays;

public class SquaresOfSortedArrays {
    // PROBLEM
//    Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
//
//    Example 1:
//    Input: [-4,-1,0,3,10]
//    Output: [0,1,9,16,100]
//
//    Example 2:
//    Input: [-7,-3,2,3,11]
//    Output: [4,9,9,49,121]
//
//    Note:
//            1 <= A.length <= 10000
//            -10000 <= A[i] <= 10000
//    A is sorted in non-decreasing order.
    public static int[] sortDescendingSelectionSort(int[] arr){ // sorting array in ascending order
        int j = 0, min, k;
        while (j < arr.length) {
            min = arr[j];
            k = j;
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i] < min && arr[i] < arr[k]) {
                    k = i;
                    min = arr[k];
                }
            }
            int temp = arr[j];
            arr[j] = arr[k];
            arr[k] = temp;
            j++;
        }
        return arr;
    }
    public static int[] sortedSquares(int[] nums){ // function to create array of squares
        for (int i = 0; i < nums.length ; i++) {
            nums[i] = nums[i] * nums[i];
        }
        return sortDescendingSelectionSort(nums);
    }
    public static void main(String[] args){
        for(int a : sortedSquares(new int[]{3,6,1,8,6,3}))
        System.out.print(a + " ");
    }
}
