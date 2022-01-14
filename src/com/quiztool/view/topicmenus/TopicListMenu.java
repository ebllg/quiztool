package com.quiztool.view.topicmenus;

import com.quiztool.domain.QuizTool;
import com.quiztool.domain.Topic;
import com.quiztool.view.MainMenu;
import com.quiztool.view.Menu;
import com.quiztool.view.quizmenus.QuizQuestionsMenu;

import java.util.List;
import java.util.Scanner;


public class TopicListMenu extends Menu {

    private final MainMenu mainMenu;
    private final QuizQuestionsMenu quizQuestionsMenu;

    public TopicListMenu(QuizTool quizTool, MainMenu mainMenu) {
        super(quizTool);
        this.mainMenu = mainMenu;
        this.quizQuestionsMenu = null;
    }

    public TopicListMenu(QuizTool quizTool, QuizQuestionsMenu quizQuestionsMenu) {
        super(quizTool);
        this.quizQuestionsMenu = quizQuestionsMenu;
        this.mainMenu = null;
    }

    public QuizQuestionsMenu getQuizQuestionsMenu() {
        return quizQuestionsMenu;
    }

    private void printTopicList() {
        System.out.println("******************************");
        List<Topic> topicList = quizTool.getTopicList();
        if (topicList == null || topicList.isEmpty()) {
            System.out.println("=> There is no topics yet...");
        } else {
            System.out.println("Enter topic number to select a topic:");
            for (int i = 0; i < topicList.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + topicList.get(i).getName());
            }
        }
    }

    private void displayTopicList() {
        Scanner scan = new Scanner(System.in);
        printTopicList();
        System.out.println("\nEnter 'a' for adding a new topic...");
        System.out.println("Enter '0' for main menu...");

        String input = scan.nextLine();

        if (input.equals("0")) {
            assert mainMenu != null;
            mainMenu.displayMenu();
        } else if (input.equals("a")) {
            AddTopicMenu addTopicMenu = new AddTopicMenu(quizTool, this);
            addTopicMenu.displayMenu();
        } else {
            TopicQuestionsMenu topicQuestionsMenu = new TopicQuestionsMenu(quizTool, this, Integer.parseInt(input) - 1);
            topicQuestionsMenu.displayMenu();
        }
    }

    private void displayTopicListForAddQuizQuestion() {
        Scanner scan = new Scanner(System.in);
        printTopicList();
        System.out.println("\nEnter '0' to go back to the quiz menu...");

        String input = scan.nextLine();

        if (input.equals("0")) {
            assert quizQuestionsMenu != null;
            quizQuestionsMenu.displayMenu();
        } else {
            assert quizQuestionsMenu != null;
            TopicQuestionsMenu topicQuestionsMenu = new TopicQuestionsMenu(quizTool, this, Integer.parseInt(input) - 1, quizQuestionsMenu);
            topicQuestionsMenu.displayMenu();
        }
    }

    @Override
    public void displayMenu() {
        if (quizQuestionsMenu != null) {
            displayTopicListForAddQuizQuestion();
        } else {
            displayTopicList();
        }
    }
}
