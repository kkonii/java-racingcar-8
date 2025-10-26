package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.Error;
import racingcar.fixture.CarFixture;
import racingcar.fixture.NumberPickerFixture;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"우리", "나라", "굿"})
    @DisplayName("[성공] 5자 이하의 이름을 가진 객체를 생성한다")
    void test_valid_name(String validLengthName) {
        Assertions.assertDoesNotThrow(() -> Car.withName(validLengthName));
    }

    @Test
    @DisplayName("[경계값 테스트 성공] 5자 이름의 객체 생성에 성공한다")
    void test_boundary() {
        //when
        String boundaryLength = "다섯자임둥";
        //then
        Assertions.assertDoesNotThrow(() -> Car.withName(boundaryLength));
    }

    @Test
    @DisplayName("[예외] 최대 글자수를 초과하는 이름의 객체 생성 시 예외를 발생시킨다")
    void test_invalid_name() {
        //when
        String overLengthName = "일곱글자자동차";
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> Car.withName(overLengthName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", " "})
    void test_blank_name(String blankName) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Car.withName(blankName));
    }

    @ParameterizedTest
    @ValueSource(strings = {",", "+", "=", "&", "/", "🤔"})
    @DisplayName("[예외] 특수 기호, 이모지를 이름으로 입력하면 예외를 발생시킨다")
    void test_invalid_pattern(String invalidPatternName) {
        Assertions.assertThrowsExactly(IllegalArgumentException.class,
                () -> Car.withName(invalidPatternName),
                Error.NAME_IS_NOT_VALID_PATTERN.message());
    }

    @ParameterizedTest
    @ValueSource(strings = {"가 능", "ㄱ", "a", "넘버9"})
    @DisplayName("[성공] 한글, 영어, 숫자, 띄어쓰기로 이루어진 이름은 검증을 통과하여 객체 생성에 성공한다")
    void test_valid_pattern(String validPatternName) {
        Assertions.assertDoesNotThrow(() -> Car.withName(validPatternName));
    }

    @Test
    @DisplayName("[성공] 랜덤 숫자가 4 이상이면 전진한다")
    void test_judge_movable() {
        //given
        Car car = Car.withName("전진하는차");
        //when
        NumberPickerBase movablePicker = NumberPickerFixture.movablePicker();
        int movableNumber = movablePicker.pick();
        car.move(movableNumber);
        //then
        Assertions.assertEquals(car.getDistance(), 1);
    }

    @Test
    @DisplayName("[성공] 랜덤 숫자가 4 미만이면 멈춘다")
    void test_judge_not_movable() {
        //given
        Car car = Car.withName("멈추는차");
        //when
        NumberPickerBase unmovablePicker = NumberPickerFixture.unmovablePicker();
        int unmovableNumber = unmovablePicker.pick();
        car.move(unmovableNumber);
        //then
        org.assertj.core.api.Assertions.assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("[성공] 자동차가 자신이 이동한 거리와 입력받은 값 중 최대값을 찾는 데에 성공한다")
    void test_max_value() {
        int maxDistance = 5;
        Car moved = CarFixture.moved();
        //then
        Assertions.assertEquals(moved.compareWith(maxDistance), maxDistance);
    }
}
