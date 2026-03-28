class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int maxCount = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            int index = s.charAt(right) - 'A';
            freq[index]++;

            if (freq[index] > maxCount) {
                maxCount = freq[index];
            }

            while ((right - left + 1) - maxCount > k) {

                freq[s.charAt(left) - 'A']--;
                left++;
            }

            int length = right - left + 1;

            if (length > maxLength) {
                maxLength = length;
            }
        }

        return maxLength;
    }
}