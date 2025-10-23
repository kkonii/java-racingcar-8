package racingcar.exception;

public enum Error {

    NOT_A_NUMBER("숫자 값만 입력할 수 있습니다."),
    NAME_LENGTH_IS_OVER("자동차 이름은 최대 %d자 까지만 입력할 수 있습니다."),
    VALUE_IS_BLANK("해당 값은 비어있을 수 없습니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

    public String messageOf(int numberValue) {
        return String.format(message, numberValue);
    }
}
