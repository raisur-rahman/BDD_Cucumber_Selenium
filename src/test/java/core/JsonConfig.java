package core;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public final class JsonConfig {
    private static final Gson GSON = new Gson();
    private JsonConfig() {}

    public static <T> T load(String resourcePath, Class<T> type) {
        InputStream is = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(resourcePath);
        if (is == null) {
            throw new IllegalStateException("Resource not found: " + resourcePath);
        }
        try (InputStreamReader r = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            return GSON.fromJson(r, type);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read " + resourcePath, e);
        }
    }
}
