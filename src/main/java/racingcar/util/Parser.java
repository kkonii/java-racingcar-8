package racingcar.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.exception.Error;

public class Parser {

    private static final Pattern NUMERIC = Pattern.compile("^-?\\d+$");

    public static int parseToInteger(String value) {
        validateType(value);

        return Integer.parseInt(value);
    }

    private static void validateType(String value) {
        Matcher matcher = NUMERIC.matcher(value);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(Error.NOT_A_NUMBER.message());
        }
    }
}
