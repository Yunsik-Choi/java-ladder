package ladder.domain.person;

import ladder.domain.person.name.SearchPeopleNames;
import ladder.exception.person.PeopleSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class PeopleTest {

    @Test
    void valid_size() {
        assertThatThrownBy(() -> new People("pobi")).isInstanceOf(PeopleSizeException.class);
    }

    @DisplayName("같은 이름이 여러번 입력됐을 경우 하나만 반환한다.")
    @Test
    void find_persons_distinct() {
        People people = new People("pobi", "crong", "sik");

        assertAll(
                () -> assertThat(people.findAllBySearchPeopleNames(new SearchPeopleNames("pobi", "pobi")))
                        .contains(new Person("pobi", 0, 0)),
                () -> assertThat(people.findAllBySearchPeopleNames(new SearchPeopleNames("pobi", "pobi")).size())
                        .isEqualTo(1)
        );
    }

    @Test
    void find_persons() {
        People people = new People("pobi", "crong", "sik");

        assertAll(
                () -> assertThat(people.findAllBySearchPeopleNames(new SearchPeopleNames("crong")))
                        .contains(new Person("crong", 1, 0)),
                () -> assertThat(people.findAllBySearchPeopleNames(new SearchPeopleNames("pobi", "crong")))
                        .contains(new Person("pobi", 0, 0), new Person("crong", 1, 0)),
                () -> assertThat(people.findAllBySearchPeopleNames(new SearchPeopleNames("all")))
                        .contains(new Person("pobi", 0, 0), new Person("crong", 1, 0),
                                new Person("sik", 2, 0))
        );
    }
}
