package CivDrafter.contoller;

import java.util.ArrayList;
import java.util.Scanner;

import CivDrafter.model.ACivilization;
import CivDrafter.model.IDrafterModel;

/**
 * Concrete controller class.
 * Preforms its operations with strings.
 */
public class DraftController extends ADrafterController {

  public DraftController(Appendable ap, Readable rd) {
    super(ap, rd);
  }

  /**
   * Preform the draft on the model.
   * Get input from the user about the draft size.
   *
   * @param model the model to use for the draft.
   * @param civs  the civilizations to draft with.
   */
  @Override
  public void executeDraft(IDrafterModel model, ArrayList<ACivilization> civs) {
    // Get the draft size from the user.
    this.write("Please enter the number of civs to choose from: ");

    Scanner scan = new Scanner(this.rd);
    scan.useDelimiter("\\s+"); // Use any whitespace.

    int draftSize = 3;
    if (scan.hasNextInt()) {
      draftSize = scan.nextInt();
    } else {
      this.write("Something went wrong, using default size of " + draftSize + "\n");
    }


    try {
      ArrayList<ACivilization> d = model.draft(civs, draftSize);
      this.write("Choose from: ");
      for (int ii = 0; ii < d.size() - 1; ii++) {
        ACivilization civ = d.get(ii);
        this.write(civ.getName() + ", ");
      }
      ACivilization civ = d.get(d.size() - 1);
      this.write(civ.getName() + "\n");

    } catch (IllegalArgumentException iae) {
      this.write("Invalid input to draft, " + iae.getMessage() + "\n");
    }
    this.write("Done...\n");
  }
}
