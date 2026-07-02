class Solution {
    private void bfs(int row, int col, int[][] grid, int[][] visit, int[] area) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        visit[row][col] = 1;
        area[0]++;
        queue.offer(new int[] {row, col});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];
            int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int r = x + dx[i], c = y + dy[i];
                if (r >= 0 && c >= 0 && r < n && c < m && 
                    grid[r][c] == 1 && visit[r][c] == 0) {
                    visit[r][c] = 1;
                    area[0]++;
                    queue.offer(new int[] {r, c});
                }
            }
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length, maxArea = 0;
        int visit[][] = new int[n][m];
        int[] area = new int[1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visit[i][j] == 0) {
                    area[0] = 0;
                    bfs(i, j, grid, visit, area);
                    maxArea = Math.max(maxArea, area[0]);
                }
            }
        }
        return maxArea;
    }
}
