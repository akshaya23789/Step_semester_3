package abstraction.class_problems;

import java.util.*;

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

abstract class Question {
    String text;
    int marks;

    Question(String text, int marks) {
        this.text = text;
        this.marks = marks;
    }

    abstract boolean evaluate(String answer);
}

class MultipleChoiceQuestion extends Question {
    String correct;

    MultipleChoiceQuestion(String text, String correct, int marks) {
        super(text, marks);
        this.correct = correct;
    }

    boolean evaluate(String answer) {
        return correct.equalsIgnoreCase(answer);
    }
}

class TrueFalseQuestion extends Question {
    boolean correct;

    TrueFalseQuestion(String text, boolean correct, int marks) {
        super(text, marks);
        this.correct = correct;
    }

    boolean evaluate(String answer) {
        return Boolean.parseBoolean(answer) == correct;
    }
}

class ShortAnswerQuestion extends Question {
    String correct;

    ShortAnswerQuestion(String text, String correct, int marks) {
        super(text, marks);
        this.correct = correct;
    }

    boolean evaluate(String answer) {
        return correct.equalsIgnoreCase(answer);
    }
}

class Answer {
    Question question;
    String response;

    Answer(Question question, String response) {
        this.question = question;
        this.response = response;
    }

    int getScore() {
        return question.evaluate(response) ? question.marks : 0;
    }
}

class Examination {
    String name;
    ArrayList<Question> questions = new ArrayList<>();
    boolean submitted = false;

    Examination(String name) {
        this.name = name;
    }

    void addQuestion(Question question) {
        questions.add(question);
    }
}

class Attempt {
    Student student;
    Examination exam;
    ArrayList<Answer> answers = new ArrayList<>();
    String status = "InProgress";

    Attempt(Student student, Examination exam) {
        this.student = student;
        this.exam = exam;
    }

    void answer(Question question, String response) {
        if (status.equals("Submitted")) {
            System.out.println("Cannot change answers for a submitted examination.");
            return;
        }

        answers.add(new Answer(question, response));
        System.out.println("Answer recorded.");
    }

    void submit() {
        if (exam.submitted) {
            System.out.println("A submitted attempt already exists.");
            return;
        }

        status = "Submitted";
        exam.submitted = true;

        int total = 0;

        for (Answer answer : answers) {
            int score = answer.getScore();
            total += score;
            System.out.println("Question: " + score + " points");
        }

        System.out.println("Total score: " + total + "/" +
                exam.questions.size() * 5);
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Student s = new Student("Student 1");
        Examination exam = new Examination("Exam A");

        Question q1 = new MultipleChoiceQuestion(
                "Choose the correct option", "C", 5);

        Question q2 = new TrueFalseQuestion(
                "Java supports inheritance", false, 5);

        exam.addQuestion(q1);
        exam.addQuestion(q2);

        System.out.println("Exam A started by Student 1");

        Attempt attempt = new Attempt(s, exam);

        attempt.answer(q1, "C");
        attempt.answer(q2, "True");

        attempt.submit();

        attempt.answer(q1, "A");
    }
}