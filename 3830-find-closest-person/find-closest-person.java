class Solution {
    // Method to find which of x or y is closer to z
    public int findClosest(int x, int y, int z) {
        return Math.abs(x - z) == Math.abs(y - z) ? 0 : (Math.abs(x - z) < Math.abs(y - z) ? 1 : 2);
    }
}