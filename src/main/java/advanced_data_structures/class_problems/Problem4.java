package advanced_data_structures.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        List<int[]> rows = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            int start = line.indexOf('[');
            int end = line.indexOf(']');

            if (start < 0 || end < 0) {
                continue;
            }

            names.add(line.substring(0, start).trim());

            String[] values = line.substring(start + 1, end).split(",");
            int[] marks = new int[3];

            for (int j = 0; j < 3; j++) {
                marks[j] = Integer.parseInt(values[j].trim());
            }

            rows.add(marks);
        }

        sc.close();

        int n = names.size();

        if (n == 0) {
            return;
        }

        int[][] marks = new int[n][3];
        int[] totals = new int[n];
        int[] subjectTotals = new int[3];
        int topper = 0;

        for (int i = 0; i < n; i++) {
            marks[i] = rows.get(i);

            for (int j = 0; j < 3; j++) {
                totals[i] += marks[i][j];
                subjectTotals[j] += marks[i][j];
            }

            if (totals[i] > totals[topper]) {
                topper = i;
            }
        }

        System.out.print("Totals ");

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(", ");
            }

            System.out.print(names.get(i) + " " + totals[i]);
        }

        System.out.println();

        System.out.printf(
            Locale.US,
            "averages %.2f, %.2f, %.2f%n",
            (double) subjectTotals[0] / n,
            (double) subjectTotals[1] / n,
            (double) subjectTotals[2] / n
        );

        System.out.println(
            "topper " + names.get(topper) + " (" + totals[topper] + ")"
        );
    }
}