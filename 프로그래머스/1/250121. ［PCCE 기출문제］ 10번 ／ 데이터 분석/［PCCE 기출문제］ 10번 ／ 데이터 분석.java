import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> dataType = new HashMap<>();
        
        dataType.put("code", 0);
        dataType.put("date", 1);
        dataType.put("maximum", 2);
        dataType.put("remain", 3);
        
        List<int[]> dataList = new ArrayList<>();
        int idx = dataType.get(ext);
        for(int[] d: data){
            if(d[idx] < val_ext){
                dataList.add(d);
            }
        }
        int res = dataType.get(sort_by);
        dataList.sort(Comparator.comparingInt(arr -> arr[res]));
        
        return dataList.toArray(new int[0][]);
    }
}