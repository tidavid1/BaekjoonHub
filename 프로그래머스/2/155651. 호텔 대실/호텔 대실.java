import java.util.*;

class Solution {

    private final Queue<BookTime> queue = new PriorityQueue<>();
    private final Queue<BookTime> table = new LinkedList<>();

    public int solution(String[][] book_time) {
        int result = 0;
        for (String[] arr : book_time) {
            var start = arr[0].split(":");
            var end = arr[1].split(":");
            int startHour = Integer.parseInt(start[0]);
            int startMinute = Integer.parseInt(start[1]);
            int endHour = Integer.parseInt(end[0]);
            int endMinute = Integer.parseInt(end[1]);
            var bookTime = new BookTime(startHour, startMinute, endHour, endMinute);
            queue.add(bookTime);
        }
        while (!queue.isEmpty()) {
            var bookTime = queue.poll();
            if (table.isEmpty()) {
                table.add(bookTime);
                result = result == 0 ? 1 : result;
            } else {
                int size = table.size();
                while (size-- > 0) {
                    var prevBookTime = table.poll();
                    if (prevBookTime.finishedYn(bookTime.startHour, bookTime.startMinute)) {
                        break;
                    } else {
                        table.add(prevBookTime);
                    }
                }
                table.add(bookTime);
                result = Math.max(result, table.size());
            }
        }
        return result;
    }

    private static class BookTime implements Comparable<BookTime> {

        int startHour;
        int startMinute;
        int endHour;
        int endMinute;

        public BookTime(int startHour, int startMinute, int endHour, int endMinute) {
            this.startHour = startHour;
            this.startMinute = startMinute;
            this.endHour = endHour;
            this.endMinute = endMinute;
        }

        public boolean finishedYn(int startHour, int startMinute) {
            int validateHour = this.endHour;
            int validateMinute = this.endMinute + 10;
            if (validateMinute >= 60) {
                validateHour += 1;
                validateMinute = validateMinute % 60;
            }
            if (validateHour == startHour) {
                return validateMinute <= startMinute;
            }
            return validateHour < startHour;
        }

        @Override
        public int compareTo(BookTime bookTime) {
            if (this.startHour == bookTime.startHour) {
                return Integer.compare(this.startMinute, bookTime.startMinute);
            }
            return Integer.compare(this.startHour, bookTime.startHour);
        }
    }
}
