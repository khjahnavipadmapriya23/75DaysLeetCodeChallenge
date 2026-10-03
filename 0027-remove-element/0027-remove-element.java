class Solution {
    public int removeElement(int[] nums, int val) {
        int pos = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]!=val){
                count++;
                nums[pos] = nums[i];
                pos++;
            }
        }
        return count;
    }
}