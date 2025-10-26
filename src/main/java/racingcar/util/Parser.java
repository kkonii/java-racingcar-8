package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import racingcar.exception.Error;

public class Parser {

    private static final Pattern NUMERIC = Pattern.compile("^[+-]?\\d+$");
    private static final String DELIMITER = ",";

    public static int toInteger(String value) {
        validateType(value);

        return Integer.parseInt(value);
    }

    private static void validateType(String value) {
        Matcher matcher = NUMERIC.matcher(value);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(Error.NOT_A_NUMBER.message());
        }
    }

    public static List<String> toNames(String consoleInput) {
        return Arrays.stream(consoleInput.split(DELIMITER))
                .map(String::strip)
                .collect(Collectors.toList());
    }
}
