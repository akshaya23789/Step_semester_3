package data_structures.class_problems;
public class Problem5 {

    static int bruteForce(int[] heights) {
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int area = Math.min(heights[i], heights[j]) * (j - i);

                if (area > max)
                    max = area;
            }
        }

        return max;
    }

    static int maxContainerArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = 0;

        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);

            if (area > max)
                max = area;

            if (heights[left] < heights[right])
                left++;
            else
                right--;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println("Brute Force: " + bruteForce(heights));
        System.out.println("Max Container Area: " + maxContainerArea(heights));
    }
}