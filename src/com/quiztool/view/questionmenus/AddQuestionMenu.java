package com.quiztool.view.questionmenus;

import com.quiztool.domain.QuestionChoice;
import com.quiztool.domain.QuizTool;
import com.quiztool.view.Menu;
import com.quiztool.view.topicmenus.TopicQuestionsMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AddQuestionMenu extends Menu {

    private final int topicId;
    private final TopicQuestionsMenu topicQuestionsMenu;

    public AddQuestionMenu(QuizTool quizTool, TopicQuestionsMenu topicQuestionsMenu, int topicId) {
        super(quizTool);
        this.topicId = topicId;
        this.topicQuestionsMenu = topicQuestionsMenu;
    }

    private HashMap<String, String> scanCommonQuestionDetails(Scanner scan) {
        System.out.println("******************************");
        HashMap<String, String> questionDetails = new HashMap<>();

        System.out.println("Enter question name: ");
        String questionName = scan.nextLine();
        questionDetails.put("name", questionName);

        System.out.println("Enter question text: ");
        String questionText = scan.nextLine();
        questionDetails.put("text", questionText);

        System.out.println("Enter question points: ");
        String points = scan.nextLine();
        questionDetails.put("points", points);

        return questionDetails;
    }

    private void addTrueFalseQuestion(Scanner scan) {
        HashMap<String, String> questionDetails = scanCommonQuestionDetails(scan);

        System.out.println("Enter question answer (T/F): ");
        String answer = scan.nextLine();

        String questionText = questionDetails.get("text");
        String questionName = questionDetails.get("name");
        int points = Integer.parseInt(questionDetails.get("points"));

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

    private void addShortAnswerQuestion(Scanner scan) {
        HashMap<String, String> questionDetails = scanCommonQuestionDetails(scan);

        System.out.println("Enter question answer: ");
        String answer = scan.nextLine();

        String questionText = questionDetails.get("text");
        String questionName = questionDetails.get("name");
        int points = Integer.parseInt(questionDetails.get("points"));

        quizTool.createShortAnswerQuestion(topicId, questionText, questionName, answer, points);
        System.out.println("Question saved successfully.");
    }

    private void addMultipleChoiceQuestion(Scanner scan) {
        HashMap<String, String> questionDetails = scanCommonQuestionDetails(scan);

        System.out.println("Enter choice number: ");
        int choiceNumber = Integer.parseInt(scan.nextLine());

        List<QuestionChoice> choices = new ArrayList<>();

        int charNum = 97;
        for (int i = 0; i < choiceNumber; i++) {
            char choiceChar = (char) charNum;
            System.out.println("Enter choice '" + choiceChar + "':");
            String choiceText = scan.nextLine();
            System.out.println("Is this a correct choice? (y/n)");
            String input = scan.nextLine();
            boolean isCorrect = true;
            if (input.equals("y")) {
                isCorrect = true;
            } else if (input.equals("n")) {
                isCorrect = false;
            }
            QuestionChoice questionChoice = new QuestionChoice(choiceText, choiceChar, isCorrect);
            choices.add(questionChoice);
            charNum++;
        }

        String questionText = questionDetails.get("text");
        String questionName = questionDetails.get("name");
        int points = Integer.parseInt(questionDetails.get("points"));

        quizTool.createMultipleChoiceQuestion(topicId, questionText, questionName, choices, points);
        System.out.println("Question saved successfully.");
    }

    @Override
    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println("To add a question, select a question type:");
        String[] questionTypes = {"(1) True/False", "(2) Short answer", "(3) Multiple choice"};
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
                addShortAnswerQuestion(scan);
                displayMenu();
                break;
            case "3":
                addMultipleChoiceQuestion(scan);
                displayMenu();
                break;
        }

    }
}
