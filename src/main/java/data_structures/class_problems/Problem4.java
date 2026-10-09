package data_structures.class_problems;
import java.util.HashSet;

public class Problem4 {

    static boolean bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return true;
            }
        }
        return false;
    }

    static boolean hashSetApproach(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(target - num))
                return true;
            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println(bruteForce(nums1, target1));

        int[] nums2 = {3, 4, 6};
        int target2 = 20;
        System.out.println(hashSetApproach(nums2, target2));
    }
}