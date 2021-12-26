package com.quiztool.view.questionmenus;

import com.quiztool.domain.QuizTool;
import com.quiztool.view.Menu;
import com.quiztool.view.topicmenus.TopicQuestionsMenu;

import java.util.HashMap;
import java.util.Scanner;

public class QuestionDetailsMenu extends Menu {

    private final int topicId;
    private final int questionId;
    private final TopicQuestionsMenu topicQuestionsMenu;

    public QuestionDetailsMenu(QuizTool quizTool, int topicId, int questionId, TopicQuestionsMenu topicQuestionsMenu) {
        super(quizTool);
        this.topicId = topicId;
        this.questionId = questionId;
        this.topicQuestionsMenu = topicQuestionsMenu;
    }

    @Override
    public void displayMenu() {
        System.out.println("******************************");
        System.out.println("QUESTION DETAILS");
        Scanner scan = new Scanner(System.in);
        HashMap<String, String> questionDetails = quizTool.getTopicQuestionDetails(topicId, questionId);
        String questionType = questionDetails.get("type");

        System.out.println("Name: " + questionDetails.get("name"));
        System.out.println("Text: " + questionDetails.get("text"));
        System.out.println("Points: " + questionDetails.get("points"));

        if (questionType.equals("MultipleChoiceQuestion")) {
            System.out.println("All choices:");
            System.out.println(questionDetails.get("allChoices"));
            System.out.println("Correct choices: " + questionDetails.get("correctChoiceChars"));
        } else {
            System.out.println("Answer: " + questionDetails.get("answer"));
        }

        System.out.println("\nEnter 'm' for modifying the question...");
        System.out.println("Enter 'd' for deleting the question...");
        System.out.println("Enter '0' to go back to the topic's questions menu...");

        String input = scan.nextLine();

        switch (input) {
            case "0":
                topicQuestionsMenu.displayMenu();
                break;
            case "m":
                ModifyQuestionMenu modifyQuestionMenu = new ModifyQuestionMenu(quizTool, this, topicId, questionId);
                modifyQuestionMenu.displayMenu();
                break;
            case "d":
                DeleteQuestionMenu deleteQuestionMenu = new DeleteQuestionMenu(quizTool, topicQuestionsMenu, topicId, questionId);
                deleteQuestionMenu.displayMenu();
                break;
            default:
                System.out.println();
                break;
        }

    }
}
