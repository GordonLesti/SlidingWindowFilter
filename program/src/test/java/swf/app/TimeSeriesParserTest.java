import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import swf.app.Acceleration;
import swf.app.TimeSeriesParser;
import swf.model.TimeSeries;
import swf.model.timeseries.Item;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class TimeSeriesParserTest {
  @Test
  public void testParseFileToTimeSeries() throws FileNotFoundException, IOException {
    LinkedList<Item<Acceleration>> itemList = new LinkedList<Item<Acceleration>>();
    itemList.add(
        new Item<Acceleration>(1495, new Acceleration((short) -13,(short) -16,(short) 90))
    );
    itemList.add(
        new Item<Acceleration>(1513, new Acceleration((short) -11,(short) -16,(short) 90))
    );
    itemList.add(
        new Item<Acceleration>(1514, new Acceleration((short) -10,(short) -17,(short) 82))
    );
    itemList.add(
        new Item<Acceleration>(1520, new Acceleration((short) -8,(short) -16,(short) 92))
    );
    itemList.add(
        new Item<Acceleration>(1525, new Acceleration((short) -8,(short) -15,(short) 93))
    );
    LinkedList<Item<String>> labelList = new LinkedList<Item<String>>();
    labelList.add(new Item<String>(1520, "START"));
    labelList.add(new Item<String>(1521, "END"));
    TimeSeries<Acceleration> timeSeries = new TimeSeries<Acceleration>(itemList, labelList);
    assertEquals(timeSeries, TimeSeriesParser.parseFileToTimeSeries("data/test.txt"));
  }
}
