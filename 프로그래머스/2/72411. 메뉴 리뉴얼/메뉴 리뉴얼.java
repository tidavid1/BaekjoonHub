import java.util.*;

class Solution {
    private Map<String, Integer> table;
    private int max;

    public String[] solution(String[] orders, int[] courses) {
        List<String> result = new ArrayList<>();
        orders = init(orders);
        for (int course : courses) {
            table = new HashMap<>();
            max = 0;
            for (String order : orders) {
                verifyCombination("", order, course);
            }
            table.forEach((key, value) -> {
                if (max > 1 && value == max) {
                    result.add(key);
                }
            });
        }
        result.sort(Comparator.naturalOrder());
        return result.toArray(new String[0]);
    }

    private String[] init(String[] orders) {
        String[] result = new String[orders.length];
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            result[i] = String.valueOf(arr);
        }
        return result;
    }
    
    private void verifyCombination(String menu, String order, int length) {
        if (length == 0) {
            int count = table.getOrDefault(menu, 0) + 1;
            table.put(menu, count);
            max = Math.max(count, max);
            return;
        }
        for (int i = 0; i < order.length(); i++) {
            verifyCombination(menu + order.charAt(i), order.substring(i + 1), length - 1);
        }
    }
}