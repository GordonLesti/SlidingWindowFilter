import static org.junit.Assert.assertEquals;

import org.junit.Test;
import swf.algo.filter.complexity.Calculator;
import swf.app.Acceleration;
import swf.app.acceleration.DistanceCalculator;
import swf.model.TimeSeries;
import swf.model.timeseries.Item;

import java.util.LinkedList;

public class CalculatorTest {
  @Test
  public void testCalculateComplexity() {
    final Calculator<Acceleration> calculator = new Calculator<Acceleration>(
        new DistanceCalculator()
    );
    LinkedList<Item<String>> labels = new LinkedList<Item<String>>();

    LinkedList<Item<Acceleration>> items1 = new LinkedList<Item<Acceleration>>();
    items1.add(
        new Item<Acceleration>(182, new Acceleration((short) 30, (short)  -6, (short)  -108))
    );
    items1.add(
        new Item<Acceleration>(300, new Acceleration((short) 30, (short)  -6, (short)  -108))
    );
    items1.add(
        new Item<Acceleration>(691, new Acceleration((short) 30, (short)  -6, (short)  -108))
    );
    TimeSeries<Acceleration> timeSeries1 = new TimeSeries<Acceleration>(items1, labels);
    assertEquals(0, calculator.calculateComplexity(timeSeries1), 0);

    LinkedList<Item<Acceleration>> items2 = new LinkedList<Item<Acceleration>>();
    items2.add(
        new Item<Acceleration>(182, new Acceleration((short) 30, (short)  -6, (short)  -108))
    );
    TimeSeries<Acceleration> timeSeries2 = new TimeSeries<Acceleration>(items2, labels);
    assertEquals(0, calculator.calculateComplexity(timeSeries2), 0);

    LinkedList<Item<Acceleration>> items3 = new LinkedList<Item<Acceleration>>();
    items3.add(
        new Item<Acceleration>(307, new Acceleration((short) 158, (short) -81, (short) 249))
    );
    items3.add(
        new Item<Acceleration>(406, new Acceleration((short) 292, (short) -249, (short) -84))
    );
    items3.add(
        new Item<Acceleration>(713, new Acceleration((short) -202, (short) 222, (short) -283))
    );
    items3.add(
        new Item<Acceleration>(738, new Acceleration((short) -4, (short) -239, (short) -99))
    );
    items3.add(
        new Item<Acceleration>(762, new Acceleration((short) -100, (short) -257, (short) -262))
    );
    TimeSeries<Acceleration> timeSeries3 = new TimeSeries<Acceleration>(items3, labels);
    assertEquals(992.087193748614, calculator.calculateComplexity(timeSeries3), 0);
  }
}
