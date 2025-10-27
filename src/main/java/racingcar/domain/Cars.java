package racingcar.domain;

import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import racingcar.exception.Error;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateUnique(cars);
        this.cars = cars;
    }

    public static Cars ofUnique(List<Car> cars) {
        return new Cars(cars);
    }

    private void validateUnique(List<Car> cars) {
        long uniqueCars = cars.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (uniqueCars != cars.size()) {
            throw new IllegalArgumentException(Error.CAR_NAME_IS_NOT_UNIQUE.message());
        }
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
