class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for(int i = 0; i < n; i++){
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for(int j = 0; j < n; j++){
            if(prefix[n] - prefix[j + 1] == prefix[j]){
                return j;
            }
        }
        return -1;
    }
}