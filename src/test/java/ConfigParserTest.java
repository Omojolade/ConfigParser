import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigParserTest {

    @Test
    void get() {
        ConfigParser config = new ConfigParser("production");
        String response = config.get("mode");
//        assertNotNull(response);
        assertEquals("production", config.get("mode"));
    }

//    @Test
//    void get() {
//    }
}