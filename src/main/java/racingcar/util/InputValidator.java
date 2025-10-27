package racingcar.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.exception.Error;

public class InputValidator {

    private static final Pattern NAME_FORMAT_PATTERN = Pattern.compile("^\\w+(,+\\w+)*$");
    private static final Pattern NUMERIC = Pattern.compile("^[+-]?\\d+$");

    public static void blankValue(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(Error.VALUE_IS_BLANK.message());
        }
    }

    public static void numericType(String value) {
        Matcher matcher = NUMERIC.matcher(value);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(Error.NOT_A_NUMBER.message());
        }
    }

    public static void nameFormat(String consoleInput) {
        Matcher matcher = NAME_FORMAT_PATTERN.matcher(consoleInput);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(Error.NAME_FORMAT_IS_NOT_VALID_PATTERN.message());
        }
    }
}
