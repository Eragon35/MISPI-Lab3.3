import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class Greeting {

    /**
     * func hello print the author of the lab
     * and can print the ascii art of the area, but i failed with printing it from file
     */
    void hello() {
        String fileName = "ascii.txt";
        String name = "Antipin Arsentii";
        System.out.println(name + "'s Computer engineer basics Lab 3");
//        InputStream stream = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(fileName));
//        try (Scanner scanner = new Scanner(stream)) {
//            while (scanner.hasNextLine()) System.out.println(scanner.nextLine());
//        }
    }
}
