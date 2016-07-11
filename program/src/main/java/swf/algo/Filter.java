package swf.algo;

import swf.model.TimeSeries;

public interface Filter<T> {
  public boolean isAccepted(T object);
}
