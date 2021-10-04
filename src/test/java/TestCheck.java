import junit.framework.TestCase;
import org.junit.Assert;

public class TestCheck extends TestCase {

    public void testFirstQuarterIn() { Assert.assertEquals("true", new Point(1, 2, 3).check()); }
    public void testFirstQuarterBorder() { Assert.assertEquals("true", new Point(2, 2, 4).check()); }
    public void testFirstQuarterBorderWithX() { Assert.assertEquals("X should be between [-2..2]", new Point(4, 0, 4).check()); }
    public void testFirstQuarterBorderWithY() { Assert.assertEquals("true", new Point(0.0, 1.9, 4.0).check()); }
    public void testFirstQuarterOut() { Assert.assertEquals("false", new Point(1, 2, 1).check()); }

    public void testSecondQuarterIn() { Assert.assertEquals("true", new Point(1, -1, 5).check()); }
    public void testSecondQuarterBorder() { Assert.assertEquals("true", new Point(1, -1, 4).check()); }
    public void testSecondQuarterBorderWithX() { Assert.assertEquals("true", new Point(1, 0, 3).check()); }
    public void testSecondQuarterBorderWithY() { Assert.assertEquals("true", new Point(0.0, -1.999999, 4.0).check()); }
    public void testSecondQuarterOut() { Assert.assertEquals("Y should be between (-3..5)", new Point(1, -3, 1).check()); }

    public void testThirdQuarterIn() { Assert.assertEquals("true", new Point(-1, -1, 5).check()); }
    public void testThirdQuarterBorder() { Assert.assertEquals("true", new Point(0, -2, 4).check()); }
    public void testThirdQuarterBorderWithX() { Assert.assertEquals("true", new Point(-1.5, -1.0, 3.0).check()); }
    public void testThirdQuarterBorderWithY() { Assert.assertEquals("X should be between [-2..2]", new Point(-3.9999999, -2.5, 5.0).check()); }
    public void testThirdQuarterOut() { Assert.assertEquals("X should be between [-2..2]", new Point(-3, -1, 3).check()); }

    public void testForthQuarterIn() { Assert.assertEquals("true", new Point(0, 0, 1).check()); }
    public void testForthQuarterOut() { Assert.assertEquals("X should be between [-2..2]", new Point(-3, 1, -3).check()); }
    public void testForthQuarterBorderWithX() { Assert.assertEquals("true", new Point(0, 2, 3).check()); }
    public void testForthQuarterBorderWithY() { Assert.assertEquals("X should be between [-2..2]", new Point(-3.9999999, 0.0, 5.0).check()); }

}
