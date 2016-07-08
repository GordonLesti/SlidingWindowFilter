import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;
import swf.model.timeseries.Item;

public class ItemTest {
  private Item item;

  @Before
  public void oneTimeSetUp() {
    item = new Item<Integer>(3, -9);
  }

  @Test
  public void testGetTime() {
    assertSame((long) 3, this.item.getTime());
  }

  @Test
  public void testGetData() {
    assertSame(-9, this.item.getData());
  }

  @Test
  public void testToString() {
    assertEquals("3 -9", this.item.toString());
  }

  @Test
  public void testEquals() {
    assertNotEquals(new Object(), this.item);
    assertNotEquals(new Item<Integer>(2, -9), this.item);
    assertNotEquals(new Item<Integer>(3, -10), this.item);
    assertEquals(new Item<Integer>(3, -9), this.item);
  }

  @Test
  public void testHashCode() {
    assertNotEquals(new Item<Integer>(2, -9).hashCode(), this.item.hashCode());
    assertNotEquals(new Item<Integer>(3, -10).hashCode(), this.item.hashCode());
    assertEquals(new Item<Integer>(3, -9).hashCode(), this.item.hashCode());
  }
}
