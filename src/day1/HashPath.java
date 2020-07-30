package day1;
public class HashPath {
    public boolean hasPath(char[][] matrix, String str) {
        // 遍历所有起点
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dfs(matrix, str, 0, i, j)) {// 0是目前遍历的str位置；i，j是遍历的起点
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] matrix, String str, int len, int i, int j){
        if (len == str.length() - 1) {// len是目前遍历到的str的位置
            return true;
        }
        if (matrix[i][j] != str.charAt(len)) {
            return false;
        }

        matrix[i][j] = '*';// 标记当前遍历的位置,防止重复访问
        int[][] dire = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int k = 0; k < 4; k++) {
            int newi = i + dire[k][0];
            int newj = j + dire[k][1];
            if (newi >= 0 && newj >= 0 && newi < matrix.length && newj < matrix[0].length
                    && matrix[newi][newj] != '*') {
                if (dfs(matrix, str, len + 1, newi, newj)) {
                    return true;
                }
            }
        }
        matrix[i][j] = str.charAt(len);
        return false;
    }
}
