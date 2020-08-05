import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ConfigParserTest {
    ConfigParser mapStoredValue = null;
    @Test
    void getProduction() {
        mapStoredValue = new ConfigParser("./src/main/java/config.txt");
        assertAll(
                ()-> assertEquals("fintek",mapStoredValue.get("application.name")),
                ()->assertEquals("8080",mapStoredValue.get("application.port")),
                ()->assertEquals("/api/v1",mapStoredValue.get("application.context-url")),
                ()->assertEquals("127.0.0.1",mapStoredValue.get("host")),
                ()->assertEquals("sq04_db",mapStoredValue.get("dbname")),
                ()->assertEquals("production",mapStoredValue.get("mode"))
        );

    }

    @Test
    void getDevelopment() {
        mapStoredValue = new ConfigParser("./src/main/java/config.dev.txt");
        assertAll(
                ()-> assertEquals("fintek-development",mapStoredValue.get("application.name")),
                ()->assertEquals("8082",mapStoredValue.get("application.port")),
                ()->assertEquals("/api/v1",mapStoredValue.get("application.context-url")),
                ()->assertEquals("127.0.0.1",mapStoredValue.get("host")),
                ()->assertEquals("sq04_db-development",mapStoredValue.get("dbname")),
                ()->assertEquals("development",mapStoredValue.get("mode"))
        );

    }

    @Test
    void getStaging() {
        mapStoredValue = new ConfigParser("./src/main/java/config.staging.txt");
        assertAll(
                ()-> assertEquals("fintek-staging",mapStoredValue.get("application.name")),
                ()->assertEquals("8081",mapStoredValue.get("application.port")),
                ()->assertEquals("/api/v1",mapStoredValue.get("application.context-url")),
                ()->assertEquals("127.0.0.1",mapStoredValue.get("host")),
                ()->assertEquals("sq04_db",mapStoredValue.get("dbname")),
                ()->assertEquals("staging",mapStoredValue.get("mode"))
        );

    }

}