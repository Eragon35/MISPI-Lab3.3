import java.util.Objects;

public class Point {
    Double x;
    Double y;
    Double r;

    public Point(Double x, Double y, Double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public Point(int x, int y, int r){
        this.x = (double) x;
        this.y = (double) y;
        this.r = (double) r;

    }

    /**
     * @return true if point inside area and false if not
     */
    public boolean check() {
        if (x >= 0) {
            if (y >= 0) return x * x + y * y <= r * r;
            else return y >= (x - r / 2);
        }
        else return (y > -r) && (x > -r) && (y <= 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (!Objects.equals(x, point.x)) return false;
        if (!Objects.equals(y, point.y)) return false;
        return Objects.equals(r, point.r);
    }

    @Override
    public int hashCode() {
        int result = x != null ? x.hashCode() : 0;
        result = 31 * result + (y != null ? y.hashCode() : 0);
        result = 31 * result + (r != null ? r.hashCode() : 0);
        return result;
    }
}
