package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameFilterTest {

    @Test
    @DisplayName("[성공] 지정된 구분자로 정확하게 구분하는 데에 성공한다")
    void test_separate_name_without_delimiter() {
        //given
        CarNameFilter nameFilter = new CarNameFilter();

        //when
        String consoleInput = "포비,워니,준";
        List<String> splitNames = nameFilter.filterAll(consoleInput);

        //then
        Assertions.assertThat(splitNames).containsExactly("포비", "워니", "준");
    }
}
