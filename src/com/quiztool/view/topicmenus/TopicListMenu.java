package com.quiztool.view.topicmenus;

import com.quiztool.domain.QuizTool;
import com.quiztool.domain.Topic;
import com.quiztool.view.MainMenu;
import com.quiztool.view.Menu;

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
        System.out.println("Enter topic number to select a topic:");
        List<Topic> topicList = quizTool.getTopicList();
        for (int i = 0; i < topicList.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + topicList.get(i).getName());
        }
        System.out.println("\nEnter 'a' for adding a new topic...");
        System.out.println("Enter '0' for main menu...");

        String input = scan.nextLine();

        if (input.equals("0")) {
            mainMenu.displayMenu();
        } else if (input.equals("a")) {
            AddTopicMenu addTopicMenu = new AddTopicMenu(quizTool, this);
            addTopicMenu.displayMenu();
        } else {
            TopicQuestionsMenu topicQuestionsMenu = new TopicQuestionsMenu(quizTool, this, Integer.parseInt(input) - 1);
            topicQuestionsMenu.displayMenu();
        }
    }
}
