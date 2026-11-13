package sorting_algorithms.assignment_problems;
public class Problem3 {
    public static long countInversions(int[] roll) {
        if (roll == null || roll.length < 2) {
            return 0;
        }
        int[] temp = new int[roll.length];
        return mergeSort(roll, temp, 0, roll.length - 1);
    }
    private static long mergeSort(int[] roll, int[] temp, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        long count = 0;
        count += mergeSort(roll, temp, left, mid);
        count += mergeSort(roll, temp, mid + 1, right);
        count += merge(roll, temp, left, mid, right);

        return count;
    }
    private static long merge(int[] roll, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long inversions = 0;

        while (i <= mid && j <= right) {
            if (roll[i] <= roll[j]) {
                temp[k++] = roll[i++];
            } else {
                temp[k++] = roll[j++];
                inversions += mid - i + 1;
            }
        }

        while (i <= mid) {
            temp[k++] = roll[i++];
        }

        while (j <= right) {
            temp[k++] = roll[j++];
        }

        for (int index = left; index <= right; index++) {
            roll[index] = temp[index];
        }

        return inversions;
    }

    public static void main(String[] args) {
        int[] roll1 = {2, 4, 1, 3, 5};
        int[] roll2 = {5, 4, 3, 2, 1};

        System.out.println("Disorder score 1: "
                + countInversions(roll1));

        System.out.println("Disorder score 2: "
                + countInversions(roll2));
    }
}
