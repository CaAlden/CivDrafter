package CivDrafter.config;

import org.junit.Test;

import java.util.ArrayList;

import CivDrafter.contoller.IDrafterController;
import CivDrafter.model.ACivilization;
import CivDrafter.model.Civilization;
import CivDrafter.model.ICivilization;
import CivDrafter.model.IDrafterModel;

import static org.junit.Assert.*;

/**
 * Created by calden on 10/16/16.
 */
public abstract class ICivDrafterFactoryTest {

  protected abstract ICivDrafterFactory getInstance(String toLoad);

  @Test
  public void getCivilizations() throws Exception {

    ICivDrafterFactory factory = this.getInstance("resources/test.cfg");
    ArrayList<ACivilization> civs = factory.getCivilizations();
    assertEquals(3, factory.getCivilizations().size());
    Civilization test1 = new Civilization("American", "Washington", "None");
    Civilization test2 = new Civilization("Arabian", "Harun al-Rashid", "None");
    Civilization test3 = new Civilization("Assyrian", "Ashurbanipal", "None");
    assertEquals(test1, civs.get(0));
    assertEquals(test2, civs.get(1));
    assertEquals(test3, civs.get(2));
  }

  @Test
  public void makeModel() throws Exception {
    ICivDrafterFactory factory = getInstance("resources/test.cfg");
    assertTrue(factory.makeModel() instanceof IDrafterModel);
  }

  @Test
  public void makeController() throws Exception {
    ICivDrafterFactory factory = getInstance("resources/test.cfg");
    assertTrue(factory.makeController() instanceof IDrafterController);
  }

  @Test
  public void makeCivilization() throws Exception {
    ICivDrafterFactory factory = getInstance("resources/test.cfg");
    ICivilization civ = factory.makeCivilization("Civ", "king", "test");
    assertTrue(civ instanceof ICivilization);
    assertEquals("Civ", civ.getName());
    assertEquals("king", civ.getRuler());
    assertEquals("test", civ.getInfo());
  }

}