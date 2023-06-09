class Solution {
    public int solution(String A, String B) {
        if(A.equals(B)) return 0;
        StringBuilder sb = new StringBuilder(A);
        for(int i=A.length()-1;i>=0;i--){
            sb.deleteCharAt(sb.length()-1);
            sb.insert(0, A.charAt(i));
            if(sb.toString().equals(B)) return A.length()-i;
        }
        return -1;
    }
}