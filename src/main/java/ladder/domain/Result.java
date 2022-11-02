package ladder.domain;

import ladder.domain.ladder.LadderLines;
import ladder.domain.person.Person;

import java.util.*;
import java.util.List;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;

public class Result {

    private final Map<Person, Reward> result;

    public Result(LadderLines ladderLines, Rewards rewards, List<Person> personList) {
        this.result = new HashMap<>();
        personList.forEach(
                person -> result.put(person, rewards.reward(ladderLines.ladderClimbResultPosition(person.position()))));
    }

    public Reward result(Person person) {
        return result.get(person);
    }

    public Map<Person, Reward> result() {
        return Collections.unmodifiableMap(result);
    }
}
