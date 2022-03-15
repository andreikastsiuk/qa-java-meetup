package ui;

import datastore.BugDataStore;
import entity.Bug;
import entity.Priority;
import entity.Severity;
import ui.shared.Screen;

import java.util.Scanner;

import static util.ConsoleOutputWidget.display;
import static util.ConsoleOutputWidget.displayAlert;

public class CreateBugScreen implements Screen {

    private final BugDataStore bugDataStore;

    public CreateBugScreen() {
        bugDataStore = BugDataStore.getInstance();
    }

    @Override
    public void render() {
        displayAlert("You are in Create New Bug screen.");

        Scanner scanner = new Scanner(System.in);

        display("Please, enter summary:");
        String summary = scanner.nextLine();

        display("Please, enter description:");
        String description = scanner.nextLine();

        display("Please, enter priority (low, medium, high):");
        String priority = scanner.nextLine();

        display("Please, enter severity (trivial, minor, major, critical, blocker):");
        String severity = scanner.nextLine();

        display("Please, enter assigned to:");
        String assignedTo = scanner.nextLine();

        display("Please, enter expected result:");
        String expectedResult = scanner.nextLine();

        display("Please, enter actual result:");
        String actualResult = scanner.nextLine();

        Bug bug = new Bug(
                summary,
                description,
                Priority.valueOf(priority.toUpperCase()),
                Severity.valueOf(severity.toUpperCase()),
                assignedTo,
                expectedResult,
                actualResult
        );

        bugDataStore.save(bug);

        displayAlert(String.format("The bug №%s was created.", bug.getUuid().toString()));

        Screen screen = new MenuScreen();
        screen.render();
    }
}
