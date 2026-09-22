class Solution {
    public void nextPermutation(int[] nums) {

        int n = nums.length;

        // 1. Find the first decreasing element from the right
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 2. If we found a decreasing element
        if (i >= 0) {

            // Find the smallest element greater than nums[i]
            // from the right side
            int j = n - 1;

            while (nums[j] <= nums[i]) {
                j--;
            }

            // Swap nums[i] and nums[j]
            swap(nums, i, j);
        }

        // 3. Reverse everything after i
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}