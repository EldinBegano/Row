package at.htlleonding.stirnreihe;

public class Person {

    String name;
    int sizeInCm;
    Person next;

    public Person() {
    }

    public Person(String name, int sizeInCm) {
        this.name = name;
        this.sizeInCm = sizeInCm;
    }

    //region getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSizeInCm() {
        return sizeInCm;
    }

    public void setSizeInCm(int sizeInCm) {
        this.sizeInCm = sizeInCm;
    }

    public Person getNext() {
        return next;
    }

    public void setNext(Person next) {
        this.next = next;
    }
    //endregion


    @Override
    public String toString() {
        return String.format("%s (%d cm)", getName(), getSizeInCm());
    }


}
