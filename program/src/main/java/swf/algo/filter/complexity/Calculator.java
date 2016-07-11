package swf.algo.filter.complexity;

import swf.algo.DistanceCalculator;
import swf.model.TimeSeries;
import swf.model.timeseries.Item;

import java.util.Iterator;

public class Calculator<T> {

  private DistanceCalculator<T> distanceCalculator;

  public Calculator(DistanceCalculator<T> distanceCalculator) {
    this.distanceCalculator = distanceCalculator;
  }

  /**
   * Calculates the complexity of a TimeSeries.
   */
  public double calculateComplexity(TimeSeries<T> timeSeries) {
    Iterator<Item<T>> iterator = timeSeries.getItems().iterator();
    double complexity = 0;
    if (iterator.hasNext()) {
      T lastItemData = iterator.next().getData();
      double sum = 0;
      while (iterator.hasNext()) {
        T currentItemData = iterator.next().getData();
        double distance = this.distanceCalculator.calculateDistance(lastItemData, currentItemData);
        sum += distance * distance;
        lastItemData = currentItemData;
      }
      complexity = Math.sqrt(sum);
    }
    return complexity;
  }
}
