package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.fixture.CarFixture;

public class CarsTest {

    @Test
    @DisplayName("[성공] 자동차들의 이동 거리 중 가장 큰 값을 구하는 데에 성공한다")
    void test_max_distance() {
        //when
        Cars cars = new Cars(List.of(CarFixture.moved(), CarFixture.stopped()));
        //then
        Assertions.assertThat(cars.findMaxDistance()).isEqualTo(1);
    }
}
