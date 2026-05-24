import java.util.*;

class Solution {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap =
            new PriorityQueue<>();

        for (int num : nums) {

            minHeap.offer(num);

            // Keep heap size k only
            if (minHeap.size() > k) {

                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}