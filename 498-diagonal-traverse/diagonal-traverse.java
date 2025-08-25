public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int m = matrix.length, n = matrix[0].length;
        int[] result = new int[m * n];

        int row = 0, col = 0;
        boolean up = true;  // direction flag

        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[row][col];

            if (up) {
                // Moving up-right
                if (col == n - 1) { row++; up = false; }
                else if (row == 0) { col++; up = false; }
                else { row--; col++; }
            } else {
                // Moving down-left
                if (row == m - 1) { col++; up = true; }
                else if (col == 0) { row++; up = true; }
                else { row++; col--; }
            }
        }
        return result;
    }
}
