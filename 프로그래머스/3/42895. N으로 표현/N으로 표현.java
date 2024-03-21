import java.util.*;

class Solution {

    public int solution(int n, int number) {
        if (n == number) {
            return 1;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        map.put(1, new HashSet<>());
        map.get(1).add(n);
        for (int i = 2; i <= 8; i++) {
            map.put(i, new HashSet<>());
            var set = map.get(i);
            set.add(getNumber(n, i));
            for (int j = 1; j < i; j++) {
                int k = i - j;
                for (int num1 : map.get(j)) {
                    for (int num2 : map.get(k)) {
                        set.add(num1 + num2);
                        set.add(num1 - num2);
                        set.add(num1 * num2);
                        if (num2 != 0) {
                            set.add(num1 / num2);
                        }
                    }
                }
            }
            if (set.contains(number)) {
                return i;
            }
        }
        return -1;
    }

    private int getNumber(int n, int depth) {
        StringBuilder sb = new StringBuilder();
        while(depth -- > 0){
            sb.append(n);
        }
        return Integer.parseInt(sb.toString());
    }
}