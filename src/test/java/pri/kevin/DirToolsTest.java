package pri.kevin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DirToolsTest {

    DirTools dirTools;

  @BeforeEach
  void setUp() {
      dirTools = new DirTools();
  }

    @Test
    void scanDirs() throws IOException {
        dirTools.scanDirs("./target/");
    }
}