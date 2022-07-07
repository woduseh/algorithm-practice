package practice.util;

import java.util.Optional;
import java.util.Properties;

public class OptionalUtil {

    public static Optional<String> getOptionalString(String str) {
        return Optional.ofNullable(str);
    }

    public static Optional<Integer> stringToInt(String str) {
        try {
            return Optional.of(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public int readDutation(Properties props, String name) {
        String value = props.getProperty(name);
        return Optional.ofNullable(value).map(Integer::parseInt).orElse(0);
    }
}
