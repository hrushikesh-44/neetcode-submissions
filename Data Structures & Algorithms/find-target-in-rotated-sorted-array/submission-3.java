class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[end]){
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        int pivot = start;
        int ans = binarySearch(nums, 0, pivot - 1, target);
        if(ans != -1){
            return ans;
        } else {
            return binarySearch(nums, pivot, nums.length - 1, target);
        }
    }

    int binarySearch(int[] arr, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] > target){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
