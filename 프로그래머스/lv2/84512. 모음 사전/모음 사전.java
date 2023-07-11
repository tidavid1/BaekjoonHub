class Solution {
    public int solution(String word) {
        String alphabet = "AEIOU";
        int[] step = {781,156,31,6,1};
        int index,result=word.length();
		for(int i=0;i<word.length();i++){
			index = alphabet.indexOf(word.charAt(i));
			result+=step[i]*index;
		}
		return result;
    }
}