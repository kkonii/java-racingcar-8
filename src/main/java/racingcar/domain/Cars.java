package racingcar.domain;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int findMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = car.compareWith(maxDistance);
        }

        return maxDistance;
    }
}
