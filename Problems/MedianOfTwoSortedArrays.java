package LeetCode.Problems;

public class MedianOfTwoSortedArrays {
//    Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//
//    Follow up: The overall run time complexity should be O(log (m+n)).
//
//    Example 1:
//    Input: nums1 = [1,3], nums2 = [2]
//    Output: 2.00000
//    Explanation: merged array = [1,2,3] and median is 2.
//
//    Example 2:
//    Input: nums1 = [1,2], nums2 = [3,4]
//    Output: 2.50000
//    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
//
//    Example 3:
//    Input: nums1 = [0,0], nums2 = [0,0]
//    Output: 0.00000
//
//    Example 4:
//    Input: nums1 = [], nums2 = [1]
//    Output: 1.00000
//
//    Example 5:
//    Input: nums1 = [2], nums2 = []
//    Output: 2.00000
//
//    Constraints:
//    nums1.length == m
//    nums2.length == n
//      0 <= m <= 1000
//      0 <= n <= 1000
//      1 <= m + n <= 2000
//      -10^6 <= nums1[i], nums2[i] <= 10^6

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0d;
        int i = 0, j = 0, k = 0;
        int[] merge = new int[nums1.length + nums2.length];
        // region : create a merged array using merge sort
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j])
                merge[k++] = nums1[i++];
            else
                merge[k++] = nums2[j++];
        }
        while(i < nums1.length){
            merge[k++] = nums1[i++];
        }
        while(j < nums2.length){
            merge[k++] = nums2[j++];
        }
        // region end
        if(merge.length > 1) { // to avoid arrayOutOfIndexException in case of single element
            // median calculation in case of even and odd sized array
            if (merge.length % 2 == 1) {
                median = merge[merge.length / 2];
            } else {
                median = merge[merge.length / 2] + merge[(int) Math.floor(merge.length / 2) - 1];
                median = median / 2;
            }
        }
        else{
            median = merge[0];
        }
        return median;
    }
    public static void main(String[] args){
        System.out.println(findMedianSortedArrays(new int[]{2}, new int[]{}));
    }
}
