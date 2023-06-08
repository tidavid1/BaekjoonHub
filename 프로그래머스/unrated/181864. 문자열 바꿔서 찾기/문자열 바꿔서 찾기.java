class Solution {
    public int solution(String myString, String pat) {
        pat = pat.replace("A", "C").replace("B", "A").replace("C", "B");
        if(myString.contains(pat)){
            return 1;
        }
        return 0;
    }
}