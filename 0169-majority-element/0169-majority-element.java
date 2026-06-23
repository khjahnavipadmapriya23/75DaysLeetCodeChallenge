import java.util.*;
class Solution {
    public int majorityElement(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
                int freqCount = map.getOrDefault(num,0)+1;
                map.put(num,freqCount);
            if(freqCount>nums.length/2)
                return num;
        }
        return -1;
    }
}