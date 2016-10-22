package CivDrafter.model;

/**
 * Parser class that doesn't actually parse the string.
 */
public class PassThroughParser implements IParser {

  @Override
  public String parse(String encodedString) {
    return encodedString;
  }
}
