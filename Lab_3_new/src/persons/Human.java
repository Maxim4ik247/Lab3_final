package persons;

public class Human extends persons.Character {
    public Human(String name) {
        super(name);
    }
    public void feel(Emotions emotion){
        System.out.println(this + " is " + emotion.name());
    }
}
