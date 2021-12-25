package com.quiztool.view;

import com.quiztool.model.QuizTool;

import java.util.Scanner;

public class AddQuestionMenu extends Menu {

    private final int topicId;
    private final TopicQuestionsMenu topicQuestionsMenu;

    public AddQuestionMenu(QuizTool quizTool, TopicQuestionsMenu topicQuestionsMenu, int topicId) {
        super(quizTool);
        this.topicId = topicId;
        this.topicQuestionsMenu = topicQuestionsMenu;
    }

    private void addTrueFalseQuestion(Scanner scan) {
        System.out.println("******************************");

        System.out.println("Enter question name: ");
        String questionName = scan.nextLine();

        System.out.println("Enter question text: ");
        String questionText = scan.nextLine();

        System.out.println("Enter question points: ");
        int points = Integer.parseInt(scan.nextLine());

        System.out.println("Enter question answer (T/F): ");
        String answer = scan.nextLine();

        if (answer.equals("T")) {
            quizTool.createTrueFalseQuestion(topicId, questionText, questionName, true, points);
            System.out.println("Question saved successfully.");
        } else if (answer.equals("F")) {
            quizTool.createTrueFalseQuestion(topicId, questionText, questionName, false, points);
            System.out.println("Question saved successfully.");
        } else {
            System.out.println("Invalid answer.");
            addTrueFalseQuestion(scan);
        }
    }

    private void addShortAnswerQuestion() {
        System.out.println();
    }

    private void addMultipleChoiceQuestion() {
        System.out.println();
    }

    @Override
    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println("To add a question, select a question type:");
        String[] questionTypes = {
                "(1) True/False",
                "(2) Short answer",
                "(3) Multiple choice",
        };
        for (String questionType : questionTypes) {
            System.out.println(questionType);
        }
        System.out.println("\nEnter '0' to go back to the topic's questions menu...");
        String input = scan.nextLine();
        switch (input) {
            case "0":
                topicQuestionsMenu.displayMenu();
                break;
            case "1":
                addTrueFalseQuestion(scan);
                displayMenu();
                break;
            case "2":
                addShortAnswerQuestion();
                displayMenu();
                break;
            case "3":
                addMultipleChoiceQuestion();
                displayMenu();
                break;
        }

    }
}
