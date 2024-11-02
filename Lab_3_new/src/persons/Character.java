package persons;

import clothes.Clothes;
import clothes.ClothesWithPocket;
import interfaces.*;
import items.Cigarette;
import items.Item;
import items.Lighter;
import rooms.Door;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Character implements ToKnock, ToEnter, ToSmoke {
    private String name;
    private Emotions emotions = Emotions.HAPPY;
    private ArrayList<ClothesWithPocket> clothesWithPockets = new ArrayList<>();
    private ArrayList<Clothes> clothesWithoutPockets = new ArrayList<>();
    private boolean isSmoking;

    public Character(String name) {
        this.name = name;
    }

    public void toSmoke(){
        Cigarette cigarette = (Cigarette) takeFromPocket(new Cigarette("сигарета"));
        Lighter lighter = (Lighter) takeFromPocket(new Lighter(""));
        if (cigarette == null || lighter == null){
            System.out.println(getName() + " can`t smoke ");
        } else {
            lighter.burn(cigarette);
            System.out.println(getName() + " is smoking");
            isSmoking = true;
        }
    }

    public void burnOut(){
        if (isSmoking){
            System.out.println(getName() + " blows smoke from a cigarette");
        } else {
            System.out.println(getName() + " isn`t smoking");
        }
    }

    public Item takeFromPocket(Item itemForFind) {
        for (Clothes i : clothesWithPockets) {
            Item item = i.getPocket().claimItem(itemForFind.getClass().getName());
            if (item == null) {
                continue;
            } else if (item.getClass().equals(itemForFind.getClass())) {
                System.out.println(getName() + " found " + item.getName() + " in " + i.getName());
                return item;
            }
        }
        System.out.println(getName() + " did not found " + itemForFind.getClass().getName());
        return null;
    }

    public boolean checkFromPocket(Item itemForFind) {
        for (Clothes i : clothesWithPockets) {
            Item item = i.getPocket().checkItem(itemForFind.getClass().getName());
            if (item == null) {
                continue;
            } else if (item.getClass().equals(itemForFind.getClass())) {
                System.out.println(getName() + " found " + item.getName() + " in " + i.getName());
                return true;
            }
        }
        return false;
    }


    public void putOnClothesWithPockets(ClothesWithPocket clothes1) {
        if (clothesWithPockets.contains(clothes1)) {
            System.out.println(clothes1.getName() + " is already put on");
        } else {
            clothesWithPockets.add(clothes1);
            System.out.println(getName() + " put on " + clothes1.getName());
        }
    }

    public void takeOffClothesWithPockets(ClothesWithPocket clothes1) {
        if (clothesWithPockets.contains(clothes1)) {
            clothesWithPockets.remove(clothes1);
            System.out.println(clothes1.getName() + " is removed");
        } else {
            System.out.println(clothes1.getName() + " is not on");
        }
    }

    public void putOnClothes(Clothes clothes1) {
        if (clothesWithoutPockets.contains(clothes1)) {
            System.out.println(clothes1.getName() + " is already put on");
        } else {
            clothesWithoutPockets.add(clothes1);
            System.out.println(getName() + " put on " + clothes1.getName());
        }
    }

    public void takeOffClothes(Clothes clothes1) {
        if (clothesWithoutPockets.contains(clothes1)) {
            clothesWithoutPockets.remove(clothes1);
            System.out.println(clothes1.getName() + " is removed");
        } else {
            System.out.println(clothes1.getName() + " is not on");
        }
    }

    public void putItemInClothe(ClothesWithPocket clothe, Item item){
        for (Clothes i : clothesWithPockets) {
            if (i.getName().equals(clothe.getName())){
                i.getPocket().addToPocket(item);
                System.out.println(getName() + " put in " + item.getName() + " into " + i.getName() + " pocket");
                return;
            }
        }
        System.out.println(getName() + " haven't got " + clothe.getName());
    }

    @Override
    public void knock(Door door) {
        System.out.println(this.getName() + " knocks door");
        if (door.getRoom().getVisitors().isEmpty()) {
            System.out.println("Nobody answers");
            this.setEmotions(Emotions.ANGRY);
        } else {
            System.out.println("Somebody says enter");
        }
        System.out.println();
    }

    @Override
    public void enter(Enterable place) {
        place.enter(this);
        System.out.println();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(name, character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public Emotions getEmotions() {
        return emotions;
    }

    public void setEmotions(Emotions emotions) {
        System.out.println(name + " was " + this.emotions + " but now is " + emotions);
        this.emotions = emotions;
    }
}
