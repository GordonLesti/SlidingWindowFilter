package swf.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import swf.model.timeseries.Item;

import java.lang.Iterable;
import java.util.Iterator;
import java.util.LinkedList;

public class TimeSeries<T> {

  private Iterable<Item<T>> items;

  private Iterable<Item<String>> labels;

  public TimeSeries(Iterable<Item<T>> items, Iterable<Item<String>> labels) {
    this.items = items;
    this.labels = labels;
  }

  public Iterable<Item<T>> getItems() {
    return this.items;
  }

  public Iterable<Item<String>> getLabels() {
    return this.labels;
  }

  /**
   * Returns a sub TimeSeries from start to not included end.
   */
  public TimeSeries<T> subTimeSeries(long start, long end) {
    LinkedList<Item<T>> subItems = new LinkedList<Item<T>>();
    Iterator<Item<T>> itemIterator = this.items.iterator();
    while (itemIterator.hasNext()) {
      Item<T> item = itemIterator.next();
      long time = item.getTime();
      if (time >= start && time < end) {
        subItems.add(item);
      }
    }
    LinkedList<Item<String>> subLabels = new LinkedList<Item<String>>();
    Iterator<Item<String>> labelIterator = this.labels.iterator();
    while (labelIterator.hasNext()) {
      Item<String> item = labelIterator.next();
      long time = item.getTime();
      if (time >= start && time < end) {
        subLabels.add(item);
      }
    }
    return new TimeSeries<T>(subItems, subLabels);
  }

  /**
   * Returns a string representing the TimeSeries.
   */
  @Override
  public String toString() {
    String output = "Items:\n";
    Iterator<Item<T>> itemIterator = this.items.iterator();
    while (itemIterator.hasNext()) {
      output += itemIterator.next().toString() + "\n";
    }
    output += "Labels:\n";
    Iterator<Item<String>> labelIterator = this.labels.iterator();
    while (labelIterator.hasNext()) {
      output += labelIterator.next().toString() + "\n";
    }
    return output;
  }

  /**
   * Checks if an object equals this TimeSeries object.
   */
  @Override
  public boolean equals(Object object) {
    if (object instanceof TimeSeries) {
      TimeSeries timeSeries = (TimeSeries) object;
      return this.items.equals(timeSeries.items) && this.labels.equals(timeSeries.labels);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(97, 71)
        .append(this.items)
        .append(this.labels)
        .toHashCode();
  }
}
