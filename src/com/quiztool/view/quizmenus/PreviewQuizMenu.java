package com.quiztool.view.quizmenus;

import com.quiztool.domain.Question;
import com.quiztool.domain.Quiz;
import com.quiztool.domain.QuizTool;
import com.quiztool.view.Menu;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PreviewQuizMenu extends Menu {

    private final QuizListMenu quizListMenu;
    private final int quizId;

    public PreviewQuizMenu(QuizTool quizTool, QuizListMenu quizListMenu, int quizId) {
        super(quizTool);
        this.quizListMenu = quizListMenu;
        this.quizId = quizId;
    }

    private void printQuizSummary(HashMap<Integer, Integer> questionGrades, int givenAnswerCount, int totalGrade) {
        System.out.println("*****EVALUATION SUMMARY*****");
        System.out.println("Total count of answered questions: " + givenAnswerCount);
        System.out.println("Total grade: " + totalGrade);
        System.out.println("Grade for each answer:");
        questionGrades.forEach((key, value) -> System.out.println("Question no: " + key + ", Grade: " + value));
    }

    @Override
    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("******************************");
        Quiz quiz = quizTool.getQuizById(quizId);
        System.out.println("Preview quiz '" + quiz.getName() + "'");
        System.out.println("Instructions:");
        System.out.println("- Type 'T' or 'F' for answering a T/F question.");
        System.out.println("- Type the answer for answering short answer question. Exact match is needed.");
        System.out.println("- Type chars (eg. a, b, c, etc.) for answering multiple choice question. " +
                "Chars must be separated with only space. Hit enter after typing all chars.");
        System.out.println("- To skip a question, type 'skip' and hit enter.");
        System.out.println("******************************");
        List<Question> quizQuestions = quizTool.getQuizQuestions(quizId);
        int totalGrade = 0;
        int givenAnswerCount = 0;
        HashMap<Integer, Integer> questionGrades = new HashMap<>();
        int questionGrade;
        for (int i = 0; i < quizQuestions.size(); i++) {
            Question question = quizQuestions.get(i);
            System.out.println("Question (" + (i + 1) + "):");
            quizTool.askQuestion(question);
            String input = scan.nextLine();
            if (input.equals("skip")) {
                continue;
            }
            givenAnswerCount += 1;
            questionGrade = quizTool.gradeAnswer(question, input);
            questionGrades.put(i + 1, questionGrade);
            totalGrade += questionGrade;
        }
        printQuizSummary(questionGrades, givenAnswerCount, totalGrade);
        System.out.println("\nEnter '0' to go back to the quiz list menu...");
        String input = scan.nextLine();
        if (input.equals("0")) {
            quizListMenu.displayMenu();
        } else {
            System.out.println("Invalid input, exiting...");
            System.exit(0);
        }
    }
}
