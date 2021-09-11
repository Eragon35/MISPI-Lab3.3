import junit.framework.TestCase;
import org.junit.Assert;


public class ReadTest extends TestCase {
    private final ReadFromConsole rfc = new ReadFromConsole();

    public void testZeroArgument() { Assert.assertTrue(rfc.read("").isEmpty()); }
    public void testOneArgument() { Assert.assertTrue(rfc.read("1").isEmpty()); }
    public void testTwoArgument() { Assert.assertTrue(rfc.read("1 2").isEmpty()); }

    public void testLettersInData() { Assert.assertTrue(rfc.read("1 2adadad").isEmpty()); }

    public void testLowerY() { Assert.assertTrue(rfc.read("1 -8 0.75").isEmpty()); }
    public void testBiggerY() { Assert.assertTrue(rfc.read("1 22.999 5.45").isEmpty()); }

    public void testLowerYBorder() { Assert.assertTrue(rfc.read("1 5 -3  ").isEmpty()); }
    public void testBiggerYBorder() { Assert.assertTrue(rfc.read("1 -3 4").isEmpty()); }


    public void testExtraSpaces() {
        Assert.assertEquals(new Point(0.0, 1.0, 3.43231), rfc.read("     00    1.000000     3.43231 12 1343,12").get());
    }
    public void testLettersAfterThirdNumber() {
        Assert.assertEquals(new Point(0.0, 1.0, 3.43231), rfc.read("     00    1.000000     3.43231 asdas MISPI").get());
    }


    public void testPointFirstQuarter() {
        Assert.assertEquals(new Point(1, 2, 4), rfc.read("1 2 4").get());
    }
    public void testPointFirstQuarterBoderY() {
        Assert.assertEquals(new Point(1.0, 4.99999999, 3.0), rfc.read("1 4,99999999 3").get());
    }
    public void testPointFirstQuarterBoderX() {
        Assert.assertEquals(new Point(2, 2, 3), rfc.read("2 2 3").get());
    }

    public void testPointSecondQuarter() {
        Assert.assertEquals(new Point(1, -2, 4), rfc.read("1 -2 4").get());
    }
    public void testPointSecondQuarterBoderY() {
        Assert.assertEquals(new Point(1.0, -2.99999999, 3.0), rfc.read("1 -2,99999999 3").get());
    }
    public void testPointSecondQuarterBoderX() {
        Assert.assertEquals(new Point(2, -2, 3), rfc.read("2 -2 3").get());
    }


    public void testPointThirdQuarter() {
        Assert.assertEquals(new Point(-1.0, -2.99999999, 3.0), rfc.read("-1 -2,99999999 3").get());
    }
    public void testPointThirdQuarterBorderX() {
        Assert.assertEquals(new Point(-2, -2, 3), rfc.read("-2 -2 3").get());
    }
    public void testPointThirdQuarterBorderY() {
        Assert.assertEquals(new Point(-1.0, -2.99999999, 3.0), rfc.read("-1 -2,99999999 3").get());
    }


    public void testPointForthQuarter() {
        Assert.assertEquals(new Point(-1, 1, 3), rfc.read("-1 1 3").get());
    }
    public void testPointForthQuarterBorderX() {
        Assert.assertEquals(new Point(-2.0, 2.99999999, 3.0), rfc.read("-2 2,99999999 3").get());
    }
    public void testPointForthQuarterBorderY() {
        Assert.assertEquals(new Point(-1.0, 4.99999999, 3.0), rfc.read("-1 4,99999999 3").get());
    }
}
