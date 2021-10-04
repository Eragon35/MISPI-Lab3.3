import java.util.Optional;
import java.util.Scanner;

public class Main {
    /**
     * main class where we greeting user and go inside infinite loop where we
     * check input line to find the point and check if it's inside the area
     */
    public static void main(String[] args) {
        Greeting greeting = new Greeting();
        greeting.hello();
        PointParser readFromConsole = new PointParser();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nPlease write x, y, r to check if it's inside the figure: ");
            Optional<Point> inputData = readFromConsole.read(scanner.nextLine());
            inputData.ifPresent(point -> System.out.println(point.check()));
        }
    }
}
