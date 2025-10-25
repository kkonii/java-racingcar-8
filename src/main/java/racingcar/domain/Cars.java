package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Car> findWinners() {
        int maxDistance = findMaxDistance();
        return cars.stream()
                .filter(car -> car.equalsDistance(maxDistance))
                .collect(Collectors.toList());
    }
}
