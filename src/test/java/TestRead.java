import junit.framework.TestCase;
import org.junit.Assert;


public class TestRead extends TestCase {
    private final PointParser pp = new PointParser();

    public void testZeroArgument() { Assert.assertFalse(pp.read("").isPresent()); }
    public void testOneArgument() { Assert.assertFalse(pp.read("1").isPresent()); }
    public void testTwoArgument() { Assert.assertFalse(pp.read("1 2").isPresent()); }

    public void testLettersInData() { Assert.assertFalse(pp.read("1 2adadad").isPresent()); }

    public void testLowerY() { Assert.assertFalse(pp.read("1 -8 0.75").isPresent()); }
    public void testBiggerY() { Assert.assertFalse(pp.read("1 22.999 5.45").isPresent()); }

    public void testLowerYBorder() { Assert.assertFalse(pp.read("1 5 -3  ").isPresent()); }
    public void testBiggerYBorder() { Assert.assertFalse(pp.read("1 -3 4").isPresent()); }


    public void testExtraSpaces() {
        Assert.assertEquals(new Point(0.0, 1.0, 3.43231), pp.read("     00    1.000000     3.43231 12 1343,12").get());
    }
    public void testLettersAfterThirdNumber() {
        Assert.assertEquals(new Point(0.0, 1.0, 3.43231), pp.read("     00    1.000000     3.43231 asdas MISPI").get());
    }


    public void testPointFirstQuarter() {
        Assert.assertEquals(new Point(1, 2, 4), pp.read("1 2 4").get());
    }
    public void testPointFirstQuarterBoderY() {
        Assert.assertEquals(new Point(1.0, 4.99999999, 3.0), pp.read("1 4,99999999 3").get());
    }
    public void testPointFirstQuarterBoderX() {
        Assert.assertEquals(new Point(2, 2, 3), pp.read("2 2 3").get());
    }

    public void testPointSecondQuarter() {
        Assert.assertEquals(new Point(1, -2, 4), pp.read("1 -2 4").get());
    }
    public void testPointSecondQuarterBoderY() {
        Assert.assertEquals(new Point(1.0, -2.99999999, 3.0), pp.read("1 -2,99999999 3").get());
    }
    public void testPointSecondQuarterBoderX() {
        Assert.assertEquals(new Point(2, -2, 3), pp.read("2 -2 3").get());
    }


    public void testPointThirdQuarter() {
        Assert.assertEquals(new Point(-1.0, -2.99999999, 3.0), pp.read("-1 -2,99999999 3").get());
    }
    public void testPointThirdQuarterBorderX() {
        Assert.assertEquals(new Point(-2, -2, 3), pp.read("-2 -2 3").get());
    }
    public void testPointThirdQuarterBorderY() {
        Assert.assertEquals(new Point(-1.0, -2.99999999, 3.0), pp.read("-1 -2,99999999 3").get());
    }


    public void testPointForthQuarter() {
        Assert.assertEquals(new Point(-1, 1, 3), pp.read("-1 1 3").get());
    }
    public void testPointForthQuarterBorderX() {
        Assert.assertEquals(new Point(-2.0, 2.99999999, 3.0), pp.read("-2 2,99999999 3").get());
    }
    public void testPointForthQuarterBorderY() {
        Assert.assertEquals(new Point(-1.0, 4.99999999, 3.0), pp.read("-1 4,99999999 3").get());
    }
}
