package rooms;

import interfaces.Enterable;
import persons.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room implements Enterable {
    private String name;

    private ArrayList<persons.Character> visitors = new ArrayList<>();

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Character> getVisitors() {
        return visitors;
    }

    @Override
    public void enter(persons.Character visitor) {
        if (visitors.contains(visitor)) {return;}
        visitors.add(visitor);
        System.out.println( visitor.getName() + " is in the " + name);
    }
    public void removeVisitor(Character visitor) {
        visitors.remove(visitor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room room)) return false;
        return Objects.equals(name, room.name) && Objects.equals(visitors, room.visitors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, visitors);
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", visitors=" + visitors +
                '}';
    }
}
