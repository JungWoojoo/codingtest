package queue;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] arr1 = {1,1,3,3,0,1,1};
        int[] arr2 = {4,4,4,3,3};

        System.out.println("solution(arr1) = " + Arrays.toString(solution(arr1)));
        System.out.println("solution(arr2) = " + Arrays.toString(solution(arr2)));
    }
    public static int[] solution(int[] arr){
        int[] answer = {};
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new LinkedList<>();

        for (int i : arr) {
            deque.offer(i);
        }

        for (Integer i : deque) {
            if(list.isEmpty() || !deque.pop().equals(i)){
                list.add(i);
            }
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
