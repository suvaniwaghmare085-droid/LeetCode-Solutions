class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int first = -1;
        int last = -1;
        
        int low = 0;
        int high = nums.length - 1;
        
        // Find first occurrence
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } 
            else if (nums[mid] < target) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }
        
        low = 0;
        high = nums.length - 1;
        
        // Find last occurrence
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } 
            else if (nums[mid] < target) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }
        
        return new int[]{first, last};
    }
}