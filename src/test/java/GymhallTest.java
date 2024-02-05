import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GymHallTest {

    @Order(10)
    @Test
    void givenEmptyGymHall_whenAddingAPersonOnFirstPosition_thenPersonIsOnFirstPosition() {
        GymHall gymHall = new GymHall();
        at.htlleonding.stirnreihe.Person simon = new at.htlleonding.stirnreihe.Person("Simon", 180);
        gymHall.addPersonOnFirstPosition(simon);
        assertThat(gymHall.getHead()).isEqualTo(simon);
        assertThat(gymHall.getHead().getNext()).isNull();
    }

    @Order(20)
    @Test
    void givenGymHallWithOnePerson_whenAddingAPersonOnFirstPosition_thenPersonIsOnFirstPosition() {
        // arrange
        GymHall gymHall = new GymHall();
        at.htlleonding.stirnreihe.Person simon = new at.htlleonding.stirnreihe.Person("Simon", 180);
        gymHall.addPersonOnFirstPosition(simon);

        // act
        at.htlleonding.stirnreihe.Person miriam = new at.htlleonding.stirnreihe.Person("Miriam", 170);
        gymHall.addPersonOnFirstPosition(miriam);

        // assert
        assertThat(gymHall.getHead()).isEqualTo(miriam);
        assertThat(gymHall.getHead().getNext()).isEqualTo(simon);
        assertThat(gymHall.getHead().getNext().getNext()).isNull();
    }

    @Order(30)
    @Test
    void givenGymHallWithTwoPersons_whenAddingAPersonOnFirstPosition_thenPersonIsOnFirstPosition() {
        // arrange
        GymHall gymHall = new GymHall();
        at.htlleonding.stirnreihe.Person simon = new at.htlleonding.stirnreihe.Person("Simon", 180);
        gymHall.addPersonOnFirstPosition(simon);
        at.htlleonding.stirnreihe.Person miriam = new at.htlleonding.stirnreihe.Person("Miriam", 170);
        gymHall.addPersonOnFirstPosition(miriam);

        // act
        at.htlleonding.stirnreihe.Person jakob = new at.htlleonding.stirnreihe.Person("Jakob", 187);
        gymHall.addPersonOnFirstPosition(jakob);

        // assert
        assertThat(gymHall.getHead()).isEqualTo(jakob);
        assertThat(gymHall.getHead().getNext()).isEqualTo(miriam);
        assertThat(gymHall.getHead().getNext().getNext()).isEqualTo(simon);
        assertThat(gymHall.getHead().getNext().getNext().getNext()).isNull();
    }

    @Order(40)
    @Test
    void givenEmptyGymHall_whenRemovingAPerson_thenExceptionIsThrown() {
        // arrange
        GymHall gymHall = new GymHall();

        // act + assert
        assertThatThrownBy(
                () -> gymHall.removePersonOnFirstPosition()
        ).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("GymHall is empty");
    }

    @Order(50)
    @Test
    void givenGymHallWithOnePerson_whenRemovingAPerson_thenGymHallIsEmpty() {
        // arrange
        GymHall gymHall = new GymHall();
        at.htlleonding.stirnreihe.Person simon = new at.htlleonding.stirnreihe.Person("Simon", 180);
        gymHall.addPersonOnFirstPosition(simon);

        at.htlleonding.stirnreihe.Person personToRemove = gymHall.removePersonOnFirstPosition();
        assertThat(gymHall.getHead()).isNull();
        assertThat(personToRemove).isEqualTo(simon);

    }

    @Order(50)
    @Test
    void givenGymHallWithFourPerson_whenRemovingAPerson_thenThreePersonsRemain() {
        // arrange
        GymHall gymHall = new GymHall();
        at.htlleonding.stirnreihe.Person julia165 = new at.htlleonding.stirnreihe.Person("Julia", 165);
        at.htlleonding.stirnreihe.Person jane170 = new at.htlleonding.stirnreihe.Person("Jane", 170);
        at.htlleonding.stirnreihe.Person john180 = new at.htlleonding.stirnreihe.Person("John", 180);
        at.htlleonding.stirnreihe.Person mike190 = new at.htlleonding.stirnreihe.Person("Mike", 190);
        gymHall.addPersonOnFirstPosition(julia165);
        gymHall.addPersonOnFirstPosition(jane170);
        gymHall.addPersonOnFirstPosition(john180);
        gymHall.addPersonOnFirstPosition(mike190);

        at.htlleonding.stirnreihe.Person personToRemove = gymHall.removePersonOnFirstPosition();
        assertThat(gymHall.getHead()).isEqualTo(john180);
        assertThat(personToRemove).isEqualTo(mike190);

        personToRemove = gymHall.removePersonOnFirstPosition();
        assertThat(gymHall.getHead()).isEqualTo(jane170);
        assertThat(personToRemove).isEqualTo(john180);

        personToRemove = gymHall.removePersonOnFirstPosition();
        assertThat(gymHall.getHead()).isEqualTo(julia165);
        assertThat(personToRemove).isEqualTo(jane170);

        personToRemove = gymHall.removePersonOnFirstPosition();
        assertThat(gymHall.getHead()).isNull();
        assertThat(personToRemove).isEqualTo(julia165);

    }


    @Order(970)
    @Test
    void givenEmptyGymHall_whenCheckIfIsEmpty_thenTrue() {
        GymHall gymHall = new GymHall();
        assertThat(gymHall.isEmpty()).isTrue();
    }

    @Order(980)
    @Test
    void givenGymHallWithOnePerson_whenCheckIfIsEmpty_thenFalse() {
        GymHall gymHall = new GymHall();
        gymHall.addPersonOnFirstPosition(new at.htlleonding.stirnreihe.Person("Simon", 180));
        assertThat(gymHall.isEmpty()).isFalse();
    }

    @Order(990)
    @Test
    public void givenGymHallWithFourPersons_whenReversingORderOfForeheadRow_thenOrderMustBeDescending() {
        GymHall gymHall = new GymHall();
        at.htlleonding.stirnreihe.Person julia165 = new at.htlleonding.stirnreihe.Person("Julia", 165);
        at.htlleonding.stirnreihe.Person jane170 = new at.htlleonding.stirnreihe.Person("Jane", 170);
        at.htlleonding.stirnreihe.Person john180 = new at.htlleonding.stirnreihe.Person("John", 180);
        at.htlleonding.stirnreihe.Person mike190 = new at.htlleonding.stirnreihe.Person("Mike", 190);
        gymHall.addPersonOnFirstPosition(mike190);
        gymHall.addPersonOnFirstPosition(john180);
        gymHall.addPersonOnFirstPosition(jane170);
        gymHall.addPersonOnFirstPosition(julia165);
        gymHall.reverseForeheadRow();
        assertThat(mike190).isEqualTo(gymHall.getHead());
        assertThat(john180).isEqualTo(gymHall.getHead().getNext());
        assertThat(jane170).isEqualTo(gymHall.getHead().getNext().getNext());
        assertThat(julia165).isEqualTo(gymHall.getHead().getNext().getNext().getNext());
    }

    @Order(1000)
    @Test
    void givenAnEmptyGymHall_whenAddingAPerson_thenThePersonIsInTheGymHall() {
        var turnsaal = new GymHall();

        at.htlleonding.stirnreihe.Person eldin = new at.htlleonding.stirnreihe.Person("Eldin", 180);
        turnsaal.addPersonSortedBySize(eldin);
        assertThat(turnsaal.getHead()).isEqualTo(eldin);
    }


    @Order(1100)
    @Test
    public void givenGymHallWithOnePerson_whenAddingASmallerPerson_thenNewPersonIsOnFirstPosition() {
        // arrange
        GymHall gymHall = new GymHall();
        at.htlleonding.stirnreihe.Person john = new at.htlleonding.stirnreihe.Person("John", 180);

        // act
        at.htlleonding.stirnreihe.Person jane = new at.htlleonding.stirnreihe.Person("Jane", 170);
        gymHall.addPersonSortedBySize(john);
        gymHall.addPersonSortedBySize(jane);

        // assert
        assertThat(jane).isEqualTo(gymHall.getHead());
        assertThat(john).isEqualTo(gymHall.getHead().getNext());
    }

    @Order(1100)
    @Test
    public void givenGymHallWithOnePerson_whenAddingABiggerPerson_thenNewPersonIsOnSecondPosition() {
        // arrange
        GymHall gymHall = new GymHall();
        at.htlleonding.stirnreihe.Person john = new at.htlleonding.stirnreihe.Person("John", 180);

        // act
        at.htlleonding.stirnreihe.Person jane = new at.htlleonding.stirnreihe.Person("Jane", 170);
        gymHall.addPersonSortedBySize(jane);
        gymHall.addPersonSortedBySize(john);

        // assert
        assertThat(jane).isEqualTo(gymHall.getHead());
        assertThat(john).isEqualTo(gymHall.getHead().getNext());
    }

    @Order(1200)
    @Test
    public void givenEmptyGymHall_whenAddingThreePersons_thenOrderMustBeAscending() {
        GymHall gymHall = new GymHall();
        at.htlleonding.stirnreihe.Person john = new at.htlleonding.stirnreihe.Person("John", 180);
        at.htlleonding.stirnreihe.Person jane = new at.htlleonding.stirnreihe.Person("Jane", 170);
        at.htlleonding.stirnreihe.Person mike = new at.htlleonding.stirnreihe.Person("Mike", 190);
        gymHall.addPersonSortedBySize(john);
        gymHall.addPersonSortedBySize(jane);
        gymHall.addPersonSortedBySize(mike);
        assertThat(jane).isEqualTo(gymHall.getHead());
        assertThat(john).isEqualTo(gymHall.getHead().getNext());
        assertThat(mike).isEqualTo(gymHall.getHead().getNext().getNext());
    }

    @Test
    @Order(1300)
    public void givenEmptyGymHall_whenAddingTwoPersonsWithSameSize_thenTheOrderDoesntMatter() {
        GymHall gymHall = new GymHall();
        at.htlleonding.stirnreihe.Person person1 = new at.htlleonding.stirnreihe.Person("John", 180);
        at.htlleonding.stirnreihe.Person person2 = new at.htlleonding.stirnreihe.Person("Jane", 180);
        gymHall.addPersonSortedBySize(person1);
        gymHall.addPersonSortedBySize(person2);
        // The order doesn't matter, so the names are collected and checked
        List<String> names = new LinkedList<>();
        names.add(gymHall.getHead().getName());
        names.add(gymHall.getHead().getNext().getName());
        assertThat(gymHall.getHead().getNext().getNext()).isNull();
        assertThat(names).containsExactlyInAnyOrder("John", "Jane");
    }


    @Order(1400)
    @Test
    public void givenEmptyGymHall_whenAdding4Persons_thenOrderMustBeAscending1() {
        GymHall gymHall = new GymHall();
        at.htlleonding.stirnreihe.Person john180 = new at.htlleonding.stirnreihe.Person("John", 180);
        at.htlleonding.stirnreihe.Person jane170 = new at.htlleonding.stirnreihe.Person("Jane", 170);
        at.htlleonding.stirnreihe.Person mike190 = new at.htlleonding.stirnreihe.Person("Mike", 190);
        at.htlleonding.stirnreihe.Person julia165 = new at.htlleonding.stirnreihe.Person("Julia", 165);
        gymHall.addPersonSortedBySize(julia165);
        gymHall.addPersonSortedBySize(jane170);
        gymHall.addPersonSortedBySize(john180);
        gymHall.addPersonSortedBySize(mike190);
        assertThat(julia165).isEqualTo(gymHall.getHead());
        assertThat(jane170).isEqualTo(gymHall.getHead().getNext());
        assertThat(john180).isEqualTo(gymHall.getHead().getNext().getNext());
        assertThat(mike190).isEqualTo(gymHall.getHead().getNext().getNext().getNext());
    }

    @Order(1500)
    @Test
    public void givenEmptyGymHall_whenAdding4Persons_thenOrderMustBeAscending2() {
        GymHall gymHall = new GymHall();
        at.htlleonding.stirnreihe.Person john180 = new at.htlleonding.stirnreihe.Person("John", 180);
        at.htlleonding.stirnreihe.Person jane170 = new at.htlleonding.stirnreihe.Person("Jane", 170);
        at.htlleonding.stirnreihe.Person mike190 = new at.htlleonding.stirnreihe.Person("Mike", 190);
        at.htlleonding.stirnreihe.Person julia165 = new at.htlleonding.stirnreihe.Person("Julia", 165);
        gymHall.addPersonSortedBySize(mike190);
        gymHall.addPersonSortedBySize(john180);
        gymHall.addPersonSortedBySize(jane170);
        gymHall.addPersonSortedBySize(julia165);
        assertThat(julia165).isEqualTo(gymHall.getHead());
        assertThat(jane170).isEqualTo(gymHall.getHead().getNext());
        assertThat(john180).isEqualTo(gymHall.getHead().getNext().getNext());
        assertThat(mike190).isEqualTo(gymHall.getHead().getNext().getNext().getNext());
    }

    @Order(1600)
    @Test
    public void givenEmptyGymHall_whenAdding4Persons_thenOrderMustBeAscending3() {
        GymHall gymHall = new GymHall();
        at.htlleonding.stirnreihe.Person john180 = new at.htlleonding.stirnreihe.Person("John", 180);
        at.htlleonding.stirnreihe.Person jane170 = new at.htlleonding.stirnreihe.Person("Jane", 170);
        at.htlleonding.stirnreihe.Person mike190 = new at.htlleonding.stirnreihe.Person("Mike", 190);
        at.htlleonding.stirnreihe.Person julia165 = new at.htlleonding.stirnreihe.Person("Julia", 165);
        gymHall.addPersonSortedBySize(mike190);
        gymHall.addPersonSortedBySize(julia165);
        gymHall.addPersonSortedBySize(john180);
        gymHall.addPersonSortedBySize(jane170);
        assertThat(julia165).isEqualTo(gymHall.getHead());
        assertThat(jane170).isEqualTo(gymHall.getHead().getNext());
        assertThat(john180).isEqualTo(gymHall.getHead().getNext().getNext());
        assertThat(mike190).isEqualTo(gymHall.getHead().getNext().getNext().getNext());
    }

    @Order(1700)
    @Test
    public void givenEmptyGymHall_whenAdding4Persons_thenOrderMustBeAscending4() {
        GymHall gymHall = new GymHall();
        at.htlleonding.stirnreihe.Person john180 = new at.htlleonding.stirnreihe.Person("John", 180);
        at.htlleonding.stirnreihe.Person jane170 = new at.htlleonding.stirnreihe.Person("Jane", 170);
        at.htlleonding.stirnreihe.Person mike190 = new at.htlleonding.stirnreihe.Person("Mike", 190);
        at.htlleonding.stirnreihe.Person julia165 = new at.htlleonding.stirnreihe.Person("Julia", 165);
        gymHall.addPersonSortedBySize(jane170);
        gymHall.addPersonSortedBySize(mike190);
        gymHall.addPersonSortedBySize(john180);
        gymHall.addPersonSortedBySize(julia165);
        assertThat(julia165).isEqualTo(gymHall.getHead());
        assertThat(jane170).isEqualTo(gymHall.getHead().getNext());
        assertThat(john180).isEqualTo(gymHall.getHead().getNext().getNext());
        assertThat(mike190).isEqualTo(gymHall.getHead().getNext().getNext().getNext());
    }



}