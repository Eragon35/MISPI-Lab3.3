public class Point {
    Double x;
    Double y;
    Double r;

    public Point(Double x, Double y, Double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public boolean check() {
        if (x >= 0) {
            if (y >= 0) return x * x + y * y <= r * r;
            else return y >= (x - r / 2);
        }
        else return (y > -r) && (x > -r) && (y <= 0);
    }

}
