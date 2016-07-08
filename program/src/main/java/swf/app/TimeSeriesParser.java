package swf.app;

import swf.model.TimeSeries;
import swf.model.timeseries.Item;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class TimeSeriesParser {

  /**
   * Creates a instance of TimeSeries.
   */
  public static TimeSeries<Acceleration> parseFileToTimeSeries(String filename)
    throws FileNotFoundException, IOException {
    LinkedList<Item<Acceleration>> itemList = new LinkedList<Item<Acceleration>>();
    LinkedList<Item<String>> labelList = new LinkedList<Item<String>>();
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] splits = line.split(" ");
        long time = Long.parseLong(splits[0]);
        if (splits.length == 4) {
          Acceleration accel = new Acceleration(
              Short.parseShort(splits[1]),
              Short.parseShort(splits[2]),
              Short.parseShort(splits[3])
          );
          Item<Acceleration> item = new Item<Acceleration>(time, accel);
          itemList.add(item);
        } else if (splits.length == 2) {
          labelList.add(new Item<String>(time, splits[1]));
        }
      }
    }
    Comparator<Item> itemComparator = createItemComparator();
    Collections.sort(itemList, itemComparator);
    Collections.sort(labelList, itemComparator);
    return new TimeSeries<Acceleration>(itemList, labelList);
  }

  private static Comparator<Item> createItemComparator() {
    return new Comparator<Item>() {
      public int compare(Item item1, Item item2) {
        return (int) (item1.getTime() - item2.getTime());
      }
    };
  }
}
