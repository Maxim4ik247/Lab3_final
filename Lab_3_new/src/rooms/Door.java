package rooms;

import interfaces.Enterable;
import persons.Character;
import persons.Human;

import java.util.Objects;

public class Door implements Enterable {
    private Room room;

    public Door(Room room) {
        this.room = room;
    }

    @Override
    public void enter(Character character){
        System.out.println(character.getName() + " opened the door to " + room.getName());
        room.enter(character);
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Door door)) return false;
        return Objects.equals(room, door.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room);
    }

    @Override
    public String toString() {
        return "Door{" +
                "room=" + room +
                '}';
    }
}
