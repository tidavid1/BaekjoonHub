import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] temp1 = splitStr(o1.toLowerCase());
                String[] temp2 = splitStr(o2.toLowerCase());
                int head = temp1[0].compareTo(temp2[0]);
                if(head == 0){
                    return Integer.parseInt(temp1[1]) - Integer.parseInt(temp2[1]);
                }
                return head;
            }

            String[] splitStr(String s){
                String[] returnValue = new String[2];
                int idx = 0;
                for(;idx<s.length();idx++){
                    if (s.substring(idx, idx+1).matches("[0-9]")){
                        returnValue[0] = s.substring(0, idx);
                        break;
                    }
                }
                for(int i = idx;i<s.length();i++){
                    if (!(s.substring(i, i+1).matches("[0-9]"))){
                        returnValue[1] = s.substring(idx, i);
                        break;
                    }
                }
                if(returnValue[1]==null){
                    returnValue[1] = s.substring(idx);
                }
                return returnValue;
            }
        });
        return files;
    }
}