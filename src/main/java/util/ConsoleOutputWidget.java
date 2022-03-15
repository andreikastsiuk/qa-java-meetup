package util;

public class ConsoleOutputWidget {

    public static void displayAlert(Object message) {
        System.out.println("*************************************************************");
        System.out.println(message);
        System.out.println("*************************************************************");
    }

    public static void display(Object message) {
        System.out.println(message);
    }
}
