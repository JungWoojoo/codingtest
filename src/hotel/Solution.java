package hotel;

import java.time.LocalTime;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        String[][] book_time = new String[1][5];
        book_time[0][0] = "15:00, 17:00";
        book_time[0][1] = "16:40, 18:20";
        book_time[0][2] = "14:20, 15:20";
        book_time[0][3] = "14:10, 19:20";
        book_time[0][4] = "18:20, 21:20";

        solution(book_time);
        int solution = solution(book_time);
        System.out.println("solution = " + solution);
    }

    public static int solution(String[][] book_time){
        int answer = 0;

        LocalTime targetTime = null;
        for (String[] bookings : book_time) {
            
            for (String book : bookings) {
                String[] startAndEnd = book.split(",");
                String[] start = startAndEnd[0].split(":");
                String[] end = startAndEnd[1].trim().split(":");

                LocalTime startTime = LocalTime.of(Integer.parseInt(start[0]), Integer.parseInt(start[1]));
                LocalTime endTime = LocalTime.of(Integer.parseInt(end[0]), Integer.parseInt(end[1]) + 10);

                if(targetTime == null){
                    targetTime = endTime;
                }

                boolean isUse = startTime.isBefore(targetTime);
                if(isUse){
                    answer++;
                }
            }
        }

        return answer;
    }
}
