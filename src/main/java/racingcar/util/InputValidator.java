package racingcar.util;

import racingcar.exception.Error;

public class InputValidator {

    public static void blankValue(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(Error.VALUE_IS_BLANK.message());
        }
    }
}
