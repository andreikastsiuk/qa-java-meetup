import ui.MenuScreen;

import static util.ConsoleOutputWidget.displayAlert;

public class EntryPoint {

    public static void main(String[] args) {
        displayAlert("Welcome to Cogniteq BugTracking system");

        MenuScreen menuScreen = new MenuScreen();
        menuScreen.render();
    }
}
