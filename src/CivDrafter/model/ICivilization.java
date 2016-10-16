package CivDrafter.model;

/**
 * The basic interface for a Civilization.
 */
public interface ICivilization {

  /**
   * Get the name of the ruler of this Civilization.
   *
   * @return the name of the Ruler of this Civilization.
   */
  String getRuler();

  /**
   * Get the name of this Civilization
   *
   * @return the name of this Civilization.
   */
  String getName();

  /**
   * Return a description of this Civilization.
   *
   * @return the description.
   */
  String getInfo();
}
