import junit.framework.TestCase;
import org.junit.Assert;

public class CheckTest extends TestCase {

    public void testFirstQuarterIn() { Assert.assertTrue(new Point(1, 2, 3).check()); }
    public void testFirstQuarterBorder() { Assert.assertTrue(new Point(2, 2, 4).check()); }
    public void testFirstQuarterBorderWithX() { Assert.assertTrue(new Point(4, 0, 4).check()); }
    public void testFirstQuarterBorderWithY() { Assert.assertTrue(new Point(0.0, 1.9, 4.0).check()); }
    public void testFirstQuarterOut() { Assert.assertFalse(new Point(1, 2, 1).check()); }

    public void testSecondQuarterIn() { Assert.assertTrue(new Point(1, -1, 5).check()); }
    public void testSecondQuarterBorder() { Assert.assertTrue(new Point(1, -1, 4).check()); }
    public void testSecondQuarterBorderWithX() { Assert.assertTrue(new Point(1, 0, 3).check()); }
    public void testSecondQuarterBorderWithY() { Assert.assertTrue(new Point(0.0, -1.999999, 4.0).check()); }
    public void testSecondQuarterOut() { Assert.assertFalse(new Point(1, -3, 1).check()); }

    public void testThirdQuarterIn() { Assert.assertTrue(new Point(-1, -1, 5).check()); }
    public void testThirdQuarterBorder() { Assert.assertTrue(new Point(0, -2, 4).check()); }
    public void testThirdQuarterBorderWithX() { Assert.assertTrue(new Point(-1.5, -1.0, 3.0).check()); }
    public void testThirdQuarterBorderWithY() { Assert.assertTrue(new Point(-3.9999999, -2.5, 5.0).check()); }
    public void testThirdQuarterOut() { Assert.assertFalse(new Point(-3, -1, 3).check()); }

    public void testForthQuarterIn() { Assert.assertTrue(new Point(0, 0, 1).check()); }
    public void testForthQuarterOut() { Assert.assertFalse(new Point(-3, 1, -3).check()); }
    public void testForthQuarterBorderWithX() { Assert.assertTrue(new Point(0, 2, 3).check()); }
    public void testForthQuarterBorderWithY() { Assert.assertTrue(new Point(-3.9999999, 0.0, 5.0).check()); }

}
