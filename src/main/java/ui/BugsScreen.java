package ui;

import datastore.BugDataStore;
import entity.Bug;
import ui.shared.Screen;

import java.util.List;
import java.util.Scanner;

import static util.ConsoleOutputWidget.display;
import static util.ConsoleOutputWidget.displayAlert;

public class BugsScreen implements Screen {

    private final BugDataStore bugDataStore;

    public BugsScreen() {
        bugDataStore = BugDataStore.getInstance();
    }

    @Override
    public void render() {
        displayAlert("You are in Bugs List screen.");
        List<Bug> bugs = bugDataStore.getAll();
        if (bugs.isEmpty()) {
            displayAlert("You have not reported any bugs.");
        } else {
            for (Bug bug : bugs) {
                display(String.format("==== ID: %s ===", bug.getUuid().toString()));
                display(String.format("Summary: %s", bug.getSummary()));
                display(String.format("Assigned to: %s", bug.getAssignedTo()));
                display(String.format("Status: %s", bug.getStatus()));
                display("=====================================================");
            }
        }

        displayAlert("Type 'exit' to navigate to Menu screen or type bug's UUID to display a bug details.");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        if (option != null && option.equals("exit")) {
            Screen screen = new MenuScreen();
            screen.render();
        } else {
            Bug bug = bugDataStore.getByUuid(option);
            Screen screen = bug != null
                    ? new BugDetailsScreen(bug)
                    : new MenuScreen();
            screen.render();
        }
    }
}
