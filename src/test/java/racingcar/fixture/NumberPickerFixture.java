package racingcar.fixture;

public class NumberPickerFixture {

    private static final int movableNumber = 5;
    private static final int unmovableNumber = 2;

    private final int number;

    private NumberPickerFixture(int number) {
        this.number = number;
    }

    public static NumberPickerFixture movablePicker() {
        return new NumberPickerFixture(movableNumber);
    }

    public static NumberPickerFixture unmovablePicker() {
        return new NumberPickerFixture(unmovableNumber);
    }

    public int pick() {
        return number;
    }
}
