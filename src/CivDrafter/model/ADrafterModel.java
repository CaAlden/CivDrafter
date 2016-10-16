package CivDrafter.model;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Abstract Model class for generic Model behavior and fields.
 */
public abstract class ADrafterModel implements IDrafterModel {

  public static final String DEFAULT_CONFIG_PATH = "civlist.txt";


  protected final ArrayList<ACivilization> civs;

  /**
   * Default constructor.
   */
  public ADrafterModel() {
    this.civs = new ArrayList<>();
  }

  public ADrafterModel(ArrayList<ACivilization> civs) {
    Objects.requireNonNull(civs, "The provided list of Civs must be non-null.");
    this.civs = civs;
  }

  /**
   * Preform the actual drafting of the Civs.
   *
   * @param civs      the list of Civilizations to choose from.
   * @param draftSize the number of Civilizations to choose.
   * @return the Civilizations that were chosen in the draft.
   */
  protected abstract ArrayList<ACivilization> makeDraft(ArrayList<ACivilization> civs,
                                                        int draftSize);

  /**
   * Preform these operations before the draft.
   * This method is called first in draft.
   *
   * @param civs      the civilizations passed into draft method.
   * @param draftSize the size of the draft.
   * @throws IllegalArgumentException if something about the pre-draft state is invalid.
   */
  protected void preDraft(ArrayList<ACivilization> civs,
                          int draftSize) throws IllegalArgumentException {
    Objects.requireNonNull(civs);
    if ((civs.size() < draftSize) || (civs.size() == 0)) {
      throw new IllegalArgumentException("Not enough Civilizations provided for draft size.");
    }
    if (draftSize < 1) {
      throw new IllegalArgumentException("Draft size should be at least 1");
    }
  }

  /**
   * Preform these operations after the draft.
   * This method is called just before chosen is returned from draft.
   *
   * @param chosen the parameters that were chosen by the draft algorithm.
   */
  protected void postDraft(ArrayList<ACivilization> chosen) {
  }


  @Override
  public ArrayList<ACivilization> draft(ArrayList<ACivilization> civs,
                                        int draftSize) throws IllegalArgumentException {


    this.preDraft(civs, draftSize);
    ArrayList<ACivilization> chosen = this.makeDraft(civs, draftSize);
    this.postDraft(chosen);
    return chosen;
  }

  /**
   * Get the current list of Civilizations.
   *
   * @return The current list of Civilizations.
   */
  public ArrayList<ACivilization> getCivilizations() {
    return this.civs;
  }

}
