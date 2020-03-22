package racinggame.domain.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racinggame.domain.expression.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class RacingTest {

    private static Stream<Arguments> provideConstructParam() {
        return Stream.of(
                Arguments.of(1, 1, new ArrayList<String>(Arrays.asList("a"))),
                Arguments.of(2, 2, new ArrayList<String>(Arrays.asList("a", "b"))),
                Arguments.of(3, 3, new ArrayList<String>(Arrays.asList("a", "b", "c"))),
                Arguments.of(4, 4, new ArrayList<String>(Arrays.asList("a", "b", "c", "d")))
        );
    }

    @DisplayName("생성자 테스트")
    @ParameterizedTest
    @MethodSource("provideConstructParam")
    public void construct(int carCount, int gameCount, List<String> carNames) throws Exception {
        //then
        new Racing(carCount, gameCount, carNames);
    }

    @DisplayName("---------------------------test")
    @ParameterizedTest
    @MethodSource("provideConstructParam")
    public void teset(int carCount, int gameCount, List<String> carNames) throws Exception {
        //given
        Racing racing = new Racing(carCount, gameCount, carNames);
        ResultView resultView = new ResultView(racing);

        //when
        racing.playAllRound();

        //then
        resultView.drawAllRoundResult();

        System.out.println("===============");

    }


}
