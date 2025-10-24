package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    @DisplayName("[성공] 랜덤 숫자가 4이상이면 true 를 반환한다")
    void test_judge_movable() {
        //given
        Car car = Car.withName("움직여라");
        //when
        int movableNumber = 4;
        //then
        Assertions.assertTrue(car.isMovable(movableNumber));
    }

    @Test
    @DisplayName("[성공] 랜덤 숫자가 4 미만이면 false 를 반환한다")
    void test_judge_not_movable() {
        //given
        Car car = Car.withName("움직여라");
        //when
        int movableNumber = 2;
        //then
        Assertions.assertFalse(car.isMovable(movableNumber));
    }

    @Test
    @DisplayName("[성공] 자동차가 전진에 성공한다")
    void test_moving() {
        //given
        Car car = Car.withName("테스트용");
        int randomNumber = 5;

        //when
        boolean isMovable = car.isMovable(randomNumber);

        //then
        org.assertj.core.api.Assertions.assertThat(car.move(isMovable)).isEqualTo(1);
    }
}
