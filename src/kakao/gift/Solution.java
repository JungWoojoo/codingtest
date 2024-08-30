package kakao.gift;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[] friends1 = {"muzi", "ryan", "frodo", "neo"};
        String[] friends2 = {"joy", "brad", "alessandro", "conan", "david"};
        String[] friends3 = {"a", "b", "c"};

        String[] gifts1 = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        String[] gifts2 = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        String[] gifts3 = {"a b", "b a", "c a", "a c", "a c", "c a"};

        System.out.println(solution(friends1, gifts1));
        System.out.println(solution(friends2, gifts2));
        System.out.println(solution(friends3, gifts3));
    }
    public static int solution(String[] friends, String[] gifts){
        int answer = 0;
        int friendsLength = friends.length;

        Map<String, Integer> friendsMap = new HashMap<>();
        int[] giftIndex = new int[friendsLength];
        int[][] graph = new int[friendsLength][friendsLength];

        // 친구들 이름 map (인덱싱 목적)
        for (int i = 0; i < friendsLength; i++) {
            friendsMap.put(friends[i], i);
        }

        // 선물 주고받은 내역 및 선물지수 담기
        for (String gift : gifts) {
            String[] giveAndTakeName = gift.split(" ");
            // 선물지수 map
            giftIndex[friendsMap.get(giveAndTakeName[0])]++;
            giftIndex[friendsMap.get(giveAndTakeName[1])]--;

            // 주고받은 내역 그래프
            graph[friendsMap.get(giveAndTakeName[0])][friendsMap.get(giveAndTakeName[1])]++;
        }

        for (int i = 0; i < friendsLength; i++) {
            int num = 0;
            for (int j = 0; j < friendsLength; j++) {
                //자기자신 비교 제외
                if(i == j){
                    continue;
                }

                // 준 것이 받은 것 많은 경우     이거나  주고 받은 것이 같을 때 선물지수가 높으면
                if(graph[i][j] > graph[j][i] || (graph[i][j] == graph[j][i] && giftIndex[i] > giftIndex[j])){
                    num++;
                }

            }
            if(num > answer){
                answer = num;
            }
        }
        return answer;
    }
}
