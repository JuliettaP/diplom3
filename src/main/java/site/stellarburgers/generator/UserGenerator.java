package site.stellarburgers.generator;

public class UserGenerator {

    public static String DEFAULT_NAME = "JuliettaP";
    public static String DEFAULT_EMAIL = "juliettap@test.ru";

    public static String DEFAULT_PASSWORD = "pwd123";
    public static String SHORT_PASSWORD = "123";

    public static String getNewRandomEmail() {
        return Math.random() + DEFAULT_EMAIL;
    }
}
