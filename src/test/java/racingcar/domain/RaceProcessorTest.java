package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        List<Integer> movedDistances = processor.runOneRound(cars);

        //then
        Assertions.assertThat(movedDistances).containsExactly(ONE_FORWARD, ONE_FORWARD);
    }
}
