package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {" ", "     ", "\n", "\t"})
    @DisplayName("[예외] 공백 값에 대해서는 예외를 발생시킨다")
    void test_throw_for_blank(String blankValue) {
        //then
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> InputValidator.blankValue(blankValue));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi\\crong", "pobi-crong", ",crong", "pobi**crong"})
    @DisplayName("[예외] 문자 , 로 이루어지지 않은 패턴의 입력은 예외를 발생시킨다")
    void test_throw_for_name_fomat(String value) {
        //then
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> InputValidator.nameFormat(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pbi", "p,d", "poi,,j"})
    @DisplayName("[성공] 문자와 ,로 이루어진 패턴의 입력은 통과한다")
    void test_valid_name_pattern(String value) {
        Assertions.assertDoesNotThrow(() -> InputValidator.nameFormat(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-2147483649", "1000000000000000"})
    @DisplayName("[예외] 정수 범위를 벗어나는 입력값은 예외를 발생합니다")
    void test_not_integer_range(String value) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> InputValidator.rangeOf(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-2147483648", "2147483647"})
    @DisplayName("[성공] 정수 범위 경계값은 검증을 통과합니다")
    void test_integer_range(String value) {
        Assertions.assertDoesNotThrow(() -> InputValidator.rangeOf(value));
    }
}
