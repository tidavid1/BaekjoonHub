class Solution {
    public int solution(int x, int y, int n) {
        int[] table = new int[y + 1];
        for (int i = x + 1; i <= y; i++) {
            int a = i - n >= x ? table[i - n] : Integer.MAX_VALUE;
            int b = i / 2 >= x && i % 2 == 0 ? table[i / 2] : Integer.MAX_VALUE;
            int c = i / 3 >= x && i % 3 == 0 ? table[i / 3] : Integer.MAX_VALUE;

            int d = Math.min(a, Math.min(b,c));
            table[i] = (d < Integer.MAX_VALUE) ? d + 1 : Integer.MAX_VALUE;
        }
        return table[y] < Integer.MAX_VALUE ? table[y] : -1;
    }
}