package ui;

import datastore.BugDataStore;
import entity.Bug;
import ui.shared.Screen;

import java.util.Scanner;

import static util.ConsoleOutputWidget.display;
import static util.ConsoleOutputWidget.displayAlert;

public class BugDetailsScreen implements Screen {

    private final BugDataStore bugDataStore;
    private final Bug bug;

    public BugDetailsScreen(Bug bug) {
        bugDataStore = BugDataStore.getInstance();
        this.bug = bug;
    }

    @Override
    public void render() {
        displayAlert("You are in Bug Details screen.");

        display(String.format("==== ID: %s ===", bug.getUuid().toString()));
        display(String.format("Summary: %s", bug.getSummary()));
        display(String.format("Description: %s", bug.getDescription()));
        display(String.format("Actual result: %s", bug.getActualResult()));
        display(String.format("Expected Result: %s", bug.getExpectedResult()));
        display(String.format("Assigned to: %s", bug.getAssignedTo()));
        display(String.format("Status: %s", bug.getStatus().toString()));
        display(String.format("Priority: %s", bug.getPriority().toString()));
        display(String.format("Severity: %s", bug.getSeverity().toString()));

        display("*************************************************************");

        displayAlert("Type 'exit' to navigate to Menu screen or type 'delete' to delete the bug.");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        if (option != null && option.equals("exit")) {
            Screen screen = new MenuScreen();
            screen.render();
        } else if (option != null && option.equals("delete")) {
            bugDataStore.delete(bug);
            displayAlert(String.format("The bug №%s was deleted.", bug.getUuid().toString()));
            Screen screen = new BugsScreen();
            screen.render();
        }
    }
}
