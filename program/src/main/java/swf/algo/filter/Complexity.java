package swf.algo.filter;

import swf.algo.Filter;
import swf.algo.filter.complexity.Calculator;
import swf.model.TimeSeries;

public class Complexity<T> implements Filter<TimeSeries<T>> {

  private Calculator<T> complexityCalculator;
  private Filter<Double> doubleFilter;

  public Complexity(Calculator<T> complexityCalculator, Filter<Double> doubleFilter) {
    this.complexityCalculator = complexityCalculator;
    this.doubleFilter = doubleFilter;
  }

  @Override
  public boolean isAccepted(TimeSeries<T> timeSeries) {
    double complexity = this.complexityCalculator.calculateComplexity(timeSeries);
    return this.doubleFilter.isAccepted(complexity);
  }
}
