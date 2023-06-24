class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(String num:s.split(" ")){
            int n = Integer.parseInt(num);
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        sb.append(min).append(" ").append(max);
        return sb.toString();
    }
}