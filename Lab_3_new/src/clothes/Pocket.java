package clothes;

import items.Item;

import java.util.ArrayList;
import java.util.Objects;

public class Pocket {
    private ArrayList<Item> things;
    public Pocket(){
        things = new ArrayList<>();
    }

    public void addToPocket(Item thing) {
        if (things.contains(thing)) {return;}
        things.add(thing);
        System.out.println();
    }

    public Item claimItem(String className){
        for(Item item: things){
           if(item.getClass().getName().equals(className)){
               things.remove(item);
               return item;
           }
        }
        return null;
    }

    public Item checkItem(String className){
        for(Item item: things){
            if(item.getClass().getName().equals(className)){
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pocket pocket)) return false;
        return Objects.equals(things, pocket.things);
    }

    @Override
    public int hashCode() {
        return Objects.hash(things);
    }

    @Override
    public String toString() {
        return "Pocket{" +
                "things=" + things +
                '}';
    }
}
