import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import swf.app.Acceleration;

public class AccelerationTest {
  private Acceleration accel;

  @Before
  public void oneTimeSetUp() {
    this.accel = new Acceleration((short) 176, (short) -136, (short) -11);
  }

  @Test
  public void testGetX() {
    assertEquals((short) 176, this.accel.getX());
  }

  @Test
  public void testGetY() {
    assertEquals((short) -136, this.accel.getY());
  }

  @Test
  public void testGetZ() {
    assertEquals((short) -11, this.accel.getZ());
  }

  @Test
  public void testToString() {
    assertEquals("176 -136 -11", this.accel.toString());
  }

  @Test
  public void testEquals() {
    assertNotEquals(new Object(), this.accel);
    assertNotEquals(new Acceleration((short) 175, (short) -136, (short) -11), this.accel);
    assertNotEquals(new Acceleration((short) 176, (short) -126, (short) -11), this.accel);
    assertNotEquals(new Acceleration((short) 176, (short) -136, (short) -1), this.accel);
    assertEquals(new Acceleration((short) 176, (short) -136, (short) -11), this.accel);
  }

  @Test
  public void testHashCode() {
    assertNotEquals(
        new Acceleration((short) 175, (short) -136, (short) -11).hashCode(),
        this.accel.hashCode()
    );
    assertNotEquals(
        new Acceleration((short) 176, (short) -126, (short) -11).hashCode(),
        this.accel.hashCode()
    );
    assertNotEquals(
        new Acceleration((short) 176, (short) -136, (short) -1).hashCode(),
        this.accel.hashCode()
    );
    assertEquals(
        new Acceleration((short) 176, (short) -136, (short) -11).hashCode(),
        this.accel.hashCode()
    );
  }
}
