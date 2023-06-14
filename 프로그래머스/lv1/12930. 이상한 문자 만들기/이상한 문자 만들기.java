class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        boolean flag = true;
        StringBuilder sb = new StringBuilder();

        for (String c : s.split("")) {
            if (flag) {
                sb.append(c.toUpperCase());
            } else {
                sb.append(c);
            }

            flag = !flag;
            if (c.equals(" ")) {
                flag = true;
            }
        }

        return sb.toString();
    }
}