import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import swf.model.TimeSeries;
import swf.model.timeseries.Item;

import java.util.LinkedList;

public class TimeSeriesTest {
  private TimeSeries<Integer> timeSeries1;
  private TimeSeries<Integer> timeSeries2;
  private TimeSeries<Integer> timeSeries3;
  private TimeSeries<Integer> timeSeries4;
  private TimeSeries<Integer> timeSeries5;
  private TimeSeries<Integer> timeSeries6;

  /**
   * Creates a TimeSeries object.
   */
  @Before
  public void oneTimeSetUp() {
    LinkedList<Item<Integer>> items1 = new LinkedList<Item<Integer>>();
    items1.add(new Item<Integer>(1, 5));
    items1.add(new Item<Integer>(5, 7));
    items1.add(new Item<Integer>(9, -3));
    LinkedList<Item<String>> labels1 = new LinkedList<Item<String>>();
    labels1.add(new Item<String>(2, "START"));
    labels1.add(new Item<String>(7, "END"));
    this.timeSeries1 = new TimeSeries<Integer>(items1, labels1);

    LinkedList<Item<Integer>> items2 = new LinkedList<Item<Integer>>();
    items2.add(new Item<Integer>(5, 7));
    items2.add(new Item<Integer>(9, -3));
    LinkedList<Item<String>> labels2 = new LinkedList<Item<String>>();
    labels2.add(new Item<String>(2, "START"));
    labels2.add(new Item<String>(7, "END"));
    this.timeSeries2 = new TimeSeries<Integer>(items2, labels2);

    LinkedList<Item<Integer>> items3 = new LinkedList<Item<Integer>>();
    items3.add(new Item<Integer>(1, 5));
    items3.add(new Item<Integer>(5, 7));
    items3.add(new Item<Integer>(9, -3));
    LinkedList<Item<String>> labels3 = new LinkedList<Item<String>>();
    labels3.add(new Item<String>(2, "START"));
    this.timeSeries3 = new TimeSeries<Integer>(items3, labels3);

    LinkedList<Item<Integer>> items4 = new LinkedList<Item<Integer>>();
    items4.add(new Item<Integer>(1, -5));
    items4.add(new Item<Integer>(5, 7));
    items4.add(new Item<Integer>(9, -3));
    LinkedList<Item<String>> labels4 = new LinkedList<Item<String>>();
    labels4.add(new Item<String>(2, "START"));
    labels4.add(new Item<String>(7, "END"));
    this.timeSeries4 = new TimeSeries<Integer>(items4, labels4);

    LinkedList<Item<Integer>> items5 = new LinkedList<Item<Integer>>();
    items5.add(new Item<Integer>(1, 5));
    items5.add(new Item<Integer>(5, 7));
    items5.add(new Item<Integer>(9, -3));
    LinkedList<Item<String>> labels5 = new LinkedList<Item<String>>();
    labels5.add(new Item<String>(2, "START"));
    labels5.add(new Item<String>(7, "EnD"));
    this.timeSeries5 = new TimeSeries<Integer>(items5, labels5);

    LinkedList<Item<Integer>> items6 = new LinkedList<Item<Integer>>();
    items6.add(new Item<Integer>(1, 5));
    items6.add(new Item<Integer>(5, 7));
    items6.add(new Item<Integer>(9, -3));
    LinkedList<Item<String>> labels6 = new LinkedList<Item<String>>();
    labels6.add(new Item<String>(2, "START"));
    labels6.add(new Item<String>(7, "END"));
    this.timeSeries6 = new TimeSeries<Integer>(items6, labels6);
  }

  @Test
  public void testGetItems() {
    LinkedList<Item<Integer>> items = new LinkedList<Item<Integer>>();
    items.add(new Item<Integer>(1, 5));
    items.add(new Item<Integer>(5, 7));
    items.add(new Item<Integer>(9, -3));
    assertEquals(items, this.timeSeries1.getItems());
  }

  @Test
  public void testToString() {
    assertEquals("Items:\n1 5\n5 7\n9 -3\nLabels:\n2 START\n7 END\n", this.timeSeries1.toString());
  }

  @Test
  public void testEquals() {
    assertNotEquals(new Object(), this.timeSeries1);
    assertNotEquals(this.timeSeries2, this.timeSeries1);
    assertNotEquals(this.timeSeries3, this.timeSeries1);
    assertNotEquals(this.timeSeries4, this.timeSeries1);
    assertNotEquals(this.timeSeries5, this.timeSeries1);
    assertEquals(this.timeSeries6, this.timeSeries1);
  }

  @Test
  public void testHashCode() {
    assertNotEquals(this.timeSeries2.hashCode(), this.timeSeries1.hashCode());
    assertNotEquals(this.timeSeries3.hashCode(), this.timeSeries1.hashCode());
    assertNotEquals(this.timeSeries4.hashCode(), this.timeSeries1.hashCode());
    assertNotEquals(this.timeSeries5.hashCode(), this.timeSeries1.hashCode());
    assertEquals(this.timeSeries6.hashCode(), this.timeSeries1.hashCode());
  }
}
