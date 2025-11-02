class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] visit = new int[m][n]; // 0 = empty, 1 = guarded, 2 = blocked
        int guardedCount = 0;

        // Mark all walls as blocked
        for (int[] wall : walls) {
            visit[wall[0]][wall[1]] = 2;
        }

        // Mark all guards as blocked
        for (int[] g : guards) {
            visit[g[0]][g[1]] = 2;
        }

        // Directions → up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // For each guard, spread in 4 directions
        for (int[] guard : guards) {
            int x = guard[0], y = guard[1];
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                while (nx >= 0 && nx < m && ny >= 0 && ny < n && visit[nx][ny] != 2) {
                    if (visit[nx][ny] == 0) {  // only count once
                        visit[nx][ny] = 1;
                        guardedCount++;
                    }
                    nx += dir[0];
                    ny += dir[1];
                }
            }
        }

        int total = m * n;
        int blocked = guards.length + walls.length;
        int unguarded = total - (blocked + guardedCount);
        return unguarded;
    }
}
