package com.quiztool.view;

import com.quiztool.model.QuizTool;
import com.quiztool.model.Topic;

import java.util.Scanner;

public class DeleteTopicMenu extends Menu {

    private final int topicId;
    private final TopicListMenu topicListMenu;

    public DeleteTopicMenu(QuizTool quizTool, TopicListMenu topicListMenu, int topicId) {
        super(quizTool);
        this.topicId = topicId;
        this.topicListMenu = topicListMenu;
    }

    @Override
    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("******************************");
        Topic topic = quizTool.getTopicById(topicId);
        String topicName = topic.getName();
        System.out.println("Are you sure you want to delete topic '" + topicName + "' ? (y/n)");
        String input = scan.nextLine();
        if (input.equals("y")) {
            quizTool.deleteTopic(topicId);
            System.out.println("Topic '" + topicName + "' deleted successfully.");
            topicListMenu.displayMenu();
        } else if (input.equals("n")) {
            topicListMenu.displayMenu();
        }
    }
}
