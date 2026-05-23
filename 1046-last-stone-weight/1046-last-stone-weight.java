import java.util.*;

class Solution {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones
        for (int stone : stones) {

            maxHeap.offer(stone);
        }

        // Smash until one or none remains
        while (maxHeap.size() > 1) {

            int y = maxHeap.poll(); // largest
            int x = maxHeap.poll(); // second largest

            // If not equal, add remaining weight
            if (y != x) {

                maxHeap.offer(y - x);
            }
        }

        // If empty return 0
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}