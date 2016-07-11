package swf.app.acceleration;

import swf.algo.Filter;

public class RangeFilter implements Filter<Double> {
  private double minValue;
  private double maxValue;

  public RangeFilter(double minValue, double maxValue) {
    this.minValue = minValue;
    this.maxValue = maxValue;
  }

  /**
   * Checks if the given double is inside of the range.
   */
  public boolean isAccepted(Double number) {
    if (number >= this.minValue && number <= this.maxValue) {
      return true;
    }
    return false;
  }
}
