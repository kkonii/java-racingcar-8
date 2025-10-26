package racingcar.domain;

import java.util.List;

public class RaceProcessor {

    private final NumberPickerBase randomNumberPicker;

    public RaceProcessor(NumberPickerBase randomNumberPicker) {
        this.randomNumberPicker = randomNumberPicker;
    }

    public List<Integer> runOneRound(Cars cars) {
        List<Integer> distanceOfOneRound = cars.move(randomNumberPicker::pick);

        return distanceOfOneRound;
    }
}
