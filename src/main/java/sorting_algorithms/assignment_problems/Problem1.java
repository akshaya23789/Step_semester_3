package sorting_algorithms.assignment_problems;
public class Problem1 {
    public static int[] bubbleStats(int[] scores) {
        int passes = 0;
        int swaps = 0;
        for (int i = 0; i < scores.length; i++) {
            boolean swapped = false;
            passes++;
            for (int j = 0; j < scores.length - 1 - i; j++) {
                if (scores[j] > scores[j + 1]) {
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return new int[]{passes, swaps};
    }
    public static void printScores(int[] scores) {
        System.out.print("[");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i]);
            if (i < scores.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        int[] scores1 = {5, 1, 4, 2, 8};
        int[] result1 = bubbleStats(scores1);

        System.out.print("Sorted scores: ");
        printScores(scores1);
        System.out.println("Passes: " + result1[0]);
        System.out.println("Swaps: " + result1[1]);

        System.out.println();

        int[] scores2 = {1, 2, 3, 4};
        int[] result2 = bubbleStats(scores2);

        System.out.print("Sorted scores: ");
        printScores(scores2);
        System.out.println("Passes: " + result2[0]);
        System.out.println("Swaps: " + result2[1]);
    }
}
