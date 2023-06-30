class Solution {
    public int[] solution(int n, long left, long right) {
        int[] table = new int[(int) ((right/n-left/n+1)*n)];
        int[] answer = new int[(int) (right-left+1)];
        int idx = 0;
        for(int i = (int) (left/n)+1;i<=(int) (right/n)+1;i++){
            for(int j=1;j<i;j++){
                table[idx++] = i;
            }
            for(int j = i; j<= n; j++){
                table[idx++] = j;
            }
        }
        System.arraycopy(table, (int) (left-(left/n)*n), answer, 0, answer.length);
        return answer;
    }
}