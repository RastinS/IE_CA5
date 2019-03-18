package Static;

public class Configs {
    public static String READER_IP       = "http://142.93.134.194:8000";
    public static String SITE_URL        = "joboonja";
    public static String SERVICE_URL     = READER_IP + "/" + SITE_URL;
    public static String USER_DATA       = "[{" +
            "\"id\":\"1\"," +
            "\"firstName\":\"ali\"," +
            "\"lastName\":\"sharifzadeh\"," +
            "\"skills\":[" +
            "{\"name\":\"HTML\",\"point\":5}," +
            "{\"name\":\"Javascript\",\"point\":4}," +
            "{\"name\":\"C++\",\"point\":2}," +
            "{\"name\":\"Java\",\"point\":3}," +
            "{\"name\":\"MySQL\",\"point\":3}," +
            "{\"name\":\"PHP\",\"point\":3}," +
            "{\"name\":\"CSS\",\"point\":3}" +
            "]," +
            "\"jobTitle\":\"web developer\"," +
            "\"bio\":\"روی سنگ قبرم بنویسید: خدا بیامرز میخواست خیلیکارا بکنه ولی پول نداشت\"" +
            "},{" +
            "\"id\":\"2\"," +
            "\"firstName\":\"hosein\"," +
            "\"lastName\":\"alizade\"," +
            "\"skills\":[" +
            "{\"name\":\"HTML\",\"point\":5}," +
            "{\"name\":\"Javascript\",\"point\":4}," +
            "{\"name\":\"PHP\",\"point\":2}," +
            "{\"name\":\"Node.js\",\"point\":3}" +
            "]," +
            "\"jobTitle\":\"back-end developer\"," +
            "\"bio\":\"بودن یا نبودن، مساله این است\"" +
            "}]";
    public static int    SUCCESSFUL_CODE = 200;
    public static int    FORBIDDEN_CODE  = 403;
}
