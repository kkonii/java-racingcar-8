package racingcar.domain;

import java.util.List;
import racingcar.exception.Error;

public class RaceProcessor {

    private static final int TRY_ABLE_POINT = 1;

    private final NumberPickerBase randomNumberPicker;

    public RaceProcessor(NumberPickerBase randomNumberPicker) {
        this.randomNumberPicker = randomNumberPicker;
    }

    public List<Car> runOneRound(Cars cars) {
        cars.move(randomNumberPicker::pick);

        return cars.asList();
    }

    public void validateTryCount(int tryCount) {
        if (tryCount < TRY_ABLE_POINT) {
            throw new IllegalArgumentException(Error.TRY_COUNT_MUST_BE_POSITIVE.message());
        }
    }
}
