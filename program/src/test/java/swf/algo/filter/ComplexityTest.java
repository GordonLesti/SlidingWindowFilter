import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import swf.algo.filter.Complexity;
import swf.algo.filter.complexity.Calculator;
import swf.app.Acceleration;
import swf.app.acceleration.DistanceCalculator;
import swf.app.acceleration.RangeFilter;
import swf.model.TimeSeries;
import swf.model.timeseries.Item;

import java.util.LinkedList;

public class ComplexityTest {
  @Test
  public void testIsAccepted() {
    Calculator<Acceleration> complexityCalculator = new Calculator<Acceleration>(
        new DistanceCalculator()
    );
    Complexity<Acceleration> complexityFilter = new Complexity<Acceleration>(
        complexityCalculator,
        new RangeFilter(5, 10)
    );
    LinkedList<Item<String>> labels = new LinkedList<Item<String>>();

    LinkedList<Item<Acceleration>> items1 = new LinkedList<Item<Acceleration>>();
    items1.add(new Item<Acceleration>(185, new Acceleration((short) 64, (short) -17, (short) 72)));
    items1.add(new Item<Acceleration>(186, new Acceleration((short) 65, (short) -17, (short) 72)));
    TimeSeries<Acceleration> timeSeries1 = new TimeSeries<Acceleration>(items1, labels);
    assertFalse(complexityFilter.isAccepted(timeSeries1));

    LinkedList<Item<Acceleration>> items2 = new LinkedList<Item<Acceleration>>();
    items2.add(new Item<Acceleration>(185, new Acceleration((short) 64, (short) -17, (short) 72)));
    items2.add(new Item<Acceleration>(186, new Acceleration((short) 64, (short) -12, (short) 72)));
    TimeSeries<Acceleration> timeSeries2 = new TimeSeries<Acceleration>(items2, labels);
    assertTrue(complexityFilter.isAccepted(timeSeries2));

    LinkedList<Item<Acceleration>> items3 = new LinkedList<Item<Acceleration>>();
    items3.add(new Item<Acceleration>(185, new Acceleration((short) 64, (short) -17, (short) 72)));
    items3.add(new Item<Acceleration>(186, new Acceleration((short) 64, (short) -17, (short) 79)));
    TimeSeries<Acceleration> timeSeries3 = new TimeSeries<Acceleration>(items3, labels);
    assertTrue(complexityFilter.isAccepted(timeSeries3));

    LinkedList<Item<Acceleration>> items4 = new LinkedList<Item<Acceleration>>();
    items4.add(new Item<Acceleration>(185, new Acceleration((short) 64, (short) -17, (short) 72)));
    items4.add(new Item<Acceleration>(186, new Acceleration((short) 54, (short) -17, (short) 72)));
    TimeSeries<Acceleration> timeSeries4 = new TimeSeries<Acceleration>(items4, labels);
    assertTrue(complexityFilter.isAccepted(timeSeries4));

    LinkedList<Item<Acceleration>> items5 = new LinkedList<Item<Acceleration>>();
    items5.add(new Item<Acceleration>(185, new Acceleration((short) 64, (short) -17, (short) 72)));
    items5.add(new Item<Acceleration>(186, new Acceleration((short) 64, (short) -28, (short) 72)));
    TimeSeries<Acceleration> timeSeries5 = new TimeSeries<Acceleration>(items5, labels);
    assertFalse(complexityFilter.isAccepted(timeSeries5));
  }
}
