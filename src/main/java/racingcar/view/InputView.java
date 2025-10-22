package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ENTER_INPUT_TO_RACE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public String getConsoleInput() {
        System.out.println(ENTER_INPUT_TO_RACE);

        return Console.readLine();
    }
}
