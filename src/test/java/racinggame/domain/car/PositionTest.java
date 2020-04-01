package racinggame.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PositionTest {

    @DisplayName("동일한 매개변수를 전달하면 같은 것으로 비교한다")
    @Test
    public void constructor() throws Exception {
        //given
        Position position1 = new Position(1);
        Position position2 = new Position(1);

        //then
        assertThat(position1.equals(position2)).isTrue();
    }
}

