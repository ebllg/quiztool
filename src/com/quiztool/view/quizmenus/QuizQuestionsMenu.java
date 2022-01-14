package com.quiztool.view.quizmenus;

import com.quiztool.domain.Question;
import com.quiztool.domain.Quiz;
import com.quiztool.domain.QuizTool;
import com.quiztool.view.Menu;
import com.quiztool.view.questionmenus.AddQuestionMenu;
import com.quiztool.view.topicmenus.TopicListMenu;

import java.util.List;
import java.util.Scanner;

public class QuizQuestionsMenu extends Menu {
    private final int quizId;
    private final QuizListMenu quizListMenu;

    public QuizQuestionsMenu(QuizTool quizTool, QuizListMenu quizListMenu, int quizId) {
        super(quizTool);
        this.quizId = quizId;
        this.quizListMenu = quizListMenu;
    }

    public int getQuizId() {
        return quizId;
    }

    @Override
    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("******************************");
        Quiz quiz = quizTool.getQuizById(quizId);
        System.out.println("Quiz '" + quiz.getName() + "'");
        List<Question> quizQuestions = quiz.getQuestionList();
        if (quizQuestions == null || quizQuestions.isEmpty()) {
            System.out.println("=> This quiz has no questions yet...");
        } else {
            System.out.println("Enter question number to select a question:");
            for (int i = 0; i < quizQuestions.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + quizQuestions.get(i).getName());
            }
        }
        System.out.println();
        System.out.println("Enter 'a' for adding a question to the quiz...");
        System.out.println("Enter 'r' for removing a question from the quiz...");
        System.out.println("Enter 'm' for modifying the quiz...");
        System.out.println("Enter 'd' for deleting the quiz...");
        System.out.println("Enter '0' for quiz list menu...");

        String input = scan.nextLine();

        switch (input) {
            case "0":
                quizListMenu.displayMenu();
                break;
            case "a":
                TopicListMenu topicListMenu = new TopicListMenu(quizTool, this);
                topicListMenu.displayMenu();
                break;
            case "r":
//                ModifyTopicMenu modifyTopicMenu = new ModifyTopicMenu(quizTool, this, quizId);
//                modifyTopicMenu.displayMenu();
                break;
            case "m":
                ModifyQuizMenu modifyQuizMenu = new ModifyQuizMenu(quizTool, this, quizId);
                modifyQuizMenu.displayMenu();
                break;
            case "d":
                DeleteQuizMenu deleteQuizMenu = new DeleteQuizMenu(quizTool, quizListMenu, quizId);
                deleteQuizMenu.displayMenu();
                break;
            default:
                System.out.println("Invalid operation.");
                quizListMenu.displayMenu();
                break;
        }
    }
}
