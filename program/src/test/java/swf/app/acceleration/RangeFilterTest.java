import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import swf.app.acceleration.RangeFilter;

public class RangeFilterTest {
  @Test
  public void testIsAccepted() {
    RangeFilter rangeFilter = new RangeFilter(-3, 9);

    assertFalse(rangeFilter.isAccepted(-4.0));
    assertTrue(rangeFilter.isAccepted(-3.0));
    assertTrue(rangeFilter.isAccepted(0.0));
    assertTrue(rangeFilter.isAccepted(1.0));
    assertTrue(rangeFilter.isAccepted(9.0));
    assertFalse(rangeFilter.isAccepted(11.0));
  }
}
