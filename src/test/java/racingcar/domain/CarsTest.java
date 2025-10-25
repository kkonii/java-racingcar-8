package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.fixture.CarFixture;
import racingcar.fixture.NumberPickerFixture;

public class CarsTest {

    @Test
    @DisplayName("[성공] 자동차들의 이동 거리 중 가장 큰 값을 구하는 데에 성공한다")
    void test_max_distance() {
        //when
        Cars cars = new Cars(List.of(CarFixture.moved(), CarFixture.stopped()));
        //then
        Assertions.assertThat(cars.findMaxDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("[성공] 가장 멀리 이동한 자동차들만 찾는 데에 성공한다")
    void test_find_winners() {
        //given
        Car car1 = CarFixture.moved();
        Car car2 = CarFixture.stopped();
        Car car3 = CarFixture.moved();
        NumberPickerBase movablePicker = NumberPickerFixture.movablePicker();

        //when
        car1.move(movablePicker.pick());
        car3.move(movablePicker.pick());

        //then
        Cars cars = new Cars(List.of(car1, car2, car3));
        Assertions.assertThat(cars.findWinners()).containsExactly(car1, car3);
    }

    @Test
    @DisplayName("[성공] 참가한 자동차들 모두 전진 혹은 멈춤을 한 번씩 실행한다")
    void test_race_for_one_round() {
        //then
        NumberPickerBase movablePicker = NumberPickerFixture.movablePicker();
        Cars cars = new Cars(List.of(CarFixture.stopped(), CarFixture.moved()));

        //when
        List<Integer> distance = cars.move(movablePicker);

        //then
        Assertions.assertThat(distance).containsExactly(1, 2);
    }
}
