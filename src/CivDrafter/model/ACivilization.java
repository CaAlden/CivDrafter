package CivDrafter.model;

import java.util.Objects;

/**
 * Abstract class for Civilizations
 */
public abstract class ACivilization implements ICivilization {

  private final String name;
  private final String ruler;
  protected IInfo info;

  public ACivilization(String name, String ruler, IInfo info) {
    Objects.requireNonNull(name, "A Civilization must have a name.");
    Objects.requireNonNull(ruler, "A Civilization must have a ruler");
    this.name = name;
    this.ruler = ruler;
    this.info = info;
  }

  @Override
  public final String getRuler() {
    return ruler;
  }

  @Override
  public final String getName() {
    return name;
  }

  @Override
  public IInfo getInfo() {
    return info;
  }

  /**
   * Is the given Object equal to this object.
   *
   * @param other some other object.
   * @return are the objects equal.10
   */
  @Override
  public boolean equals(Object other) {
    if (other instanceof ACivilization) {
      return ((ACivilization) other).name.equals(this.name) &&
              ((ACivilization) other).ruler.equals(this.ruler);
    }
    return false;
  }

  /**
   * Get this object's hash code.
   * Overridden because equals is overridden.
   *
   * @return this object's hash code.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.ruler);
  }
}
