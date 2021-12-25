package com.quiztool.view;

import com.quiztool.model.QuizTool;

public class MenuFacade {

    private static MenuFacade instance;
    MainMenu mainMenu;

    private MenuFacade() {
    }

    synchronized public static MenuFacade getInstance() {
        if (instance == null) {
            instance = new MenuFacade();
        }
        return instance;
    }

    public void startQuizTool(QuizTool quizTool) {
        mainMenu = new MainMenu(quizTool);
        mainMenu.displayMenu();
    }

}
