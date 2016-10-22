package CivDrafter.contoller;

import org.junit.Test;

import java.util.ArrayList;
import java.io.StringReader;

import CivDrafter.model.ACivilization;
import CivDrafter.model.Civilization;
import CivDrafter.model.IDrafterModel;
import CivDrafter.model.DrafterModel;
import CivDrafter.model.StringInfo;

import static org.junit.Assert.*;

/**
 * Created by calden on 10/16/16.
 */
public abstract class IDrafterControllerTest {

  protected abstract IDrafterController getInstance(Appendable ap, Readable rd);

  protected IDrafterModel mockModel(ArrayList<ACivilization> expectedArray,
                                    int expectedCount,
                                    boolean throwInvalid) {
    return new DrafterModel() {
      @Override
      public ArrayList<ACivilization> draft(ArrayList<ACivilization> civs, int count) {
        assertEquals(expectedArray, civs);
        assertEquals(expectedCount, count);
        if (throwInvalid) {
          throw new IllegalArgumentException("test");
        }
        return civs;
      }
    };
  }

  @Test
  public void executeDraft() throws Exception {
    StringBuilder ap = new StringBuilder();
    StringReader sr = new StringReader("3\n");
    IDrafterController controller = getInstance(ap, sr);
    ArrayList<ACivilization> test = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      test.add(new Civilization("test", "test", new StringInfo("test")));
    }

    IDrafterModel modelMock = mockModel(test, 3, false);
    controller.executeDraft(modelMock, test);
  }

  @Test
  public void HandleInvalidArgs() {
    StringBuilder ap = new StringBuilder();
    StringReader sr = new StringReader("0\n");
    IDrafterController controller = getInstance(ap, sr);
    ArrayList<ACivilization> test = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      test.add(new Civilization("test", "test", new StringInfo("test")));
    }

    IDrafterModel modelMock = mockModel(test, 0, true);
    controller.executeDraft(modelMock, test);
    assertTrue(ap.toString().contains("something"));
  }

}