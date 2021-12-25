package com.quiztool.view;

import com.quiztool.model.QuizTool;
import com.quiztool.model.Topic;

import java.util.List;
import java.util.Scanner;


public class TopicListMenu extends Menu {

    private final MainMenu mainMenu;

    public TopicListMenu(QuizTool quizTool, MainMenu mainMenu) {
        super(quizTool);
        this.mainMenu = mainMenu;
    }

    @Override
    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println("Select a topic:");
        List<Topic> topicList = quizTool.getTopicList();
        for (int i = 0; i < quizTool.getTopicList().size(); i++) {
            System.out.println("(" + (i + 1) + ") " + topicList.get(i).getName());
        }
        System.out.println("\nEnter 'a' for adding a new topic...");
        System.out.println("Enter '0' for main menu...");

        String input = scan.nextLine();

        if (input.equals("0")) {
            mainMenu.displayMenu();
        } else if (input.equals("a")) {
            AddTopicMenu topicMenu = new AddTopicMenu(quizTool, this);
            topicMenu.displayMenu();
        } else {
            TopicQuestionsMenu topicQuestionsMenu = new TopicQuestionsMenu(quizTool, this, Integer.parseInt(input) - 1);
            topicQuestionsMenu.displayMenu();
        }
    }
}
