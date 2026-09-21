class Solution {
    public int divide(int dividend, int divisor) {

        // Overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the answer
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to long and make both numbers positive
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long quotient = 0;

        // Keep subtracting the largest possible multiple of divisor
        while (a >= b) {

            long temp = b;
            long multiple = 1;

            // Double temp using left shift
            while ((temp << 1) <= a) {
                temp <<= 1;
                multiple <<= 1;
            }

            a -= temp;
            quotient += multiple;
        }

        // Apply the sign
        if (negative) {
            quotient = -quotient;
        }

        return (int) quotient;
    }
}