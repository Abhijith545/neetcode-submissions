class Solution {
    private void bfs(int row, int col, char[][] grid, int[][] visit) {
        Queue<int[]> queue = new ArrayDeque<>();
        int n = grid.length, m = grid[0].length;
        queue.offer(new int[] {row, col});
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + r, y = dy[i] + c;
                if (x >= 0 && x < n && y >= 0 && y < m && 
                    grid[x][y] == '1' && visit[x][y] == 0) {
                    visit[x][y] = 1;
                    queue.add(new int[] {x, y});
                }
            }
        }
    }

    private void dfs(int row, int col, char[][] grid, int[][] visit) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0' || visit[row][col] == 1) return;
        visit[row][col] = 1;
        dfs(row - 1, col, grid, visit);
        dfs(row + 1, col, grid, visit);
        dfs(row, col - 1, grid, visit);
        dfs(row, col + 1, grid, visit);
    }

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] visit = new int[n][m];
        int islands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] == 0 && grid[i][j] == '1') {
                    islands++;
                    // bfs(i, j, grid, visit);
                    dfs(i, j, grid, visit);
                }
            }
        }
        return islands;
    }
}
