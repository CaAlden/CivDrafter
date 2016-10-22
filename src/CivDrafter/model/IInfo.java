package CivDrafter.model;

/**
 * Interface for an information object.
 */
public interface IInfo {

  /**
   * Get this info object's info string.
   * @return the information formatted as a string.
   */
  String infoString();

  /**
   * Tell the info object how to parse the information.
   * @param parser way to parse the information.
   */
  void setParser(IParser parser);

}
