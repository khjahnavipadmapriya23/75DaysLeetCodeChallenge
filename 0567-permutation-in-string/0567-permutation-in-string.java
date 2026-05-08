class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        // Store frequency of s1
        for (int i = 0; i < s1.length(); i++) {

            s1Count[s1.charAt(i) - 'a']++;

            windowCount[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (matches(s1Count, windowCount)) {
            return true;
        }

        // Sliding window
        for (int i = s1.length(); i < s2.length(); i++) {

            // Add new character
            windowCount[s2.charAt(i) - 'a']++;

            // Remove old character
            windowCount[s2.charAt(i - s1.length()) - 'a']--;

            // Compare frequencies
            if (matches(s1Count, windowCount)) {
                return true;
            }
        }

        return false;
    }

    // Helper method
    private boolean matches(int[] arr1, int[] arr2) {

        for (int i = 0; i < 26; i++) {

            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}