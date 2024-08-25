package kakao.lv1;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {3, 1, 2, 3};
        int[] nums2 = {3, 3, 3, 2, 2, 4};
        int[] nums3 = {3, 3, 3, 2, 2, 2};

        System.out.println("solution(nums1) = " + solution(nums1));
        System.out.println("solution(nums2) = " + solution(nums2));
        System.out.println("solution(nums3) = " + solution(nums3));
    }

    private static int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int numsLength = nums.length / 2;

        return set.size() >= numsLength ? numsLength : set.size();
    }
}
