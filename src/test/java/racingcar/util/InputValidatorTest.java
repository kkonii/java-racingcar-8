package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", "     ", "\n", "\t", ""})
    @DisplayName("[예외] 공백 값에 대해서는 예외를 발생시킨다")
    void test_throw_for_blank(String blankValue) {
        //then
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> InputValidator.blankValue(blankValue));
    }
}
