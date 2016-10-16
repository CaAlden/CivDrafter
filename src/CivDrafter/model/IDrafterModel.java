package CivDrafter.model;

import java.util.ArrayList;

/**
 * Drafter Model interface. Basic functionality of the Drafter Model.
 */
public interface IDrafterModel {

  /**
   * Draft Civilizations.
   *
   * @param civs      the Civilizations to draft from.
   * @param draftSize the number of Civilizations to return.
   * @return A list of Civilizations to choose from in the draft.
   * @throws IllegalArgumentException if a Draft is not possible with the inputs.
   */
  ArrayList<ACivilization> draft(ArrayList<ACivilization> civs,
                                 int draftSize) throws IllegalArgumentException;

  /**
   * Returns the default list of Civilizations.
   *
   * @return the default list of Civilizations.
   */
  ArrayList<ACivilization> getCivilizations();
}
