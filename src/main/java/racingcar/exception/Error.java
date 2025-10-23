package racingcar.exception;

public enum Error {

    NOT_A_NUMBER("숫자 값만 입력할 수 있습니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
