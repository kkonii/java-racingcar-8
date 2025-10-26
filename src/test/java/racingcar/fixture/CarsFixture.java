package racingcar.fixture;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarsFixture {

    public static Cars withCountOf(int count) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            cars.add(CarFixture.stopped());
        }

        return new Cars(cars);
    }
}
