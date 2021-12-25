package com.quiztool.view;

import com.quiztool.model.QuizTool;

import java.util.Scanner;

public class AddTopicMenu extends Menu {

    private final TopicListMenu topicListMenu;

    public AddTopicMenu(QuizTool quizTool, TopicListMenu topicListMenu) {
        super(quizTool);
        this.topicListMenu = topicListMenu;
    }

    @Override
    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println("Enter a name:");
        String input = scan.nextLine();
        int topicId = quizTool.createTopic(input);
        System.out.println("New topic created.");

        TopicQuestionsMenu topicQuestionsMenu = new TopicQuestionsMenu(quizTool, topicListMenu, topicId);
        topicQuestionsMenu.displayMenu();
    }
}
