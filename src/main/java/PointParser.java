import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PointParser {
    /**
     *
     * @param str string where from we are trying to get the point
     * @return option<Point> if we can get point from the input string
     */
    Optional<Point> read(String str) {
        try {
            if (str.contains("exit") || str.contains("учше")) System.exit(0);
            String[] arr = str
                    .trim()
                    .replaceAll(" +", " ")
                    .replaceAll(",", ".")
                    .split(" ");
            List<Double> numbers = Arrays
                    .stream(arr)
                    .limit(3)
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            if (numbers.size() < 3) {
                System.out.println("You should input at least 3 number");
                return Optional.empty();
            }
            double x = numbers.get(0);
            double y = numbers.get(1);
            double r = numbers.get(2);
            return Optional.of(new Point(x, y, r));
        } catch (Exception e) {
            System.out.println("Can't get number from you line: " + e);
            return Optional.empty();
        }

    }
}
