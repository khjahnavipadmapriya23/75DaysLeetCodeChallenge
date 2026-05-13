class Solution {
    public int reverse(int x) {

        int revN = 0;

        while (x != 0) {

            int lastDigit = x % 10;

            // Overflow check
            if (revN > Integer.MAX_VALUE / 10 || 
               (revN == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0;
            }

            // Underflow check
            if (revN < Integer.MIN_VALUE / 10 || 
               (revN == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
                return 0;
            }

            revN = (revN * 10) + lastDigit;

            x = x / 10;
        }

        return revN;
    }
}