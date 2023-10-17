class Solution {
    public int solution(int n, int[] stations, int w) {
        int count = 0;
        int range = 2 * w + 1;
        int min = 1;
        for (int station : stations) {
            int temp = Math.max(station - w - min, 0);
            count += temp / range;
            count += temp % range != 0 ? 1 : 0;
            min = station + w + 1;
        }
        if (min <= n) {
            int temp = n + 1 - min;
            count += temp / range;
            count += temp % range != 0 ? 1 : 0;
        }
        return count;
    }
}