package racingcar.domain;

import java.util.List;
import racingcar.exception.Error;

public class RaceProcessor {

    private static final int TRY_ABLE_POINT = 1;

    private final NumberPickerBase randomNumberPicker;

    public RaceProcessor(NumberPickerBase randomNumberPicker) {
        this.randomNumberPicker = randomNumberPicker;
    }

    public List<Integer> runOneRound(Cars cars) {
        List<Integer> distanceOfOneRound = cars.move(randomNumberPicker::pick);

        return distanceOfOneRound;
    }

    public void validateTryCount(int tryCount) {
        if (tryCount < TRY_ABLE_POINT) {
            throw new IllegalArgumentException(Error.TRY_COUNT_MUST_BE_POSITIVE.message());
        }
    }
}
