package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RaceProcessor;
import racingcar.util.Parser;
import racingcar.view.InputView;

public class Race {

    private final RaceProcessor raceProcessor;
    private final InputView inputView;

    public Race(RaceProcessor raceProcessor, InputView inputView) {
        this.raceProcessor = raceProcessor;
        this.inputView = inputView;
    }

    public void run() {
        Cars cars = readyCars();
        int tryCount = inputTryCount();

        proceedRace(tryCount, cars);
    }

    private Cars readyCars() {
        String nameInput = inputView.getNameInputs();
        List<String> names = Parser.toNames(nameInput);

        return raceProcessor.registerCarsFrom(names);
    }

    private int inputTryCount() {
        int tryCount = Parser.toInteger(inputView.getCountInput());
        raceProcessor.validateTryCount(tryCount);

        return tryCount;
    }

    private void proceedRace(int tryCount, Cars cars) {
        for (int i = 0; i < tryCount; i++) {
            List<Car> racedCars = raceProcessor.runOneRound(cars);
        }
    }
}
