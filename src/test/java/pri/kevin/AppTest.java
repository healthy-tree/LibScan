package pri.kevin;

import org.junit.jupiter.api.Test;
import sun.tools.jar.Main;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void TestMain(){
        String[] args = new String[4];
        args[0] = "-o";
        args[1] = "~/";
        args[2] = "-p";
        args[3] = "~/";
        App.main(args);
    }

}