import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int[] temp = new int[elements.length * 2];
        Set<Integer> set = new HashSet<>();
        
        System.arraycopy(elements, 0, temp, 0, elements.length);
        System.arraycopy(elements, 0, temp, elements.length, elements.length);
        
        for(int i = 1; i <= elements.length; i++) {
            for(int j = 0; j < elements.length; j++) {
                set.add(Arrays.stream(temp, j, j+i).sum());
            }
        }
        return set.size();
    }
}