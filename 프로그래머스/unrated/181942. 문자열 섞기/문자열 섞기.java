class Solution {
    public String solution(String str1, String str2) {
        char[] temp1 = str1.toCharArray();
        char[] temp2 = str2.toCharArray();
        char[] answer = new char[temp1.length+temp2.length];
        int idx = 0;
        for(int i=0;i<temp1.length;i++){
            answer[idx++] = temp1[i];
            answer[idx++] = temp2[i];
        }
        return new String(answer);
    }
}