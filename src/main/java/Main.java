import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Greeting greeting = new Greeting();
        greeting.hello();
        ReadFromConsole readFromConsole = new ReadFromConsole();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nPlease write x, y, r to check if it's inside the figure: ");
            Optional<Point> inputData = readFromConsole.read(scanner.nextLine());
            inputData.ifPresent(point -> System.out.println(point.check()));
        }
    }
}
