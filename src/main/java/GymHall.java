package at.htlleonding.stirnreihe;

public class GymHall {

    at.htlleonding.stirnreihe.Person head;


    public GymHall() {

    }

    public at.htlleonding.stirnreihe.Person getHead() {
        return head;
    }

    public void setHead(at.htlleonding.stirnreihe.Person head) {
        this.head = head;
    }

    public boolean isEmpty() {
        if (head == null){
            return true;
        } else {
            return false;
        }
    }

    public at.htlleonding.stirnreihe.Person removePersonOnFirstPosition() {
        at.htlleonding.stirnreihe.Person personToRemove = head;
        if (personToRemove == null){
            throw new RuntimeException("GymHall is empty");
        } else if (head.getNext() == null){
            head = null;
        }else {
            head = head.getNext();
        }
        return personToRemove;
    }

    public void addPersonOnFirstPosition(at.htlleonding.stirnreihe.Person newPerson) {
        if (head == null){
            head = newPerson;
        } else {
            at.htlleonding.stirnreihe.Person placeholder = head;
            head = newPerson;
            head.setNext(placeholder);

        }


    }

    // die Reihenfolge der Stirnreihe umdrehen
    public void reverseForeheadRow() {

        at.htlleonding.stirnreihe.Person prevPerson = null;
        at.htlleonding.stirnreihe.Person currentPerson = head;

        while (currentPerson != null) {
            at.htlleonding.stirnreihe.Person nextPerson = currentPerson.getNext();
            currentPerson.setNext(prevPerson);
            prevPerson = currentPerson;
            currentPerson = nextPerson;
        }
    }


    // anhand der Größe sortieren, dh die kleinste Person ist am Anfang (head)
    public void addPersonSortedBySize(at.htlleonding.stirnreihe.Person newPerson) {
        if (head == null){
            setHead(newPerson);
        } else if (newPerson.getSizeInCm() < head.getSizeInCm()){
            newPerson.setNext(head);
            head = newPerson;
        } else {
            at.htlleonding.stirnreihe.Person currentPerson = head;
            boolean valid = true;
            while (currentPerson.getNext() != null && valid == true){
                if (newPerson.getSizeInCm() < currentPerson.getNext().getSizeInCm()) {
                    newPerson.setNext(currentPerson.getNext());
                    currentPerson.setNext(newPerson);
                    valid = false;
                } else {
                    currentPerson = currentPerson.getNext();
                }
            }
            if (valid == true){
                currentPerson.setNext(newPerson);
            }
        }

        // Wenn die Liste nur ein Element hat


        // Wenn das neue Element kleiner als das erste Element ist


        // Für alle anderen Fälle


    }


}
