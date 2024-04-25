class Solution {

    public String solution(String s) {
        if (s.isEmpty()) {
            return s;
        }
        var idx = calculateSplitIdx(s);
        String u = s.substring(0, idx + 1);
        String v = s.substring(idx + 1);
        if (verifyCorrectString(u)) {
            return u + solution(v);
        }
        return "(" + solution(v) + ")" + reverse(u);
    }
    
    private int calculateSplitIdx(String s) {
        int countLeft = 0;
        int countRight = 0;
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                countLeft++;
            } else {
                countRight++;
            }
            if (countLeft == countRight) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    private boolean verifyCorrectString(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (right > left) {
                return false;
            }
        }
        return true;
    }

    private String reverse(String s) {
        var sb = new StringBuilder();
        for (int i = 1; i < s.length() - 1; i++) {
            sb.append(s.charAt(i) == '(' ? ')' : '(');
        }
        return sb.toString();
    }
}