package items;

import interfaces.ToBurn;

public class Lighter extends Item implements ToBurn {
    public Lighter(String name){super(name);}

    @Override
    public void burn(Item thing){
        System.out.println(getName() + " burn " + thing.getName());
        thing.burnable();
    }
}