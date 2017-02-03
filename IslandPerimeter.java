public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int n_lines = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                n_lines += 4;

                if (i != 0 && grid[i - 1][j] == 1) {
                    n_lines--;
                }
                if (i != grid.length - 1 && grid[i + 1][j] == 1) {
                    n_lines--;
                }

                 if (j != 0 && grid[i][j - 1] == 1) {
                    n_lines--;
                }
                if (j != grid[0].length - 1 && grid[i][j + 1] == 1) {
                    n_lines--;
                }
            }
        }
        return n_lines;
    }
}
