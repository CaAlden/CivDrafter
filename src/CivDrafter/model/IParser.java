package CivDrafter.model;

/**
 * Interface for how to parse information.
 */
public interface IParser {

  /**
   * Parse and encoded string and return an Info String.
   * @param encodedString a string in some encoded format.
   * @return the information in the string in the expected format
   */
  String parse(String encodedString);

}
