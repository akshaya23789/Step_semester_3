package sorting_algorithms.assignment_problems;
public class Problem4 {
    public static int kthHighest(int[] marks, int k) {
        if (marks == null || k < 1 || k > marks.length) {
            throw new IllegalArgumentException("Invalid marks or k");
        }

        int targetIndex = marks.length - k;
        int left = 0;
        int right = marks.length - 1;

        while (left <= right) {
            int pivotIndex = partition(marks, left, right);

            if (pivotIndex == targetIndex) {
                return marks[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        throw new IllegalStateException("Selection failed");
    }

    private static int partition(int[] marks, int left, int right) {
        int pivot = marks[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (marks[j] <= pivot) {
                i++;

                int temp = marks[i];
                marks[i] = marks[j];
                marks[j] = temp;
            }
        }

        int temp = marks[i + 1];
        marks[i + 1] = marks[right];
        marks[right] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] marks1 = {72, 95, 60, 88, 79};
        int[] marks2 = {50, 90, 90, 70};

        System.out.println("2nd highest mark: "
                + kthHighest(marks1, 2));

        System.out.println("2nd highest mark with duplicates: "
                + kthHighest(marks2, 2));
    }
}
