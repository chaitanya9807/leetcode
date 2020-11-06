package LeetCode.NovemberLeetcodeChallenge;

public class day6 {
    public int divideArraySum(int[] arr, int n) {
        int sum = 0;
        for (int a : arr) {
            if (a % n == 0) {
                sum += a / n;
            } else {
                sum += a / n + 1;
            }
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = nums[nums.length - 1];
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int num = divideArraySum(nums, mid);

            if (num > threshold) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // at the end of loop, left > right,
        // computeSum(right) > threshold
        // computeSum(left) <= threshold
        // --> return left
        return left;
    }
}
