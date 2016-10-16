package CivDrafter.model;

import java.util.ArrayList;

/**
 * Concrete Drafter Class.
 */
public class DrafterModel extends ADrafterModel {

  /**
   * Construct a model for the given civs.
   *
   * @param civs the Civs to use in this model.
   */
  public DrafterModel(ArrayList<ACivilization> civs) {
    super(civs);
  }

  /**
   * Default Constructor.
   */
  public DrafterModel() {
    super();
  }

  /**
   * Make a random draft.
   * This method is called by draft in the ADrafterModel class. civs and draftSize are ensured
   * to be valid when it is called there.
   *
   * @param civs      the list of Civilizations to choose from.
   * @param draftSize the number of Civilizations to choose.
   * @return the civs that were chosen.
   */
  @Override
  protected ArrayList<ACivilization> makeDraft(ArrayList<ACivilization> civs, int draftSize) {
    ArrayList<ACivilization> copyOfCivs = new ArrayList<>(civs);
    ArrayList<ACivilization> chosen = new ArrayList<>();
    // Preform the draft
    for (int ii = 0; ii < draftSize; ii++) {
      int randomChoice = (int) (Math.random() * copyOfCivs.size());
      ACivilization choice = copyOfCivs.remove(randomChoice);
      chosen.add(choice);
    }

    return chosen;
  }
}
