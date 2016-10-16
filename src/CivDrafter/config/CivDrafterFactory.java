package CivDrafter.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.InputStreamReader;

import java.util.ArrayList;

import CivDrafter.contoller.DraftController;
import CivDrafter.contoller.IDrafterController;
import CivDrafter.model.Civilization;
import CivDrafter.model.DrafterModel;
import CivDrafter.model.ACivilization;
import CivDrafter.model.IDrafterModel;


/**
 * Factory class for the CivDrafter program.
 * Makes a default build.
 */
public class CivDrafterFactory implements ICivDrafterFactory {

  public static ICivDrafterFactory makeCivDrafterFactory(String filename) throws IOException {
    return makeCivDrafterFactory(new File(filename));
  }

  public static ICivDrafterFactory makeCivDrafterFactory(File file) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(file));

    CivDrafterFactory factory = null;
    String config = br.readLine();
    if (config.contains("#CivDraftConfig")) {
      factory = new CivDrafterFactory(br);
    } else {
      throw new IllegalArgumentException("Input file was not the correct format.");
    }
    br.close();
    return factory;
  }

  private final ArrayList<ACivilization> civs;

  /**
   * Construct a configuration from the given civs
   *
   * @param br the reader to read from.
   */
  private CivDrafterFactory(BufferedReader br) {
    this.civs = new ArrayList<>();
    br.lines().forEach((String line) -> {
      String[] civInput = line.split(";");
      if (civInput.length != 3) {
        throw new IllegalArgumentException("Input civilizaiton did not have three inputs.");
      } else {
        this.civs.add(makeCivilization(civInput[0], civInput[1], civInput[2]));
      }
    });
  }

  @Override
  public ArrayList<ACivilization> getCivilizations() {
    return this.civs;
  }

  @Override
  public IDrafterModel makeModel() {
    return new DrafterModel(this.civs);
  }

  @Override
  public IDrafterController makeController() {
    return new DraftController(System.out, new InputStreamReader(System.in));
  }

  @Override
  public ACivilization makeCivilization(String name, String ruler, String info) {
    return new Civilization(name, ruler, info);
  }
}
