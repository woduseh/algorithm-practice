package practice.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalcTugOfWarTest {

    CalcTugOfWar tugOfWar = new CalcTugOfWar();

    @Test
    @DisplayName("줄다리기")
    void checkAnswer() {
        // given
        var rightAnswer = new int[]{3, 90};
        var wrongAnswer = new int[]{2, 90};

        // when
        var result = tugOfWar.solution(new int[]{90, 35, 55, 90});

        // then
        assertThat(result).isEqualTo(rightAnswer)
                .isNotEqualTo(wrongAnswer);
    }
}
