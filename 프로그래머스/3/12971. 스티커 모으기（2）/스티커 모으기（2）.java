class Solution {
    public int solution(int[] stickers) {
        if (stickers.length == 1) {
            return stickers[0];
        }

        int[] table1 = new int[stickers.length];
        int[] table2 = new int[stickers.length];

        table1[0] = stickers[0];
        table1[1] = stickers[0];
        table2[0] = 0;
        table2[1] = stickers[1];
        for (int i = 2; i < stickers.length; i++) {
            table1[i] = Math.max(table1[i - 1], table1[i - 2] + stickers[i]);
            table2[i] = Math.max(table2[i - 1], table2[i - 2] + stickers[i]);
        }
        return Math.max(table1[stickers.length - 2], table2[stickers.length - 1]);
    }
}