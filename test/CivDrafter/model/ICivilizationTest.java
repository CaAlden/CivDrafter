package CivDrafter.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calden on 10/16/16.
 */
public abstract class ICivilizationTest {

  protected abstract ICivilization getInstance(String name, String ruler, String info);

  @Test
  public void getRuler() throws Exception {
    ICivilization test = getInstance("name", "ruler", "info");
    assertEquals("ruler", test.getRuler());
  }

  @Test
  public void getName() throws Exception {
    ICivilization test = getInstance("name", "ruler", "info");
    assertEquals("name", test.getName());
  }

  @Test
  public void getInfo() throws Exception {
    ICivilization test = getInstance("name", "ruler", "info");
    assertEquals("info", test.getInfo().infoString());
  }

}