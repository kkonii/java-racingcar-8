package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Integer> move(NumberPickerBase numberPicker) {
        List<Integer> distanceOfCars = new ArrayList<>();

        for (Car car : cars) {
            int randomNumber = numberPicker.pick();
            distanceOfCars.add(car.move(randomNumber));
        }

        return distanceOfCars;
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
