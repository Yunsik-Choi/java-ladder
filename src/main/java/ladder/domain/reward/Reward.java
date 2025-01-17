package ladder.domain.reward;

import java.util.Objects;

public class Reward {

    private final String reward;

    public Reward(String reward) {
        this.reward = reward;
    }

    public String reward() {
        return this.reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reward reward1 = (Reward) o;
        return Objects.equals(reward, reward1.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reward);
    }
}
