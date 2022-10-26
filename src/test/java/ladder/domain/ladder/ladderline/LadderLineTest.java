package ladder.domain.ladder.ladderline;

import ladder.domain.ladder.Ladder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


public class LadderLineTest {

    @Test
    void create() {
        LadderLine ladderLine = new LadderLine(List.of(Ladder.NONE, Ladder.NONE));

        assertThat(ladderLine).isEqualTo(new LadderLine(List.of(Ladder.NONE, Ladder.NONE)));
    }


    private static Stream<Arguments> provideToString() {
        return Stream.of(
                Arguments.of(new LadderLine(List.of(Ladder.RIGHT, Ladder.LEFT)), "    |-----|"),
                Arguments.of(new LadderLine(List.of(Ladder.NONE, Ladder.NONE)), "    |     |")
        );
    }

    @ParameterizedTest
    @MethodSource("provideToString")
    void custom_toString(LadderLine ladderLine, String expected) {
        assertThat(ladderLine.toString()).isEqualTo(expected);
    }
}