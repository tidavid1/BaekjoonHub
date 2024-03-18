class Solution {

    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};
    private int x;
    private int y;
    private int[][] board;
    private boolean[][] visitedRed;
    private boolean[][] visitedBlue;

    private int result = Integer.MAX_VALUE;

    public int solution(int[][] maze) {
        Node redNode = null;
        Node blueNode = null;
        board = maze;
        x = maze.length;
        y = maze[x - 1].length;
        visitedBlue = new boolean[x][y];
        visitedRed = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                switch (maze[i][j]) {
                    case 1 -> {
                        redNode = new Node(i, j);
                        visitedRed[i][j] = true;
                    }
                    case 2 -> {
                        blueNode = new Node(i, j);
                        visitedBlue[i][j] = true;
                    }
                }

            }
        }
        dfs(redNode.x, redNode.y, blueNode.x, blueNode.y, 0);
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    private void dfs(int redX, int redY, int blueX, int blueY, int depth) {
        visitedRed[redX][redY] = true;
        visitedBlue[blueX][blueY] = true;
        if (board[redX][redY] == 3 && board[blueX][blueY] == 4) {
            result = Math.min(result, depth);
        } else if (board[redX][redY] == 3) {
            for (int i = 0; i < DX.length; i++) {
                int blueDx = blueX + DX[i];
                int blueDy = blueY + DY[i];
                if (validateLocation(blueDx, blueDy) && !visitedBlue[blueDx][blueDy] && !(
                    redX == blueDx && redY == blueDy)) {
                    dfs(redX, redY, blueDx, blueDy, depth + 1);
                }
            }
        } else if (board[blueX][blueY] == 4) {
            for (int i = 0; i < DX.length; i++) {
                int redDx = redX + DX[i];
                int redDy = redY + DY[i];
                if (validateLocation(redDx, redDy) && !visitedRed[redDx][redDy] && !(blueX == redDx
                    && blueY == redDy)) {
                    dfs(redDx, redDy, blueX, blueY, depth + 1);
                }
            }
        } else {
            for (int i = 0; i < DX.length; i++) {
                int redDx = redX + DX[i];
                int redDy = redY + DY[i];
                if (validateLocation(redDx, redDy) && !visitedRed[redDx][redDy]) {
                    for (int j = 0; j < DX.length; j++) {
                        int blueDx = blueX + DX[j];
                        int blueDy = blueY + DY[j];
                        if (validateLocation(blueDx, blueDy) && !visitedBlue[blueDx][blueDy] && (
                            !(redDx == blueDx && redDy == blueDy) && (
                                !(redX == blueDx && redY == blueDy) || !(blueX == redDx
                                    && blueY == redDy)))) {
                            dfs(redDx, redDy, blueDx, blueDy, depth + 1);

                        }

                    }
                }
            }
        }
        visitedRed[redX][redY] = false;
        visitedBlue[blueX][blueY] = false;
    }

    private boolean validateLocation(int dx, int dy) {
        return dx >= 0 && dx < x && dy >= 0 && dy < y && board[dx][dy] != 5;
    }

    private static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}