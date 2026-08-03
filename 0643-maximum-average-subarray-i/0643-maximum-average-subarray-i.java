class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double windowSum = 0;
        int n = nums.length;

        for(int i=0;i<k;i++){
            windowSum = windowSum + nums[i];
        }
        double max = windowSum/k;
        for(int i=k;i<n;i++){
            windowSum = windowSum + nums[i];
            windowSum = windowSum - nums[i-k];
            max = Math.max(windowSum/k,max);
        }
        return max;
    }
}