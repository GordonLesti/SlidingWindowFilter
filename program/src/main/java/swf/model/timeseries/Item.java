package swf.model.timeseries;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Item<T> {

  private long time;

  private T data;

  public Item(long time, T data) {
    this.time = time;
    this.data = data;
  }

  public long getTime() {
    return this.time;
  }

  public T getData() {
    return this.data;
  }

  @Override
  public String toString() {
    return this.time + " " + this.data.toString();
  }

  /**
   * Checks if an object equals this Item object.
   */
  @Override
  public boolean equals(Object object) {
    if (object instanceof Item) {
      Item item = (Item) object;
      return this.time == item.time && this.data.equals(item.data);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(77, 73)
        .append(this.time)
        .append(this.data)
        .toHashCode();
  }
}
