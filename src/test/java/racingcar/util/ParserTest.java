package racingcar.util;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"1-1", "---1", "1+2", "aa", "마마"})
    @DisplayName("[예외] 숫자로만 이루어지지 않은 문자열을 변환하면 예외를 발생시킨다")
    void throw_about_not_numeric() {
        //when
        String notNumeric = "baka";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> Parser.toInteger(notNumeric));
    }

    @ParameterizedTest
    @CsvSource(value = {"-1,-1", "0,0", "+1,1"})
    @DisplayName("[성공] 숫자로만 이루어진 문자열을 변환하는 데에 성공한다")
    void test_parsing_numeric(String consoleInput, int parsedInput) {
        //then
        Assertions.assertEquals(Parser.toInteger(consoleInput), parsedInput);
    }

    @Test
    @DisplayName("[성공] 지정된 구분자로 정확하게 이름을 구분하는 데에 성공한다")
    void test_separate_name_without_delimiter() {
        //given
        String consoleInput = "포비, 워니 ,준";
        List<String> names = Parser.toNames(consoleInput);

        //then
        org.assertj.core.api.Assertions.assertThat(names).containsExactly("포비", "워니", "준");
    }
}
