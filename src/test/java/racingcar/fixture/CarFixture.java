package racingcar.fixture;

import racingcar.domain.Car;

public class CarFixture {

    public static Car moved() {
        Car car = Car.withName("move");
        car.move(5);

        return car;
    }

    public static Car stopped() {
        Car car = Car.withName("stop");
        car.move(2);

        return car;
    }
}
