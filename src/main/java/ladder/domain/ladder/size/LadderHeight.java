package ladder.domain.ladder.size;

import ladder.exception.ladder.LadderHeightBoundException;

import java.util.Objects;

public class LadderHeight {

    private static final int LADDER_HEIGHT_MIN = 1;
    private final int height;

    public LadderHeight(int height) {
        validateLadderHeightBound(height);
        this.height = height;
    }

    private void validateLadderHeightBound(int height) {
        if (height < LADDER_HEIGHT_MIN) {
            throw new LadderHeightBoundException(LADDER_HEIGHT_MIN);
        }
    }

    public int height() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderHeight that = (LadderHeight) o;
        return height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
