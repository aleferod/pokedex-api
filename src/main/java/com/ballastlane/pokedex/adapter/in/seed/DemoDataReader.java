package com.ballastlane.pokedex.adapter.in.seed;

import java.util.List;
import org.springframework.core.io.Resource;

/** Reads the demo data file (stub). */
public final class DemoDataReader {

  private DemoDataReader() {}

  public static DemoData read(Resource resource) {
    return new DemoData(null, List.of(), List.of());
  }
}
