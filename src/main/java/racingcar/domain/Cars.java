package racingcar.domain;

import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(IntSupplier pickedNumber) {
        for (Car car : cars) {
            int number = pickedNumber.getAsInt();
            car.move(number);
        }
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

    public List<Car> asList() {
        return List.copyOf(cars);
    }
}
