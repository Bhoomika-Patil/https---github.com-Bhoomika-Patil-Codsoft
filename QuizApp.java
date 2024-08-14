import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    static Scanner scanner = new Scanner(System.in);
    static int score = 0;
    static int questionIndex = 0;
    static boolean answered = false;

    public static void main(String[] args) {
        String[] questions = {
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "Who wrote 'Hamlet'?",
            "What is the largest ocean on Earth?",
            "What is the square root of 64?"
        };

        String[][] options = {
            {"A) Berlin", "B) Madrid", "C) Paris", "D) Rome"},
            {"A) Earth", "B) Mars", "C) Jupiter", "D) Venus"},
            {"A) Charles Dickens", "B) William Shakespeare", "C) Jane Austen", "D) Mark Twain"},
            {"A) Atlantic", "B) Indian", "C) Arctic", "D) Pacific"},
            {"A) 6", "B) 7", "C) 8", "D) 9"}
        };

        char[] correctAnswers = {'C', 'B', 'B', 'D', 'C'};

        while (questionIndex < questions.length) {
            displayQuestion(questions[questionIndex], options[questionIndex], correctAnswers[questionIndex]);
        }

        // Result Screen
        System.out.println("\nQuiz Over!");
        System.out.println("Your Final Score: " + score + "/" + questions.length);
    }

    public static void displayQuestion(String question, String[] options, char correctAnswer) {
        System.out.println("\nQuestion " + (questionIndex + 1) + ": " + question);
        for (String option : options) {
            System.out.println(option);
        }

        Timer timer = new Timer();
        answered = false;

        // Timer for 10 seconds per question
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!answered) {
                    System.out.println("\nTime's up!");
                    checkAnswer(' ', correctAnswer);  // If not answered, treat as incorrect
                }
                timer.cancel();
            }
        }, 10000);

        // Allow user to answer within the given time
        String answer = scanner.nextLine().toUpperCase();
        answered = true;
        timer.cancel();
        checkAnswer(answer.charAt(0), correctAnswer);
    }

    public static void checkAnswer(char userAnswer, char correctAnswer) {
        if (userAnswer == correctAnswer) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect! The correct answer was: " + correctAnswer);
        }
        questionIndex++;
    }
}
