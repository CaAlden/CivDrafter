package CivDrafter.contoller;

import java.util.ArrayList;

import CivDrafter.model.ACivilization;
import CivDrafter.model.IDrafterModel;

/**
 * Basic interface for a drafter Controller.
 */
public interface IDrafterController {

  /**
   * Manage drafting with the a given model.
   *
   * @param model the model to use for the draft.
   * @param civs  the civilizations to draft with.
   */
  void executeDraft(IDrafterModel model, ArrayList<ACivilization> civs);
}
