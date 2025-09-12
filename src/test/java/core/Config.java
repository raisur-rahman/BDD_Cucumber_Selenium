package core;

public final class Config {
    public static final Env ENV = JsonConfig.load("env.json", Env.class);
    public static final Creds CREDS = JsonConfig.load("credentials.json", Creds.class);

    private Config() {}

    public static final class Env {
        public String baseUrl;
        public String browserName;
        public boolean headless;
    }

    public static final class Creds {
        public String username;
        public String password;
    }
}
