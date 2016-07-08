package swf.app;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Acceleration {
  private short valueX;
  private short valueY;
  private short valueZ;

  /**
   * Creates a instance of Acceleration.
   */
  public Acceleration(short valueX, short valueY, short valueZ) {
    this.valueX = valueX;
    this.valueY = valueY;
    this.valueZ = valueZ;
  }

  public short getX() {
    return this.valueX;
  }

  public short getY() {
    return this.valueY;
  }

  public short getZ() {
    return this.valueZ;
  }

  @Override
  public String toString() {
    return this.valueX + " " + this.valueY + " " + this.valueZ;
  }

  /**
   * Checks if an object equals this Acceleration object.
   */
  @Override
  public boolean equals(Object object) {
    if (object instanceof Acceleration) {
      Acceleration accel = (Acceleration) object;
      return this.valueX == accel.valueX && this.valueY == accel.valueY
        && this.valueZ == accel.valueZ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(93, 51)
        .append(this.valueX)
        .append(this.valueY)
        .append(this.valueZ)
        .toHashCode();
  }
}
