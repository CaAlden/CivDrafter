package CivDrafter;

import java.io.IOException;

import CivDrafter.config.ICivDrafterFactory;
import CivDrafter.config.CivDrafterFactory;
import CivDrafter.contoller.IDrafterController;
import CivDrafter.model.IDrafterModel;

/**
 * Main class for the Civ Drafter program.
 */
public class CivDrafter {

  /**
   * The main method of the program.
   *
   * @param args command line arguments.
   */
  public static void main(String[] args) {
    ICivDrafterFactory factory;
    try {
      // Make a factory.
      factory = CivDrafterFactory.makeCivDrafterFactory("resources/CivDrafter.cfg");

      // Make all of the parts.
      IDrafterController controller = factory.makeController();
      IDrafterModel model = factory.makeModel();
      // Preform the draft
      controller.executeDraft(model, factory.getCivilizations());

    } catch (IOException ioe) {
      System.err.println("Error reading config file: " + ioe.getMessage());
      System.exit(1); // return error.
    }
  }
}
