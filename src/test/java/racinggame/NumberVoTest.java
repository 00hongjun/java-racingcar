package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberVoTest {

    @DisplayName("0~9 사이의 정수값 반환 하는지 테스트")
    @Test
    public void createRandomNumber() throws Exception {
        //given
        int i = 0;

        //then
        while (i < 100) {
            assertThat(NumberVo.createRandomNumber()).isBetween(0, 9);
            i++;
        }
    }


}