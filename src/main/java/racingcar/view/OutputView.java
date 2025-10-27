package racingcar.view;

import java.util.List;
import racingcar.dto.CarDto;

public class OutputView {

    private static final String MOVE_FORWARD = "-";
    private static final String ROUND_RESULT_OF = "%s : %s";

    public void printResultOf(List<CarDto> cars) {
        for (CarDto car : cars) {
            System.out.printf(ROUND_RESULT_OF, car.name(), MOVE_FORWARD.repeat(car.distance()));
            System.out.println();
        }
        System.out.println();
    }
}
