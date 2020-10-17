package LeetCode.Problems;

import java.util.HashMap;

public class TwoSums {
    // PROBLEM
//    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//    You may assume that each input would have exactly one solution, and you may not use the same element twice.
//    You can return the answer in any order.
//    Example 1:
//    Input: nums = [2,7,11,15], target = 9
//    Output: [0,1]
//    Output: Because nums[0] + nums[1] == 9, we return [0, 1].
//
//    Example 2:
//    Input: nums = [3,2,4], target = 6
//    Output: [1,2]
//
//    Example 3:
//    Input: nums = [3,3], target = 6
//    Output: [0,1]
//    Constraints:
//      2 <= nums.length <= 105
//      -10^9 <= nums[i] <= 10^9
//      -10^9 <= target <= 10^9
//      Only one valid answer exists.

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i< nums.length;i++){
            map.put(nums[i],i);
        }
        int[] arr = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                if(map.get(target - nums[i]) != i){
                    arr[0] = i;
                    arr[1]= map.get(target - nums[i]);
                    break;
                }
            }
        }
        return arr;

    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{3,2,4}, 6));
    }

}
