package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameFilter {

    private static final String DELIMITER = ",";

    public List<String> filterAll(String consoleInput) {
        return Arrays.stream(consoleInput.split(DELIMITER))
                .collect(Collectors.toList());
    }
}
