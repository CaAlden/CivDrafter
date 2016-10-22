package CivDrafter.model;

/**
 * Information class for the most basic type of string info.
 */
public class StringInfo implements IInfo {

  private IParser parser;
  private String infoUnparsed;


  /**
   * Construct a String info object.
   * @param info the (possibly encoded) information string.
   * @param parser how to parse the info string.
   */
  public StringInfo(String info, IParser parser) {
    this.infoUnparsed = info;
    this.parser = parser;
  }

  /**
   * Construct a StringInfo object from the given information.
   * A PassThroughParser is used by default since no parser was specified.
   * @param info the information string.
   */
  public StringInfo(String info) {
    this(info, new PassThroughParser());
  }

  @Override
  public String infoString() {
    if (this.parser == null) {
      throw new IllegalStateException("Cannot get info when the parser is not set.");
    }
    return this.parser.parse(this.infoUnparsed);
  }

  @Override
  public void setParser(IParser parser) {
    this.parser = parser;
  }
}
