class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n*(n+1))/2];
        int[][] table = new int[n][n];
        int x = -1, y=0, num = 1;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else {
                    x--;
                    y--;
                }
                table[x][y] = num++;
                j++;
            }
        }

        int k = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(table[i][j] == 0)
                    break;
                answer[k++] = table[i][j];
            }
        }
        return answer;
    }
}