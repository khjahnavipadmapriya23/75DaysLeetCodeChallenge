class Solution {

    public int[][] floodFill(int[][] image,
                             int sr,
                             int sc,
                             int color) {

        int original = image[sr][sc];

        // Avoid infinite recursion
        if (original == color) {

            return image;
        }

        dfs(image, sr, sc, original, color);

        return image;
    }

    public void dfs(int[][] image,
                    int row,
                    int col,
                    int original,
                    int color) {

        // Boundary check
        if (row < 0 || col < 0 ||
            row >= image.length ||
            col >= image[0].length) {

            return;
        }

        // Different color -> stop
        if (image[row][col] != original) {

            return;
        }

        // Fill color
        image[row][col] = color;

        // Explore 4 directions
        dfs(image, row + 1, col, original, color);
        dfs(image, row - 1, col, original, color);
        dfs(image, row, col + 1, original, color);
        dfs(image, row, col - 1, original, color);
    }
}