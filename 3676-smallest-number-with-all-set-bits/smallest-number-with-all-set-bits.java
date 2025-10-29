class Solution {
    public int smallestNumber(int n) {
        int p = 1;
        while (p <= n) p <<= 1;  // Find next power of 2 greater than n
        return p - 1;            // Number with all bits = 1
    }
}
