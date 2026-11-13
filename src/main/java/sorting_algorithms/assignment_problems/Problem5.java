package sorting_algorithms.assignment_problems;
public class Problem5 {
    static class Entry {
        String name;
        int marks;
        Entry(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }
        @Override
        public String toString() {
            return name + " " + marks;
        }
    }
    public static Entry[] leaderboard(Entry[] entries) {
        int[] count = new int[101];
        for (Entry entry : entries) {
            if (entry.marks < 0 || entry.marks > 100) {
                throw new IllegalArgumentException("Marks must be between 0 and 100");
            }
            int key = 100 - entry.marks;
            count[key]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        Entry[] result = new Entry[entries.length];
        for (int i = entries.length - 1; i >= 0; i--) {
            int key = 100 - entries[i].marks;
            int position = count[key] - 1;
            result[position] = entries[i];
            count[key]--;
        }
        return result;
    }
    public static void main(String[] args) {
        Entry[] entries = {
            new Entry("Asha", 90),
            new Entry("Ravi", 75),
            new Entry("Neha", 90),
            new Entry("Kiran", 100),
            new Entry("Meera", 75)
        };

        Entry[] sorted = leaderboard(entries);

        System.out.println("Contest Leaderboard:");

        for (Entry entry : sorted) {
            System.out.println(entry);
        }
    }
}
