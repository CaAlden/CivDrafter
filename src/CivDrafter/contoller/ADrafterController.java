package CivDrafter.contoller;

import java.io.IOException;

import CivDrafter.model.IDrafterModel;

/**
 * A containing the generic behavior of Draft Controller.
 */
public abstract class ADrafterController implements IDrafterController {

  public final Appendable ap;
  public final Readable rd;

  /**
   * Construct an ADraftController.
   *
   * @param ap the interface the controller with write to.
   * @param rd the interface the controller will read from.
   */
  public ADrafterController(Appendable ap, Readable rd) {
    this.ap = ap;
    this.rd = rd;
  }

  /**
   * Wrapper for interacting with the appendable.
   * If there is an IOException when writing to the stream, We aren't going to deal with it.
   *
   * @param s the string to send to the Appendable.
   * @throws IllegalStateException if an IOException is raised. This class is not intended for use
   *                               with unreliable Appendables by default. Use a subclass that is
   *                               specifically designed to handle this.
   */
  protected void write(String s) {
    try {
      this.ap.append(s);
    } catch (IOException ioe) {
      throw new IllegalStateException(
              "Should not have encountered an IOException in the first place.");
    }
  }
}
