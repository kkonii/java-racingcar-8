package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.Error;
import racingcar.fixture.CarsFixture;
import racingcar.fixture.NumberPickerFixture;

public class RaceProcessorTest {

    private static final int ONE_FORWARD = 1;

    @Test
    @DisplayName("[성공] 입력한 자동차들이 한 킨씩 전진 후 거리를 반환한다")
    void test_race_one_round() {
        //given
        NumberPickerBase picker = NumberPickerFixture.movablePicker();
        RaceProcessor processor = new RaceProcessor(picker);

        //when
        Cars cars = CarsFixture.withCountOf(2);
        List<Car> racedCars = processor.runOneRound(cars);

        //then
        Assertions.assertThat(racedCars)
                .extracting(Car::getDistance)
                .containsExactly(ONE_FORWARD, ONE_FORWARD);
    }

    @Test
    @DisplayName("[예외] 1미만의 시도 횟수를 입력받을 경우, 예외를 발생시킨다")
    void test_throw_invalid_try_count() {
        //given
        NumberPickerBase picker = NumberPickerFixture.movablePicker();
        RaceProcessor processor = new RaceProcessor(picker);
        //when
        int tryCount = 0;
        //then
        Assertions.assertThatThrownBy(() -> processor.validateTryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.TRY_COUNT_MUST_BE_POSITIVE.message());
    }
}
