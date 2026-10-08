class Solution {
    public int pivotIndex(int[] nums) {        
        int sum = 0;

        for(int n : nums){
            sum += n;
        }

        int leftSum = 0;
        int rightSum = sum;

        for(int j = 0; j < nums.length; j++){
            rightSum -= nums[j];
            if(leftSum == rightSum){
                return j;
            }
            leftSum += nums[j];
        }
        return -1;
    }
}