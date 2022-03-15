package ui;

import ui.shared.Menu;
import ui.shared.Screen;

import java.util.Scanner;

import static util.ConsoleOutputWidget.display;

public class MenuScreen implements Screen {

    @Override
    public void render() {
        display("You are in Menu lobby.");
        display("Please, choose what you want to do.");
        display("Type *CREATE* - Report a bug.");
        display("Type *VIEW* - View all of existing bugs.");
        try {
            Scanner scanner = new Scanner(System.in);
            String chosenMenu = scanner.nextLine();
            Screen screen = navigateTo(Menu.valueOf(chosenMenu.toUpperCase()));
            screen.render();
        } catch (Exception e) {
            Screen screen = new MenuScreen();
            screen.render();
        }
    }

    private Screen navigateTo(Menu menu) {
        Screen screen;
        switch (menu) {
            case CREATE -> screen = new CreateBugScreen();
            case VIEW -> screen = new BugsScreen();
            default -> screen = new MenuScreen();
        }
        return screen;
    }
}