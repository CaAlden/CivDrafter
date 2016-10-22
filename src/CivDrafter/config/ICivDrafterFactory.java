package CivDrafter.config;

import java.util.ArrayList;

import CivDrafter.contoller.IDrafterController;
import CivDrafter.model.ACivilization;
import CivDrafter.model.IDrafterModel;
import CivDrafter.model.IInfo;

/**
 * Class for configuring CivDrafter from a file.
 */
public interface ICivDrafterFactory {
  /**
   * Get the civilizations from the configurator.
   *
   * @return A list of civilizations.
   */
  ArrayList<ACivilization> getCivilizations();

  /**
   * Make a DrafterModel.
   *
   * @return the new Drafter Model.
   */
  IDrafterModel makeModel();

  /**
   * Make a controller.
   *
   * @return the new Controller.
   */
  IDrafterController makeController();

  /**
   * Make a new civilization from the given information.
   *
   * @param name  the name of the Civilization.
   * @param ruler the name of the Civilization's ruler.
   * @param info  the information about this Civilization.
   * @return the created ICivilization object.
   */
  ACivilization makeCivilization(String name, String ruler, IInfo info);
}
