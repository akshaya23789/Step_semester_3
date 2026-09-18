package inheritance_and_polymorphism.class_problems;

import java.util.Arrays;

public class Problem3 {

    static class LibraryMember {
        private int[] fineHistory = new int[10];
        private int fineCount;

        protected void chargeFine(int amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Fine amount must be positive");
            }

            if (fineCount < fineHistory.length) {
                fineHistory[fineCount++] = amount;
            }
        }

        public int[] getFineHistory() {
            return Arrays.copyOf(fineHistory, fineCount);
        }

        public int getTotalFine() {
            int total = 0;

            for (int i = 0; i < fineCount; i++) {
                total += fineHistory[i];
            }

            return total;
        }
    }

    static class StudentMember extends LibraryMember {

        @Override
        protected void chargeFine(int amount) {
            super.chargeFine(amount / 2);
        }
    }

    public static void main(String[] args) {
        StudentMember student = new StudentMember();

        student.chargeFine(100);
        System.out.println(student.getTotalFine());

        int[] history = student.getFineHistory();
        history[0] = 999;

        System.out.println(Arrays.toString(student.getFineHistory()));
    }
}