package racingcar.domain;

import racingcar.exception.Error;

public class Car {

    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;
    private int distance;

    private Car(String name) {
        validateBlank(name);
        validateLength(name);
        this.name = name;
    }

    public static Car withName(String name) {
        return new Car(name);
    }


    private void validateLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(Error.NAME_LENGTH_IS_OVER.messageOf(MAXIMUM_NAME_LENGTH));
        }
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(Error.VALUE_IS_BLANK.message());
        }
    }
}
