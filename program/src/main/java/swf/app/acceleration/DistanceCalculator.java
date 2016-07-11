package swf.app.acceleration;

import swf.app.Acceleration;

public class DistanceCalculator implements swf.algo.DistanceCalculator<Acceleration> {

  /**
   * Calculates the distance between two Acceleration objects.
   */
  public double calculateDistance(Acceleration accel1, Acceleration accel2) {
    double diffX = accel1.getX() - accel2.getX();
    double diffY = accel1.getY() - accel2.getY();
    double diffZ = accel1.getZ() - accel2.getZ();
    return Math.sqrt(diffX * diffX + diffY * diffY + diffZ * diffZ);
  }
}
