import static org.junit.Assert.assertEquals;

import org.junit.Test;
import swf.app.Acceleration;
import swf.app.acceleration.DistanceCalculator;

public class DistanceCalculatorTest {
  @Test
  public void testCalculateDistance() {
    Acceleration accel1 = new Acceleration((short) 44, (short) -57, (short) 28);
    Acceleration accel2 = new Acceleration((short) 9, (short) 17, (short) 47);
    DistanceCalculator distanceCalculator = new DistanceCalculator();
    assertEquals(84.03570669661795, distanceCalculator.calculateDistance(accel1, accel2), 0);
  }
}
