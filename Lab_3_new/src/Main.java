import clothes.ClothesWithPocket;
import items.Cigarette;
import items.Lighter;
import persons.Emotions;
import persons.Human;
import persons.Karlson;
import rooms.Door;
import rooms.Room;

public class Main {
    public static void main(String[] args) {
        Room livingRoom = new Room("livingRoom");
        Door door = new Door(livingRoom);
        Human baby = new Human("Baby");

        Karlson karlson = new Karlson("karlosonchik");
        ClothesWithPocket tShirt = new ClothesWithPocket("T-shirt with chest pocket");
        ClothesWithPocket jeans = new ClothesWithPocket("jeans");

        karlson.putOnClothesWithPockets(tShirt);
        karlson.putOnClothesWithPockets(jeans);

        Lighter lighter = new Lighter("зажига");
        Cigarette cigar = new Cigarette("сигерата", "парламент");

        karlson.putItemInClothe(jeans, lighter);
        karlson.putItemInClothe(tShirt, cigar);

        if(karlson.checkFromPocket(cigar)) {
           baby.setEmotions(Emotions.AMAZED);
        }

        karlson.toSmoke();

        karlson.knock(door);
        karlson.enter(door);

        karlson.burnOut();
    }
}